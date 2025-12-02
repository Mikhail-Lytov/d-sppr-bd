package com.lytov.diplom.dspprbd.infra.api;

import com.lytov.diplom.dspprbd.domain.OperationType;
import com.lytov.diplom.dspprbd.service.v1.api.OperationTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OperationTypeControllerImpl implements OperationTypeController {

    private final OperationTypeService service;

    @Override
    public ResponseEntity<List<OperationType>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}
