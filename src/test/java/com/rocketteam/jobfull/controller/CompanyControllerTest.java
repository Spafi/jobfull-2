package com.rocketteam.jobfull.controller;

import com.rocketteam.jobfull.model.Company;
import com.rocketteam.jobfull.model.Job;
import com.rocketteam.jobfull.service.CompanyService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CompanyControllerTest {

    public List<Job> mockJobList(){
        Job job1 = new Job();
        job1.setName("Apple");
        job1.setActive(true);
        job1.setContract("Full-Time");
        List<Job> jobList = new ArrayList<>();
        jobList.add(job1);
        return jobList;
    }

    Job mockJob(){
        Job job1 = new Job();
        job1.setId(UUID.fromString("5c6ba2d5-b5a4-4665-a067-0ab29996dce7"));
        job1.setName("Apple");
        job1.setActive(true);
        job1.setContract("Full-Time");
        return job1;
    }

    Job mockJobUpdate(){
        Job job1 = new Job();
        job1.setId(UUID.fromString("5c6ba2d5-b5a4-4665-a067-0ab29996dce7"));
        job1.setName("AppleUpdate");
        job1.setActive(true);
        job1.setContract("Full-TimeUpdate");
        return job1;
    }


    Company mockCompany(){
        Company company = new Company();
        company.setAddress("Street");
        company.setCity("Bucuresti");
        company.setCountry("Romania");
        company.setName("CodeCool");
        company.setDescription("Programming school");
        company.setEmail("code@cool");
        company.setJobs(mockJobList());
        company.setPassword("CodeCool");
        company.setPhoneNumber("123456");
        company.setTradeRegisterSerialNumber("021");
        company.setUniqueRegistrationCode("999");
        company.setWebsite("learn.code.cool");
        company.setId(UUID.fromString("5c6ba2d5-b5a4-4665-a067-0ab29996dce8"));
        return company;
    }

    Company mockCompanyUpdate(){
        Company company = new Company();
        company.setAddress("StreetTest");
        company.setCity("BucurestiTest");
        company.setCountry("RomaniaTest");
        company.setName("CodeCoolTest");
        company.setDescription("Programming schoolTest");
        company.setEmail("code@coolTest");
        company.setJobs(mockJobList());
        company.setPassword("CodeCoolTest");
        company.setPhoneNumber("123456Test");
        company.setTradeRegisterSerialNumber("021Test");
        company.setUniqueRegistrationCode("999Test");
        company.setWebsite("learn.code.coolTest");
        company.setId(UUID.fromString("5c6ba2d5-b5a4-4665-a067-0ab29996dce8"));
        return company;
    }

    @Test
    void getCompanies() {
        List<Company> companyList = new ArrayList<>();
        companyList.add(mockCompany());
        CompanyService companyService = Mockito.mock(CompanyService.class);
        Mockito.when(companyService.getAll()).thenReturn(companyList);
        List<Company> result = companyService.getAll();
        assertEquals(result, companyList);
    }

    @Test
    void addCompany() {
        CompanyService companyService = Mockito.mock(CompanyService.class);
        Mockito.when(companyService.save(mockCompany())).thenReturn(mockCompany());
        Company result = companyService.save(mockCompany());
        assertEquals(result, mockCompany());
    }

    @Test
    void getById() {
        CompanyService companyService = Mockito.mock(CompanyService.class);
        Mockito.when(companyService.getById(UUID.fromString("5c6ba2d5-b5a4-4665-a067-0ab29996dce8")))
                .thenReturn(mockCompany());
        Company result = companyService.getById(mockCompany().getId());
        assertEquals(result.getAddress(), mockCompany().getAddress());
        assertEquals(result.getEmail(), mockCompany().getEmail());
        assertEquals(result.getName(), mockCompany().getName());
    }

    @Test
    void getCompanyJobs() {
        CompanyService companyService = Mockito.mock(CompanyService.class);
        Mockito.when(companyService.getById(UUID.fromString("5c6ba2d5-b5a4-4665-a067-0ab29996dce8")))
                .thenReturn(mockCompany());
        Company result = companyService.getById(mockCompany().getId());
        assertEquals(result.getJobs(), mockCompany().getJobs());
    }

    @Test
    void getActiveJobs() {
        CompanyService companyService = Mockito.mock(CompanyService.class);

        Mockito.when(companyService.getActiveJobs(UUID.fromString("5c6ba2d5-b5a4-4665-a067-0ab29996dce8")))
                .thenReturn(mockJobList());
        List<Job> result = companyService.getActiveJobs(mockCompany().getId());
        assertEquals(result, mockJobList());
    }

    @Test
    void updateCompany() {
        CompanyService companyService = Mockito.mock(CompanyService.class);
        Mockito.when(companyService.updateCompany(UUID.fromString("5c6ba2d5-b5a4-4665-a067-0ab29996dce8"), mockCompanyUpdate()))
                .thenReturn(mockCompanyUpdate());
        Company result = companyService.updateCompany(UUID.fromString("5c6ba2d5-b5a4-4665-a067-0ab29996dce8"), mockCompanyUpdate());
        assertEquals(result, mockCompanyUpdate());
    }

    @Test
    void updateJob() {
        CompanyService companyService = Mockito.mock(CompanyService.class);
        Mockito.when(companyService.updateCompanyJob(UUID.fromString("5c6ba2d5-b5a4-4665-a067-0ab29996dce8"),
                UUID.fromString("5c6ba2d5-b5a4-4665-a067-0ab29996dce7"), mockJobUpdate())).thenReturn(mockJobUpdate());
        Job result = companyService.updateCompanyJob(UUID.fromString("5c6ba2d5-b5a4-4665-a067-0ab29996dce8"),
                UUID.fromString("5c6ba2d5-b5a4-4665-a067-0ab29996dce7"), mockJobUpdate());
        assertEquals(result, mockJobUpdate());
    }
}