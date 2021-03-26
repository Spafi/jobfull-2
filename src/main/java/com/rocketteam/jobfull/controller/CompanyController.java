package com.rocketteam.jobfull.controller;

import com.rocketteam.jobfull.model.Company;
import com.rocketteam.jobfull.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/company")
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
}
