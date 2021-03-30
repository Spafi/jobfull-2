package com.rocketteam.jobfull.controller;

import com.rocketteam.jobfull.model.Company;
import com.rocketteam.jobfull.model.Job;
import com.rocketteam.jobfull.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/companies")
@CrossOrigin
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<Company>> getCompanies() {
        return new ResponseEntity<>(companyService.getAll(), new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public Company addCompany(@RequestBody Company company) {
        return companyService.save(company);
    }

    @GetMapping(value = "/{id}")
    public Company getById(@PathVariable UUID id) {
        return companyService.getById(id);
    }

    @GetMapping(value = "/{companyId}/jobs")
    public List<Job> getCompanyJobs(@PathVariable UUID companyId) {
        return companyService.getJobsForCompany(companyId);
    }

    @PostMapping(path = "/{companyId}/jobs")
    public void addJobToCompany(@PathVariable UUID companyId, @RequestBody Job job) {
        companyService.addJobToCompany(companyId, job);
    }
}
