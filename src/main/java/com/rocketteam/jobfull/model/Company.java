package com.rocketteam.jobfull.model;



import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity(name = "Company")
@Table(name ="companies")
public @Data
class Company implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "pg-uuid")
    private UUID id;


    @Column(name ="name", nullable = false)
    private String name;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name ="phone_number")
    private String phoneNumber;

    @Column(name ="website")
    private String website;

    @Column(name ="email")
    private String email;

    @Column(name = "description")
    private String description;

    @OneToMany
    private List<Job> jobs;
}