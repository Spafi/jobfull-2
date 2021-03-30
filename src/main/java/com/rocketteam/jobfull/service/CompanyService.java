package com.rocketteam.jobfull.service;

import com.rocketteam.jobfull.model.Company;
import com.rocketteam.jobfull.model.Job;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface CompanyService {
    List<Company> getAll();
    Company save(Company company);
    List<Company> findCompanyByName(String name);
    Company getById(UUID id);
    List<Job> getJobsForCompany(UUID companyId);
    void addJobToCompany(UUID companyId, Job job);
    List<Job> getActiveJobs(UUID companyId);

    Company updateCompany(UUID companyId, Company company);

    void deleteCompany(UUID companyId);
}
