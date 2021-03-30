package com.rocketteam.jobfull.service;

import com.rocketteam.jobfull.model.Company;
import com.rocketteam.jobfull.model.Job;
import com.rocketteam.jobfull.model.JobHunter;
import com.rocketteam.jobfull.repository.JobHunterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class JobHunterServiceImpl implements JobHunterService {

    @Autowired
    private JobHunterRepository jobHunterRepository;

    @Override
    public JobHunter getById(UUID id) {
//        TODO: null check
        return jobHunterRepository.findById(id).get();
    }

    @Override
    public List<Job> getApplications(UUID id) {
//        TODO: null check
        JobHunter jobHunter = jobHunterRepository.findById(id).get();
        return jobHunter.getApplications();
    }

    @Override
    public JobHunter save(JobHunter jobHunter) {
        return jobHunterRepository.save(jobHunter);
    }

    @Override
    public JobHunter updateJobHunter(UUID id, JobHunter jobHunter) {
        JobHunter jobHunterFromDb =  jobHunterRepository.findById(id).get();

        if (jobHunter.getFirstName() != null) jobHunterFromDb.setFirstName(jobHunter.getFirstName());
        if (jobHunter.getLastName() != null) jobHunterFromDb.setLastName(jobHunter.getLastName());
        if (jobHunter.getPhoneNumber() != null) jobHunterFromDb.setPhoneNumber(jobHunter.getPhoneNumber());
        if (jobHunter.getBirthDate() != null) jobHunterFromDb.setBirthDate(jobHunter.getBirthDate());

        return jobHunterRepository.save(jobHunterFromDb);
    }

    @Override
    public void deleteJobHunter(UUID id) {
        jobHunterRepository.deleteById(id);
    }
}
