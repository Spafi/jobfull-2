package com.rocketteam.jobfull.controller;

import com.rocketteam.jobfull.model.Company;
import com.rocketteam.jobfull.model.CurriculumVitae;
import com.rocketteam.jobfull.model.Job;
import com.rocketteam.jobfull.model.JobHunter;
import com.rocketteam.jobfull.service.JobHunterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public List<UUID> getApplications(@PathVariable UUID id) {
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

    @GetMapping(value = "/{id}/cv")
    public CurriculumVitae getCurriculumVitae(@PathVariable UUID id) {
        return jobHunterService.getCurriculumVitae(id);
    }

    @PostMapping(value = "/{id}/cv")
    public void saveCurriculumVitae(@PathVariable UUID id, @RequestBody CurriculumVitae curriculumVitae) {
        jobHunterService.addCurriculumVitae(id, curriculumVitae);
    }

    @GetMapping
    public ResponseEntity<List<JobHunter>> getAllJobHunters() {
        return new ResponseEntity<>(jobHunterService.getAll(), new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(params = {"lastName"})
    public List<JobHunter> getByName(@RequestParam(required = false) String lastName) {
        return jobHunterService.getByLastName(lastName);
    }

}
