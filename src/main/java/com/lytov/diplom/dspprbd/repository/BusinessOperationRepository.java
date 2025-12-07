package com.lytov.diplom.dspprbd.repository;

import com.lytov.diplom.dspprbd.domain.BusinessOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessOperationRepository extends JpaRepository<BusinessOperation, Long>, JpaSpecificationExecutor<BusinessOperation> {
}
