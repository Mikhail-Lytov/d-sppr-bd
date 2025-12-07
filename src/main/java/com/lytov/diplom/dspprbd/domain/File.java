package com.lytov.diplom.dspprbd.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "file")
@NoArgsConstructor
@AllArgsConstructor
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "object_key")
    private String objectKey;

    @Column(name = "original_name", length = Integer.MAX_VALUE)
    private String originalName;

    @Column(name = "content_type")
    private String contentType;

    @Column(name = "date_create")
    private Timestamp dateCreate;

}