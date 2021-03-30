package com.rocketteam.jobfull.service;

import com.rocketteam.jobfull.model.DTO.JobHunterDTO;
import com.rocketteam.jobfull.model.JobHunter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface JobHunterService {

    public Optional<JobHunter> findById(UUID id);
    public Optional<JobHunter> findByEmail(String email);
    public List<JobHunter> findAll();
    public JobHunter save(JobHunterDTO jobHunterDTO);
}
