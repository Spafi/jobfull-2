package com.rocketteam.jobfull.service;

import com.rocketteam.jobfull.model.Job;
import com.rocketteam.jobfull.model.JobHunter;
import com.rocketteam.jobfull.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;

    @Override
    public List<Job> getAll() {
        return jobRepository.findAll();
    }

    @Override
    public List<JobHunter> getApplicants(UUID jobId) {
        return jobRepository.getApplicantsById(jobId);
    }

    @Override
    public Job getById(UUID jobId) {
//        TODO: null check
        return jobRepository.findById(jobId).get();
    }

    @Override
    public List<Job> getByName(String name) {
        return jobRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public List<Job> getAllActiveJobs() {
        return jobRepository.findAllAndIsActiveTrue();
    }

    @Override
    public Job save(Job job) {
        return jobRepository.save(job);
    }


//    TODO: use this function to ckeck if job is new
//    final byte NEW_JOB_STATUS_IN_DAYS = 1;

//    public boolean checkIfNew(String date) {
//        int day = Integer.parseInt(date.split("-")[0]);
//        int month = Integer.parseInt(date.split("-")[1]);
//        int year = Integer.parseInt(date.split("-")[2]);
//
//        LocalDate postedDate = LocalDate.of(year, month, day);
//        LocalDate today =LocalDate.now();
//        Period period = Period.between(postedDate, today);
//
//        if (period.getYears() == 0 && period.getMonths() == 0) {
//            return period.getDays() >= 0 && period.getDays() <= NEW_JOB_STATUS_IN_DAYS;
//        }
//        return false;
//    }
}
