package com.rocketteam.jobfull.repository;

import com.rocketteam.jobfull.model.JobHunter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.UUID;

@Repository
public interface JobHunterRepository extends JpaRepository<JobHunter, UUID> {

}
