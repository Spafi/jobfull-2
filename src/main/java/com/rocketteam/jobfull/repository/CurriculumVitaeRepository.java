package com.rocketteam.jobfull.repository;

import com.rocketteam.jobfull.model.CurriculumVitae;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.UUID;

@Repository
public interface CurriculumVitaeRepository extends JpaRepository<CurriculumVitae, UUID> {

}
