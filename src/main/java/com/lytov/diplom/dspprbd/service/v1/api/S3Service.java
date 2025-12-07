package com.lytov.diplom.dspprbd.service.v1.api;


import com.lytov.diplom.dspprbd.infra.dto.response.PresignedUploadResponse;

import java.util.UUID;

public interface S3Service {

    PresignedUploadResponse generatePresignedPutUrl(String downloadName, String contentType);

    String generatePresignedGetUrl(UUID id);
}
