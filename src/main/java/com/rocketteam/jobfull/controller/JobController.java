package com.rocketteam.jobfull.controller;

import com.rocketteam.jobfull.model.Company;
import com.rocketteam.jobfull.model.Job;
import com.rocketteam.jobfull.service.CompanyService;
import com.rocketteam.jobfull.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


//    TODO: Get applicants
//    TODO: get by id

}
