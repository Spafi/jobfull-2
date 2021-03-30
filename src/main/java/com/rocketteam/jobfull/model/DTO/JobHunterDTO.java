package com.rocketteam.jobfull.model.DTO;

import lombok.*;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class JobHunterDTO implements Serializable {

    private String password;

    private String firstName;

    private String lastName;

    private String telephoneNumber;

    private String email;

    private Date birthDate;
}
