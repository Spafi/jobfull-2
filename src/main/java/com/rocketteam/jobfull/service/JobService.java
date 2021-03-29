package com.rocketteam.jobfull.service;

import com.rocketteam.jobfull.model.Job;
import com.rocketteam.jobfull.model.JobHunter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface JobService {
    List<Job> getAll();
    Job save(Job job);
    List<JobHunter> getApplicants(UUID jobId);
    Job getById(UUID jobId);
    Job getByName(String name);
}
