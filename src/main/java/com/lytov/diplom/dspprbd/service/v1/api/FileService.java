package com.lytov.diplom.dspprbd.service.v1.api;

import com.lytov.diplom.dspprbd.domain.File;
import com.lytov.diplom.dspprbd.dto.SearchRequestDTO;
import org.springframework.data.domain.Page;

public interface FileService {
    Page<File> search(SearchRequestDTO search);
}
