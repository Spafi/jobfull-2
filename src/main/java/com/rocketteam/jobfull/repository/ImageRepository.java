package com.rocketteam.jobfull.repository;

import com.rocketteam.jobfull.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;


public interface ImageRepository extends JpaRepository<Image, Long> {

    Optional<Image> findByCompanyId(UUID companyId);
    Optional<Image> findByJobHunterId(UUID userId);
}
