package com.rocketteam.jobfull.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
public @Data
class Job implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "pg-uuid")
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "open_positions")
    private int openPositions;

    @Column(name = "posted_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Date postedDate;

//    TODO: CALCULATE EXPIRY DATE
    @Column(name = "expire_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Date expireDate;

    @Column(name = "contract")
    private String contract;

    @Column(name = "location")
    private String location;

    // TODO: CREATE ENTITY
    @ElementCollection
    private List<String> languages = new ArrayList<>();

    // TODO: CREATE ENTITY
    @ElementCollection
    private List<String> tools = new ArrayList<>();

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "company_id")
    private Company company;

    @Transient
    private boolean isNew;

    @Transient
    private boolean isFeatured;

    @Column(name = "is_active")
    private boolean isActive;

    @OneToMany
    private List<JobHunter> applicants;

}
