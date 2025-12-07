package com.lytov.diplom.dspprbd.infra.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record PresignGetRequestDTO(

        @Schema(description = "Имя файла для выгрузки")
        @NotBlank(message = "file_name_is_null")
        String filename,
        @NotBlank(message = "mime_type_is_null")
        String mimeType,
        @NotBlank(message = "object_name_is_null")
        @Schema(description = "Имя файла в minio")
        String objectName
) {
}
