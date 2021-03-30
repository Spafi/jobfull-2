package com.rocketteam.jobfull.service;

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
}
