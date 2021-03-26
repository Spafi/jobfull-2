package com.rocketteam.jobfull.service;

import com.rocketteam.jobfull.model.Company;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompanyService {
    List<Company> getAll();
    Company save(Company company);
}
