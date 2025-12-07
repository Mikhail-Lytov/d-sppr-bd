package com.lytov.diplom.dspprbd.infra.api;

import com.lytov.diplom.dspprbd.infra.dto.request.PresignPostRequestDTO;
import com.lytov.diplom.dspprbd.infra.dto.response.PresignedUploadResponse;
import com.lytov.diplom.dspprbd.service.v1.api.S3Service;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ApiS3ControllerImpl implements ApiS3Controller {
    private final S3Service s3Service;

    @Override
    public PresignedUploadResponse getUploadUrl(@RequestBody @Valid PresignPostRequestDTO request) {
        return s3Service.generatePresignedPutUrl(request.filename(), request.mimeType());
    }

    @Override
    public String getDownloadUrl(@PathVariable UUID id) {
        return s3Service.generatePresignedGetUrl(id);
    }
}
