package com.lytov.diplom.dspprbd.infra.api;

import com.lytov.diplom.dspprbd.infra.dto.request.PresignGetRequestDTO;
import com.lytov.diplom.dspprbd.infra.dto.request.PresignPostRequestDTO;
import com.lytov.diplom.dspprbd.infra.dto.response.PresignedUploadResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

//TODO: рефакторинг нужен
@Tag(name = "Взаимодействие с minio")
@RequestMapping("/api/v0/minio")
public interface ApiS3Controller {

    @PostMapping("/presign/put")
    @Operation(description = "Создать ссылку для загрузки файлов")
    PresignedUploadResponse getUploadUrl(@RequestBody @Valid PresignPostRequestDTO request);

    @PostMapping("/presign/get/{id}")
    @Operation(description = "Создать ссылку для выгрузки файлов")
    String getDownloadUrl(@PathVariable UUID id);
}
