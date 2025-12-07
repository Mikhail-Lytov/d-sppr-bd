package com.lytov.diplom.dspprbd.infra.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

public record PresignedUploadResponse(
        @Schema(description = "Временный URL для загрузки файла в MinIO", example = "https://minio.local/my-bucket/uploads/uuid?X-Amz-Algorithm=AWS4-HMAC-SHA256...")
        String uploadUrl,

        @Schema(description = "Имя файла, под которым он будет сохранён в бакете", example = "uuid123")
        String objectName,

        @Schema(description = "Временный URL для скачивания файла из MinIO", example = "https://minio.local/my-bucket/uploads/uuid?X-Amz-Algorithm=AWS4-HMAC-SHA256...")
        String downloadUrl
) {
}

