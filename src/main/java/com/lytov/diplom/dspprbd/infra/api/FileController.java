package com.lytov.diplom.dspprbd.infra.api;

import com.lytov.diplom.dspprbd.domain.File;
import com.lytov.diplom.dspprbd.dto.SearchRequestDTO;
import com.lytov.diplom.dspprbd.infra.dto.response.VulnerabilityProcessResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Файлы")
@RequestMapping("/api/v0/file")
public interface FileController {

    @PostMapping("/search")
    @Operation(description = "Получить файлы")
    @ApiResponse(responseCode = "200", description = "OK",content = @Content(schema = @Schema(implementation = VulnerabilityProcessResponse.class)))
    Page<File> getAll(@RequestBody SearchRequestDTO search);
}
