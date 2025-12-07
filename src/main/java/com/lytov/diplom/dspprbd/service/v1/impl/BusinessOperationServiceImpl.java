package com.lytov.diplom.dspprbd.service.v1.impl;

import com.lytov.diplom.dspprbd.domain.BusinessOperation;
import com.lytov.diplom.dspprbd.dto.SearchRequestDTO;
import com.lytov.diplom.dspprbd.repository.BusinessOperationRepository;
import com.lytov.diplom.dspprbd.repository.SearchSpecification;
import com.lytov.diplom.dspprbd.service.v1.api.BusinessOperationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BusinessOperationServiceImpl  implements BusinessOperationService {

    private final BusinessOperationRepository repository;

    @Override
    public Page<BusinessOperation> getAll(SearchRequestDTO search) {
        SearchSpecification<BusinessOperation> specification = new SearchSpecification<>(search);
        Pageable pageable = SearchSpecification.getPageable(search.getPage(), search.getSize());

        return repository.findAll(specification, pageable);
    }
}
