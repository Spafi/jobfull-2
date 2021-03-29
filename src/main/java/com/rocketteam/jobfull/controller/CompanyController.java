package com.rocketteam.jobfull.controller;

import com.rocketteam.jobfull.model.Company;
import com.rocketteam.jobfull.model.Job;
import com.rocketteam.jobfull.model.JobHunter;
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

    @GetMapping(params = "name")
    public List<Company> findCompanyByName(@RequestParam(required = false) String name) {
        return companyService.findCompanyByName(name);
    }

    @GetMapping(value = "/jobs")
    public List<Job> getCompanyJobs(UUID companyId) {
        return companyService.getJobsForCompany(companyId);
    }

    @GetMapping(value = "/applicants")
    public List<JobHunter> getCompanyApplicants(UUID companyId) {
        return companyService.getCompanyApplicants(companyId);
    }
}
