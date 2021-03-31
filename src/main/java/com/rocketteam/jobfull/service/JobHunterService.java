package com.rocketteam.jobfull.service;

import com.rocketteam.jobfull.model.CurriculumVitae;
import com.rocketteam.jobfull.model.Job;
import com.rocketteam.jobfull.model.JobHunter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface JobHunterService {

    JobHunter getById(UUID id);

    List<UUID> getApplications(UUID id);

    JobHunter save(JobHunter jobHunter);

    JobHunter updateJobHunter(UUID id, JobHunter jobHunter);

    void deleteJobHunter(UUID id);

    void addCurriculumVitae(UUID id, CurriculumVitae curriculumVitae);

    CurriculumVitae getCurriculumVitae(UUID id);
}
