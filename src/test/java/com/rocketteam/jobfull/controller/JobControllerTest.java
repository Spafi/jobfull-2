package com.rocketteam.jobfull.controller;

import com.rocketteam.jobfull.model.Job;
import com.rocketteam.jobfull.model.JobHunter;
import com.rocketteam.jobfull.service.JobService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class JobControllerTest {

    public JobHunter mockJobHunter(){
        JobHunter jobHunter = new JobHunter();
        jobHunter.setFirstName("Jon");
        jobHunter.setLastName("Dan");
        jobHunter.setPhoneNumber("123456");
        jobHunter.setPassword("test123");
        jobHunter.setEmail("jon@dan");
        jobHunter.setId(UUID.fromString("93d34cf4-8391-4659-bacd-318bf3e35901"));
        return jobHunter;
    }

    List<JobHunter> mockJobHunterList(){
        List<JobHunter> jobHunterList = new ArrayList<>();
        jobHunterList.add(mockJobHunter());
        return jobHunterList;
    }

    Job mockJob(){
        Job job1 = new Job();
        job1.setId(UUID.fromString("5c6ba2d5-b5a4-4665-a067-0ab29996dce7"));
        job1.setName("Apple");
        job1.setActive(true);
        job1.setContract("Full-Time");
        job1.setApplicants(mockJobHunterList());
        return job1;
    }

    List<Job> mockJobList(){
       List<Job> jobList = new ArrayList<>();
       jobList.add(mockJob());
       return jobList;
    }

    @Test
    void getAll() {
        List<Job> jobList = new ArrayList<>();
        jobList.add(mockJob());
        JobService jobService = Mockito.mock(JobService.class);
        Mockito.when(jobService.getAll()).thenReturn(mockJobList());
        List<Job> result = jobService.getAll();
        assertEquals(result, mockJobList());
    }

    @Test
    void getJob() {
        JobService jobService = Mockito.mock(JobService.class);
        Mockito.when(jobService.getById(UUID.fromString("5c6ba2d5-b5a4-4665-a067-0ab29996dce7"))).thenReturn(mockJob());
        Job result = jobService.getById(mockJob().getId());
        assertEquals(result.getName(), mockJob().getName());
        assertEquals(result.getContract(), mockJob().getContract());
        assertEquals(result.getApplicants(), mockJob().getApplicants());
    }

    @Test
    void getByName() {
        JobService jobService = Mockito.mock(JobService.class);
        Mockito.when(jobService.getByName("Apple")).thenReturn(mockJobList());
        List<Job> result = jobService.getByName(mockJob().getName());
        assertEquals(result, mockJobList());

    }

    @Test
    void getApplicantsForJob() {
        List<JobHunter> jobHunterList = new ArrayList<>();
        jobHunterList.add(mockJobHunter());
        JobService jobService = Mockito.mock(JobService.class);
        Mockito.when(jobService.getApplicants(UUID.fromString("5c6ba2d5-b5a4-4665-a067-0ab29996dce7")))
                .thenReturn(mockJobHunterList());
        List<JobHunter> result = jobService.getApplicants(mockJob().getId());
        assertEquals(result, jobHunterList);
    }
}