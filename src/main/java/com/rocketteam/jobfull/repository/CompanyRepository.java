package com.rocketteam.jobfull.repository;

import com.rocketteam.jobfull.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CompanyRepository extends JpaRepository<Company, UUID> {

    List<Company> findByNameIgnoreCase(String name);
}
