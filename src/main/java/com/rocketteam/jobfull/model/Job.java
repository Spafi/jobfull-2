package com.rocketteam.jobfull.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
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

    @OneToMany
    private List<JobHunter> applicants;

//    TODO: use check if job is new function
//    final byte NEW_JOB_STATUS_IN_DAYS = 1;

//    public boolean checkIfNew(String date) {
//        int day = Integer.parseInt(date.split("-")[0]);
//        int month = Integer.parseInt(date.split("-")[1]);
//        int year = Integer.parseInt(date.split("-")[2]);
//
//        LocalDate postedDate = LocalDate.of(year, month, day);
//        LocalDate today =LocalDate.now();
//        Period period = Period.between(postedDate, today);
//
//        if (period.getYears() == 0 && period.getMonths() == 0) {
//            return period.getDays() >= 0 && period.getDays() <= NEW_JOB_STATUS_IN_DAYS;
//        }
//        return false;
//    }
}
