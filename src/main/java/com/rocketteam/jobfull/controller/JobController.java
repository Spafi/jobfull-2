package com.rocketteam.jobfull.controller;


import com.rocketteam.jobfull.model.Job;
import com.rocketteam.jobfull.model.JobHunter;

import com.rocketteam.jobfull.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/jobs")
@CrossOrigin
public class JobController {

    private final JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public List<Job> getAll() {
        return jobService.getAll();
    }

    @GetMapping(value = "/{jobId}")
    public Job getJob(@PathVariable UUID jobId) {
        return jobService.getById(jobId);
    }

    @GetMapping(params = "name")
    public List<Job> getByName(@RequestParam(required = false) String name) {
        return jobService.getByName(name);
    }

    @GetMapping(value = "/{jobId}/applicants")
    public List<JobHunter> getApplicantsForJob(@PathVariable UUID jobId) {
        return jobService.getApplicants(jobId);
    }

    @GetMapping(value = "/active")
    public List<Job> getAllAndActiveIsTrue() {
        return jobService.getAllActiveJobs();
    }

}
