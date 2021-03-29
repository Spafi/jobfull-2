package com.rocketteam.jobfull.model;

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
