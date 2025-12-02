package com.lytov.diplom.dspprbd.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Getter
@Setter
@Entity
@Slf4j
@Table(name = "threat_template")
public class ThreatTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "code", length = Integer.MAX_VALUE)
    private String code;

    @Column(name = "name", length = Integer.MAX_VALUE)
    private String name;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "default_probability")
    private Integer defaultProbability;

    @Column(name = "default_impact")
    private Integer defaultImpact;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "operation_type_id")
    private OperationType operationType;

    @Column(name = "source_standard", length = Integer.MAX_VALUE)
    private String sourceStandard;

    @Column(name = "is_active")
    private Boolean isActive;
}