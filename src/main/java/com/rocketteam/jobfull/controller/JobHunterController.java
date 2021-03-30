package com.rocketteam.jobfull.controller;

import com.rocketteam.jobfull.model.Job;
import com.rocketteam.jobfull.model.JobHunter;
import com.rocketteam.jobfull.service.JobHunterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/jobhunter")
@CrossOrigin
public class JobHunterController {

    private final JobHunterService jobHunterService;

    @Autowired
    public JobHunterController(JobHunterService jobHunterService) {
        this.jobHunterService = jobHunterService;
    }

    @GetMapping(value = "/{id}")
    public JobHunter getById(@PathVariable UUID id) {
        return jobHunterService.getById(id);
    }

    @GetMapping(value = "/{id}/applications")
    public List<Job> getApplications(@PathVariable UUID id) {
        return jobHunterService.getApplications(id);
    }

    @PostMapping
    public JobHunter addJobHunter(@RequestBody JobHunter jobHunter) {
        return jobHunterService.save(jobHunter);
    }

    @PatchMapping(value = "/{id}")
    public JobHunter updateJobHunter(@PathVariable UUID id, @RequestBody JobHunter jobHunter) {
        return jobHunterService.updateJobHunter(id, jobHunter);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteJobHunter(@PathVariable UUID id) {
        jobHunterService.deleteJobHunter(id);
    }

}
