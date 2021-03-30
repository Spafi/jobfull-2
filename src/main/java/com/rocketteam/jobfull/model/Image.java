package com.rocketteam.jobfull.model;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;


@Entity
@DynamicUpdate
public @Data class Image implements Serializable {

    @Id
    @Column(name = "image_id", updatable = false)
    @GeneratedValue
    Long id;

    @Lob
    byte[] content;

    String name;

    private UUID companyId;

    private UUID jobHunterId;
}