package com.rocketteam.jobfull.service;

import com.rocketteam.jobfull.model.Job;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JobService {
    List<Job> getAll();
    Job save(Job job);
}
