package com.rocketteam.jobfull.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "cv")
public @Data
class CurriculumVitae implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "pg-uuid")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "location")
    private String location;

    @Column(name = "wanted_job_title")
    private String wantedJobTitle;

    @Column(name = "summary")
    private String summary;

    @Column(name = "skills")
    private String skills;

    @JsonIgnore
    @OneToOne(mappedBy = "curriculumVitae")
    private JobHunter jobHunter;

    @OneToMany(mappedBy = "curriculumVitae")
    private List<ProfessionalExperience> professionalExperience;

    private Education education;

    @ElementCollection
    private List<String> foreignLanguages;

    @ElementCollection
    private List<String> searchCriteria;
}
