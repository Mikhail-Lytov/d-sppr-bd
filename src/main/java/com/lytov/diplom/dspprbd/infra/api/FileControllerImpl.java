package com.lytov.diplom.dspprbd.infra.api;

import com.lytov.diplom.dspprbd.domain.File;
import com.lytov.diplom.dspprbd.dto.SearchRequestDTO;
import com.lytov.diplom.dspprbd.service.v1.api.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FileControllerImpl implements FileController {

    private final FileService service;

    @Override
    public Page<File> getAll(SearchRequestDTO search) {
        return service.search(search);
    }
}
