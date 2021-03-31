package com.rocketteam.jobfull.repository;

import com.rocketteam.jobfull.model.ProfessionalExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProfessionalExperienceRepository extends JpaRepository<ProfessionalExperience, UUID> {

}
