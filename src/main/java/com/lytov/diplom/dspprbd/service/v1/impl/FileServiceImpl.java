package com.lytov.diplom.dspprbd.service.v1.impl;

import com.lytov.diplom.dspprbd.domain.BusinessOperation;
import com.lytov.diplom.dspprbd.domain.File;
import com.lytov.diplom.dspprbd.dto.SearchRequestDTO;
import com.lytov.diplom.dspprbd.repository.FileRepository;
import com.lytov.diplom.dspprbd.repository.SearchSpecification;
import com.lytov.diplom.dspprbd.service.v1.api.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final FileRepository repository;

    @Override
    public Page<File> search(SearchRequestDTO search) {
        SearchSpecification<File> specification = new SearchSpecification<>(search);
        Pageable pageable = SearchSpecification.getPageable(search.getPage(), search.getSize());

        return repository.findAll(specification, pageable);
    }
}
