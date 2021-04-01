package com.rocketteam.jobfull.controller;

import com.rocketteam.jobfull.model.CurriculumVitae;
import com.rocketteam.jobfull.model.Job;
import com.rocketteam.jobfull.model.JobHunter;
import com.rocketteam.jobfull.service.JobHunterService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class JobHunterControllerTest {

    public List<Job> mockJob(){
        Job job1 = new Job();
        job1.setName("Apple");
        job1.setActive(true);
        job1.setContract("Full-Time");
        List<Job> jobList = new ArrayList<>();
        jobList.add(job1);
        return jobList;
    }

    public CurriculumVitae mockCurriculumVitae(){
        CurriculumVitae curriculumVitae = new CurriculumVitae();
        curriculumVitae.setEmail("test@test");
        curriculumVitae.setJobHunter(mockJobHunter());
        curriculumVitae.setId(UUID.fromString("93d34cf4-8391-4659-bacd-318bf3e35999"));
        return curriculumVitae;
    }

    public JobHunter mockJobHunter(){
        JobHunter jobHunter = new JobHunter();
        jobHunter.setFirstName("Jon");
        jobHunter.setLastName("Dan");
        jobHunter.setPhoneNumber("123456");
        jobHunter.setPassword("test123");
        jobHunter.setEmail("jon@dan");
        jobHunter.setApplications(mockJob());
        jobHunter.setId(UUID.fromString("93d34cf4-8391-4659-bacd-318bf3e35901"));
        return jobHunter;
    }

    public JobHunter mockUpdateJobHunter(){
        JobHunter jobHunter = new JobHunter();
//        jobHunter.setBirthDate(new Date("24-09-2010"));
        jobHunter.setFirstName("JonUpdate");
        jobHunter.setLastName("DanUpdate");
        jobHunter.setPhoneNumber("123456Update");
        jobHunter.setPassword("test123Update");
        jobHunter.setEmail("jon@danUpdate");
        jobHunter.setApplications(mockJob());
        jobHunter.setId(UUID.fromString("93d34cf4-8391-4659-bacd-318bf3e35901"));
        return jobHunter;
    }

    List<JobHunter> mockJobHunterList(){
        List<JobHunter> jobHunterList = new ArrayList<>();
        jobHunterList.add(mockJobHunter());
        return jobHunterList;
    }


    @Test
    void getById() {
        JobHunterService jobHunterService = Mockito.mock(JobHunterService.class);
        Mockito.when(jobHunterService.getById(UUID.fromString("93d34cf4-8391-4659-bacd-318bf3e35901"))).thenReturn(mockJobHunter());
        JobHunter result = jobHunterService.getById(mockJobHunter().getId());
        assertEquals(result.getFirstName(), mockJobHunter().getFirstName());
        assertEquals(result.getLastName(), mockJobHunter().getLastName());
        assertEquals(result.getPhoneNumber(), mockJobHunter().getPhoneNumber());
    }

    @Test
    void getApplications() {

        JobHunterService jobHunterService = Mockito.mock(JobHunterService.class);
        Mockito.when(jobHunterService.getById(UUID.fromString("93d34cf4-8391-4659-bacd-318bf3e35901"))).thenReturn(mockJobHunter());
        JobHunter result = jobHunterService.getById(mockJobHunter().getId());
        assertEquals(result.getApplications(), mockJobHunter().getApplications());
    }

    @Test
    void addJobHunter() {
        JobHunterService jobHunterService = Mockito.mock(JobHunterService.class);
        Mockito.when(jobHunterService.save(mockJobHunter())).thenReturn(mockJobHunter());
        JobHunter result = jobHunterService.save(mockJobHunter());
        assertEquals(result, mockJobHunter());
    }

    @Test
    void updateJobHunter() {
        JobHunterService jobHunterService = Mockito.mock(JobHunterService.class);
        Mockito.when(jobHunterService.updateJobHunter(UUID.fromString("93d34cf4-8391-4659-bacd-318bf3e35901"),
                mockUpdateJobHunter())).thenReturn(mockUpdateJobHunter());
        JobHunter result = jobHunterService.updateJobHunter(UUID.fromString("93d34cf4-8391-4659-bacd-318bf3e35901"),
                mockUpdateJobHunter());
        assertEquals(result, mockUpdateJobHunter());
    }

    @Test
    void getCurriculumVitae() {
        JobHunterService jobHunterService = Mockito.mock(JobHunterService.class);
        Mockito.when(jobHunterService.getCurriculumVitae(UUID.fromString("93d34cf4-8391-4659-bacd-318bf3e35999")))
                .thenReturn(mockCurriculumVitae());
        CurriculumVitae result = jobHunterService.getCurriculumVitae(mockCurriculumVitae().getId());
        assertEquals(result, mockCurriculumVitae());

    }

    @Test
    void getAllJobHunters() {
        List<JobHunter> jobHunterList = new ArrayList<>();
        jobHunterList.add(mockJobHunter());
        JobHunterService jobHunterService = Mockito.mock(JobHunterService.class);
        Mockito.when(jobHunterService.getAll()).thenReturn(jobHunterList);
        List<JobHunter> result = jobHunterService.getAll();
        assertEquals(result, jobHunterList);
    }

    @Test
    void getByName() {
        JobHunterService jobHunterService = Mockito.mock(JobHunterService.class);
        Mockito.when(jobHunterService.getByLastName("Dan")).thenReturn(mockJobHunterList());
        List<JobHunter> result = jobHunterService.getByLastName(mockJobHunter().getLastName());
        assertEquals(result, mockJobHunterList());
    }
}