package com.lytov.diplom.dspprbd.infra.api;


import com.lytov.diplom.dspprbd.domain.BusinessOperation;
import com.lytov.diplom.dspprbd.dto.SearchRequestDTO;
import com.lytov.diplom.dspprbd.service.v1.api.BusinessOperationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BusinessOperationControllerImpl implements BusinessOperationController {

    private final BusinessOperationService service;

    @Override
    public Page<BusinessOperation> getAll(SearchRequestDTO search) {
        return service.getAll(search);
    }
}
