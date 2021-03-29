package com.rocketteam.jobfull.service;

import com.rocketteam.jobfull.model.Job;
import com.rocketteam.jobfull.model.JobHunter;
import com.rocketteam.jobfull.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;

    @Override
    public List<Job> getAll() {
        return jobRepository.findAll();
    }

    @Override
    public List<JobHunter> getApplicants(UUID jobId) {
        return jobRepository.getApplicantsById(jobId);
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

}
