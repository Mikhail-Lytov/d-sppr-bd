package com.lytov.diplom.dspprbd.service.v1.impl;

import com.lytov.diplom.dspprbd.domain.OperationType;
import com.lytov.diplom.dspprbd.repository.OperationTypeRepository;
import com.lytov.diplom.dspprbd.service.v1.api.OperationTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OperationTypeServiceImpl implements OperationTypeService {

    private final OperationTypeRepository operationTypeRepository;

    @Override
    public List<OperationType> getAll() {
        return operationTypeRepository.findAll();
    }
}
