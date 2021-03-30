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

    @Override
    public List<Job> getActiveJobs(UUID companyId) {
        return jobRepository.findByCompanyIdAndIsActiveTrue(companyId);
    }

    @Override
    public Company updateCompany(UUID companyId, Company company) {
        Company companyFromDb =  companyRepository.findById(companyId).get();

        if (company.getName() != null) companyFromDb.setName(company.getName());
        if (company.getPassword() != null) companyFromDb.setPassword(company.getPassword());
        if (company.getAddress() != null) companyFromDb.setAddress(company.getAddress());
        if (company.getCity() != null) companyFromDb.setCity(company.getCity());
        if (company.getPhoneNumber() != null) companyFromDb.setPhoneNumber(company.getPhoneNumber());
        if (company.getWebsite() != null) companyFromDb.setWebsite(company.getWebsite());
        if (company.getDescription() != null) companyFromDb.setDescription(company.getDescription());
        if (company.getUniqueRegistrationCode() != null) companyFromDb.setUniqueRegistrationCode(company.getUniqueRegistrationCode());
        if (company.getTradeRegisterSerialNumber() != null) companyFromDb.setTradeRegisterSerialNumber(company.getTradeRegisterSerialNumber());
        if (company.getCountry() != null) companyFromDb.setCountry(company.getCountry());

        return companyRepository.save(companyFromDb);
    }

    @Override
    public void deleteCompany(UUID companyId) {
        Company companyFromDb =  companyRepository.findById(companyId).get();
        companyRepository.delete(companyFromDb);
    }

}
