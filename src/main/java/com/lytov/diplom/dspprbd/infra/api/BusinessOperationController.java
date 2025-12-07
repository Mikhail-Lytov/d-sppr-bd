package com.lytov.diplom.dspprbd.infra.api;

import com.lytov.diplom.dspprbd.domain.BusinessOperation;
import com.lytov.diplom.dspprbd.dto.SearchRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.data.domain.Page;

@Tag(name = "Бизнес операций")
@RequestMapping("/api/v0/business-operation")
public interface BusinessOperationController {


    @PostMapping("/search")
    @Operation(description = "Получить гайд по id")
    @ApiResponse(responseCode = "200", description = "OK",content = @Content(schema = @Schema(implementation = BusinessOperation.class)))
    Page<BusinessOperation> getAll(@RequestBody SearchRequestDTO search);
}
