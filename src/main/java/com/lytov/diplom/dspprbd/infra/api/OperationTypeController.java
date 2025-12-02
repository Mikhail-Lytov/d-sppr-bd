package com.lytov.diplom.dspprbd.infra.api;

import com.lytov.diplom.dspprbd.domain.OperationType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Tag(name = "Тип операции")
@RequestMapping("/api/v0/operation-type")
public interface OperationTypeController {

    @GetMapping("/all")
    @Operation(description = "Получить все операции")
    @ApiResponse(responseCode = "200", description = "OK",
            content = @Content(schema = @Schema(implementation = OperationType.class)))
    ResponseEntity<List<OperationType>> getAll();
}
