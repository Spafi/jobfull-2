package com.rocketteam.jobfull.repository;

import com.rocketteam.jobfull.model.JobHunter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface JobHunterRepository extends JpaRepository<JobHunter, UUID> {

    Optional<JobHunter> findById(UUID id);
    Optional<JobHunter> findByEmail(String email);

//    @Query("SELECT * FROM JobHunter jh WHERE jh.name =?1")
//    Optional<JobHunter> findJobByName(String name);
}
