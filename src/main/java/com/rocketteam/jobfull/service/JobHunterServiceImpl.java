package com.rocketteam.jobfull.service;

import com.rocketteam.jobfull.model.*;
import com.rocketteam.jobfull.repository.CurriculumVitaeRepository;
import com.rocketteam.jobfull.repository.JobHunterRepository;
import com.rocketteam.jobfull.repository.ProfessionalExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class JobHunterServiceImpl implements JobHunterService {

    @Autowired
    private JobHunterRepository jobHunterRepository;

    @Autowired
    private CurriculumVitaeRepository curriculumVitaeRepository;

    @Autowired
    private ProfessionalExperienceRepository professionalExperienceRepository;

    @Override
    public JobHunter getById(UUID id) {
//        TODO: null check
        return jobHunterRepository.findById(id).get();
    }

    @Override
    public List<UUID> getApplications(UUID id) {
//        TODO: null check
        JobHunter jobHunter = jobHunterRepository.findById(id).get();
        return jobHunter.getApplicationsOfJobHunter();
    }

    @Override
    public JobHunter save(JobHunter jobHunter) {
        return jobHunterRepository.save(jobHunter);
    }

    @Override
    public JobHunter updateJobHunter(UUID id, JobHunter jobHunter) {
        //        TODO: null check
        JobHunter jobHunterFromDb = jobHunterRepository.findById(id).get();

        if (jobHunter.getFirstName() != null) jobHunterFromDb.setFirstName(jobHunter.getFirstName());
        if (jobHunter.getLastName() != null) jobHunterFromDb.setLastName(jobHunter.getLastName());
        if (jobHunter.getPhoneNumber() != null) jobHunterFromDb.setPhoneNumber(jobHunter.getPhoneNumber());
        if (jobHunter.getBirthDate() != null) jobHunterFromDb.setBirthDate(jobHunter.getBirthDate());

        return jobHunterRepository.save(jobHunterFromDb);
    }

    @Override
    public void deleteJobHunter(UUID id) {
        //        TODO: null check
        jobHunterRepository.deleteById(id);
    }

    @Override
    public void addCurriculumVitae(UUID id, CurriculumVitae curriculumVitae) {
//        TODO: null check

        JobHunter jobHunterFromDb = jobHunterRepository.findById(id).get();

        if (curriculumVitae.getProfessionalExperience() != null) {
            for (ProfessionalExperience p : curriculumVitae.getProfessionalExperience()) {
                professionalExperienceRepository.save(p);
            }
        }
        jobHunterFromDb.setCurriculumVitae(curriculumVitae);

        jobHunterRepository.save(jobHunterFromDb);
    }

//    TODO : Write proper update method
//    @Override
//    public void updateCurriculumVitae(UUID id, CurriculumVitae curriculumVitae) {
////        TODO: null check
//
//        JobHunter jobHunterFromDb =  jobHunterRepository.findById(id).get();
//        CurriculumVitae cv = curriculumVitaeRepository.findById(curriculumVitae.getId()).get();
//        for (ProfessionalExperience p : cv.getProfessionalExperience()) {
//            professionalExperienceRepository.save(p);
//        }
//
//        jobHunterFromDb.setCurriculumVitae(curriculumVitae);
//
//        jobHunterRepository.save(jobHunterFromDb);
//    }

    @Override
    public CurriculumVitae getCurriculumVitae(UUID id) {
        //        TODO: null check
        JobHunter jobHunterFromDb = jobHunterRepository.findById(id).get();
        return jobHunterFromDb.getCurriculumVitae();
    }

    @Override
    public List<JobHunter> getAll() {
        return jobHunterRepository.findAll();
    }

    @Override
    public List<JobHunter> getByLastName(String lastName) {
        return jobHunterRepository.findByLastNameContainingIgnoreCase(lastName);
    }

//    @Override
//    public List<JobHunter> getByFirstOrLastName(String firstName, String lastName) {
//        return jobHunterRepository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(firstName, lastName);
//    }
}
