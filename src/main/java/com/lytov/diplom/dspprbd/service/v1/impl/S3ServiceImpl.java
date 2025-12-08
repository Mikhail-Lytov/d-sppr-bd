package com.lytov.diplom.dspprbd.service.v1.impl;

import com.lytov.diplom.dspprbd.domain.File;
import com.lytov.diplom.dspprbd.exception.DownloadUrlGenerationException;
import com.lytov.diplom.dspprbd.exception.UploadUrlGenerationException;
import com.lytov.diplom.dspprbd.service.v1.api.S3Service;
import com.lytov.diplom.dspprbd.infra.dto.response.PresignedUploadResponse;
import com.lytov.diplom.dspprbd.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.GetObjectPresignRequest;
import software.amazon.awssdk.services.s3.presigner.model.PresignedGetObjectRequest;
import software.amazon.awssdk.services.s3.presigner.model.PresignedPutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.model.PutObjectPresignRequest;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class S3ServiceImpl implements S3Service {

    private final S3Client s3Client;
    private final S3Presigner s3Presigner;
    private final FileRepository fileRepository;

    @Value("${s3.bucket}")
    private String bucket;

    @Value("${s3.expiry-minutes:10}")
    private Integer expiryMinutes;

    @Transactional
    public PresignedUploadResponse generatePresignedPutUrl(String downloadName, String contentType) {
        final String objectKey = UUID.randomUUID().toString();
        log.info("generatePresignedPutUrl start: downloadName {} contentType {} objectKey {}", downloadName, contentType, objectKey);
        try {
            PutObjectRequest putReq = PutObjectRequest.builder()
                    .bucket(bucket)
                    .key(objectKey)
                    .contentType(contentType)
                    .build();

            PresignedPutObjectRequest presignedPut = s3Presigner.presignPutObject(
                    PutObjectPresignRequest.builder()
                            .putObjectRequest(putReq)
                            .signatureDuration(Duration.ofMinutes(expiryMinutes))
                            .build()
            );

            File file = new File();
            file.setObjectKey(objectKey);
            file.setContentType(contentType);
            file.setOriginalName(downloadName);
            file.setDateCreate(Timestamp.from(Instant.now()));

            File entity = fileRepository.save(file);
            //String downloadUrl = generatePresignedGetUrl(downloadName, objectKey, contentType);
            log.info("generatePresignedPutUrl end: presignedPutUrl {} objectKey {} downloadUrl {}", presignedPut.url(), objectKey, null);
            return new PresignedUploadResponse(presignedPut.url().toString(), objectKey, null, entity.getId());
        } catch (Exception e) {
            log.error("generatePresignedPutUrl: Failed to generate an upload URL", e);
            throw new UploadUrlGenerationException(e.getMessage());
        }
    }

    public String generatePresignedGetUrl(UUID id) {
        try {
            File file = fileRepository.findById(id).orElseThrow();

            String safeName = file.getOriginalName().replace("\"", "");
            String contentDisposition =
                    "attachment; filename=\"%s\"; filename*=UTF-8''%s"
                            .formatted(safeName,
                                    URLEncoder.encode(file.getOriginalName(), StandardCharsets.UTF_8)
                            );

            GetObjectRequest getReq = GetObjectRequest.builder()
                    .bucket(bucket)
                    .key(file.getObjectKey())
                    .responseContentDisposition(contentDisposition)
                    .responseContentType(file.getContentType())
                    .build();

            PresignedGetObjectRequest presignedGet = s3Presigner.presignGetObject(
                    GetObjectPresignRequest.builder()
                            .getObjectRequest(getReq)
                            .signatureDuration(Duration.ofDays(7))
                            .build()
            );

            log.info("generatePresignedGetUrl end: url {}", presignedGet.url());
            return presignedGet.url().toString();
        } catch (Exception e) {
            log.error("generatePresignedGetUrl end: Failed to generate a download URL", e);
            throw new DownloadUrlGenerationException(e.getMessage());
        }
    }
}
