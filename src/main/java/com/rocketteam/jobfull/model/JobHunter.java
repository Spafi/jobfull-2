package com.rocketteam.jobfull.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.apache.tomcat.util.digester.ArrayStack;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "job_hunter")
public @Data
class JobHunter implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "pg-uuid")
    private UUID id;


    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "birth_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Column(name = "is_selected")
    private boolean isSelected;

    @JsonIgnore
    @OneToMany
    private List<Job> applications;

    @Transient
    private List<UUID> applicationsOfJobHunter;

    @ElementCollection
    private List<String> searchCriteria = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "jobhunter_cv",
            joinColumns =
                    {@JoinColumn(name = "jobhunter_id", referencedColumnName = "id")},
            inverseJoinColumns =
                    {@JoinColumn(name = "cv_id", referencedColumnName = "id")})
    private CurriculumVitae curriculumVitae;

    @PostLoad
    public void setFieldsForApi() {
        applicationsOfJobHunter = setApplicationsForJobHunter(applications);
    }

    public List<UUID> setApplicationsForJobHunter(List<Job> jobs) {
        List<UUID> applicationsIds = new ArrayList<>();
        for (Job j: jobs) {
            applicationsIds.add(j.getId());
        }
        return applicationsIds;
    }
}
