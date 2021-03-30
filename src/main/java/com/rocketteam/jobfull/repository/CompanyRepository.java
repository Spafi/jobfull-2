package com.rocketteam.jobfull.repository;

import com.rocketteam.jobfull.model.Company;
import com.rocketteam.jobfull.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CompanyRepository extends JpaRepository<Company, UUID> {

    List<Company> findByNameContainingIgnoreCase(String name);

    Optional<Job> getJobById(UUID id);
}
