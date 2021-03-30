package com.rocketteam.jobfull.model;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobHunter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "pg-uuid")
    private UUID id;

    @Column(name = "password")
    private String password;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "telephoneNumber")
    private String telephoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "birthDate")
    private Date birthDate;

    @ElementCollection
    private List<Job> applications;


    public void applyToJob(Job job){
        return;
    }






}
