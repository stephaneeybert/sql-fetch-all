package com.thalasoft.sqlfetchall.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thalasoft.sqlfetchall.data.model.domain.ProfileType;

@Repository
public interface ProfileTypeRepository extends JpaRepository<ProfileType, Long> {
}
