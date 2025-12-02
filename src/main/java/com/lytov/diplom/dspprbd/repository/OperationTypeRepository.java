package com.lytov.diplom.dspprbd.repository;

import com.lytov.diplom.dspprbd.domain.OperationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OperationTypeRepository extends JpaRepository<OperationType, UUID> {
}