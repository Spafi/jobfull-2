package com.rocketteam.jobfull.service;

import com.rocketteam.jobfull.model.Job;
import com.rocketteam.jobfull.model.JobHunter;
import com.rocketteam.jobfull.repository.JobHunterRepository;
import com.rocketteam.jobfull.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private JobHunterRepository jobHunterRepository;

    @Override
    public List<Job> getAll() {
        return jobRepository.findAll();
    }

    @Override
    public List<JobHunter> getApplicants(UUID jobId) {
        Job jobFromDb = jobRepository.findById(jobId).get();
        return jobFromDb.getApplicants();
    }

    @Override
    public Job getById(UUID jobId) {
//        TODO: null check
        return jobRepository.findById(jobId).get();
    }

    @Override
    public List<Job> getByName(String name) {
        return jobRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public void applyToJob(UUID jobId, UUID jobHunterId) {
        //        TODO: null check
        Job jobFromDb = jobRepository.findById(jobId).get();
        JobHunter jobHunterFromDb = jobHunterRepository.findById(jobHunterId).get();
        jobFromDb.getApplicants().add(jobHunterFromDb);
        jobRepository.save(jobFromDb);
    }

}
