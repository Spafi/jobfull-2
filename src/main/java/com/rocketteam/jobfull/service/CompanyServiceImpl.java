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
public class CompanyServiceImpl implements CompanyService {

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
        Company company = companyRepository.findById(companyId).get();
        job.setCompany(company);
        jobRepository.save(job);
    }

    @Override
    public List<Job> getActiveJobs(UUID companyId) {
        return jobRepository.findByCompanyIdAndIsActiveTrue(companyId);
    }

    @Override
    public Company updateCompany(UUID companyId, Company company) {
        //        TODO: null check
        Company companyFromDb = companyRepository.findById(companyId).get();

        if (company.getName() != null) companyFromDb.setName(company.getName());
        if (company.getPassword() != null) companyFromDb.setPassword(company.getPassword());
        if (company.getAddress() != null) companyFromDb.setAddress(company.getAddress());
        if (company.getCity() != null) companyFromDb.setCity(company.getCity());
        if (company.getPhoneNumber() != null) companyFromDb.setPhoneNumber(company.getPhoneNumber());
        if (company.getWebsite() != null) companyFromDb.setWebsite(company.getWebsite());
        if (company.getDescription() != null) companyFromDb.setDescription(company.getDescription());
        if (company.getUniqueRegistrationCode() != null)
            companyFromDb.setUniqueRegistrationCode(company.getUniqueRegistrationCode());
        if (company.getTradeRegisterSerialNumber() != null)
            companyFromDb.setTradeRegisterSerialNumber(company.getTradeRegisterSerialNumber());
        if (company.getCountry() != null) companyFromDb.setCountry(company.getCountry());

        return companyRepository.save(companyFromDb);
    }

    @Override
    public void deleteCompany(UUID companyId) {
        //        TODO: null check
        Company companyFromDb = companyRepository.findById(companyId).get();
        companyRepository.delete(companyFromDb);
    }

    @Override
    public Job updateCompanyJob(UUID companyId, UUID jobId, Job job) {
        //        TODO: null check
        Company company = companyRepository.findById(companyId).get();

        Job jobFromDb = null;

        for (Job j : company.getJobs()) {
            if (j.getId().equals(jobId)) jobFromDb = j;
        }

        if (jobFromDb != null) {

// TODO: We need to pass the name when sending back since it can't be null, OR TO REMOVE NULLABLE from entity column properties

            if (job.getName() != null) jobFromDb.setName(job.getName());
            if (job.getDescription() != null) jobFromDb.setDescription(job.getDescription());
            if (job.getOpenPositions() != 0) jobFromDb.setOpenPositions(job.getOpenPositions());
            if (job.getPostedDate() != null) jobFromDb.setPostedDate(job.getPostedDate());
            if (job.getExpireDate() != null) jobFromDb.setExpireDate(job.getExpireDate());
            if (job.getContract() != null) jobFromDb.setContract(job.getContract());
            if (job.getLocation() != null) jobFromDb.setLocation(job.getLocation());
            if (job.getLanguages() != null) jobFromDb.setLanguages(job.getLanguages());
            if (job.getContract() != null) jobFromDb.setContract(job.getContract());

            return jobRepository.save(job);
        }
        return null;
    }

    @Override
    public void deleteJob(UUID companyId, UUID jobId) {
        //        TODO: null check
        Company company = companyRepository.findById(companyId).get();

//        company.getJobs().stream()
//                .filter(j -> j.getId().equals(jobId))
//                .findFirst().ifPresent(jobFromDb -> jobRepository.delete(jobFromDb));
        Job jobToDelete = companyRepository.getJobById(jobId).get();
        jobRepository.delete(jobToDelete);
    }

}
