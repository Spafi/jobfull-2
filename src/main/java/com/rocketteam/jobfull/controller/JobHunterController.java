package com.rocketteam.jobfull.controller;

import com.rocketteam.jobfull.model.DTO.JobHunterDTO;
import com.rocketteam.jobfull.model.JobHunter;
import com.rocketteam.jobfull.service.JobHunterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping(path = "/api/v1/jobhunters")
@CrossOrigin
public class JobHunterController {


        private final JobHunterService jobHunterService;

        @Autowired
        public JobHunterController(JobHunterService jobHunterService) {
            this.jobHunterService = jobHunterService;
        }

    @GetMapping
        public ResponseEntity<List<JobHunter>> getJobHunters() {
            return new ResponseEntity<>(jobHunterService.findAll(), new HttpHeaders(), HttpStatus.OK);
        }

        @PostMapping
        public JobHunter addJobHunter(@RequestBody JobHunterDTO jobHunterDTO) {
            return jobHunterService.save(jobHunterDTO);
        }

        @GetMapping(value = "/{id}")
        public ResponseEntity<JobHunter> getById(@PathVariable UUID id) {
            if(jobHunterService.findById(id).isPresent()){
                return new ResponseEntity<>(jobHunterService.findById(id).get(), new HttpHeaders(), HttpStatus.OK);
            }
            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }

        @GetMapping(params = "email")
        public ResponseEntity<JobHunter> findJobHunterByName(@RequestParam String email) {
            if(jobHunterService.findByEmail(email).isPresent()){
                return new ResponseEntity<>(jobHunterService.findByEmail(email).get(), new HttpHeaders(), HttpStatus.OK);
            }
            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }
}
