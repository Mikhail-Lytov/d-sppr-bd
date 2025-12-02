package com.lytov.diplom.dspprbd.repository;

import com.lytov.diplom.dspprbd.domain.ThreatTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ThreatTemplateRepository extends JpaRepository<ThreatTemplate, UUID> {
}