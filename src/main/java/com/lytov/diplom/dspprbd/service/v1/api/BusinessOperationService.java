package com.lytov.diplom.dspprbd.service.v1.api;

import com.lytov.diplom.dspprbd.domain.BusinessOperation;
import com.lytov.diplom.dspprbd.dto.SearchRequestDTO;
import org.springframework.data.domain.Page;

public interface BusinessOperationService {

    Page<BusinessOperation> getAll(SearchRequestDTO search);
}
