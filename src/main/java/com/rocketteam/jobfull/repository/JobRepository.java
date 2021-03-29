package com.rocketteam.jobfull.repository;

import com.rocketteam.jobfull.model.Job;
import com.rocketteam.jobfull.model.JobHunter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface JobRepository extends JpaRepository<Job, UUID> {
    List<Job> findByCompanyId(UUID companyId);

    List<JobHunter> getApplicantsById(UUID jobId);
}
