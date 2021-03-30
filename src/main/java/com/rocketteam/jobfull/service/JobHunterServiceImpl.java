package com.rocketteam.jobfull.service;

import com.rocketteam.jobfull.model.DTO.JobHunterDTO;
import com.rocketteam.jobfull.model.JobHunter;
import com.rocketteam.jobfull.repository.JobHunterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class JobHunterServiceImpl implements JobHunterService{
    @Autowired
    JobHunterRepository jobHunterRepository;

    @Override
    public Optional<JobHunter> findById(UUID id) {
        return jobHunterRepository.findById(id);
    }

    @Override
    public Optional<JobHunter> findByEmail(String email) {
        return jobHunterRepository.findByEmail(email);
    }

    public List<JobHunter> findAll(){
        return jobHunterRepository.findAll();
    }

    public JobHunter save(JobHunterDTO jobHunterDTO){
        JobHunter jobHunter = JobHunter.builder()
                .birthDate(jobHunterDTO.getBirthDate())
                .email(jobHunterDTO.getEmail())
                .firstName(jobHunterDTO.getFirstName())
                .lastName(jobHunterDTO.getLastName())
                .telephoneNumber(jobHunterDTO.getTelephoneNumber())
                .password(jobHunterDTO.getPassword())//TODO:BE HASHED
                .build();

        return jobHunterRepository.save(jobHunter);
    }


}
