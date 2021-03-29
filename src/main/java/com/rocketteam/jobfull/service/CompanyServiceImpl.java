package com.rocketteam.jobfull.service;

import com.rocketteam.jobfull.model.Company;
import com.rocketteam.jobfull.model.Job;
import com.rocketteam.jobfull.repository.CompanyRepository;
import com.rocketteam.jobfull.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CompanyServiceImpl implements CompanyService{

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private JobRepository jobRepository;

    @Override
    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company save(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public List<Company> findCompanyByName(String name) {
        return companyRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public Company getById(UUID id) {
//        TODO: Null check
        return companyRepository.findById(id).get();
    }

    @Override
    public List<Job> getJobsForCompany(UUID companyId) {
        return jobRepository.findByCompanyId(companyId);
    }

    @Override
    public void addJobToCompany(UUID companyId, Job job) {
        //        TODO: null check
        Company company =  companyRepository.findById(companyId).get();
        job.setCompany(company);
        jobRepository.save(job);
    }
}
