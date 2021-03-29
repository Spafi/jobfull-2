package com.rocketteam.jobfull.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name ="job_hunter")
public @Data
class JobHunter implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "pg-uuid")
    private UUID id;


    @Column(name ="first_name", nullable = false)
    private String firstName;

    @Column(name ="last_name", nullable = false)
    private String lastName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name ="phone_number")
    private String phoneNumber;

    @Column(name ="email", nullable = false)
    private String email;

    @Column(name = "birth_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @OneToMany
    private List<Job> applications;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "jobhunter_cv",
            joinColumns =
                    { @JoinColumn(name = "jobhunter_id", referencedColumnName = "id") },
            inverseJoinColumns =
                    { @JoinColumn(name = "cv_id", referencedColumnName = "id") })
    private CurriculumVitae curriculumVitae;

}
