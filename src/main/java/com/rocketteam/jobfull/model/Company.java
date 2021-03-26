package com.rocketteam.jobfull.model;


import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity(name = "Company")
@Table(name ="companies")
public @Data
class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "pg-uuid")
    private UUID id;
    
    @Column(name ="company_name")
    private String name;
}
