package com.thalasoft.sqlfetchall.data.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.stereotype.Service;

import com.thalasoft.sqlfetchall.data.model.domain.Profile;
import com.thalasoft.sqlfetchall.data.repository.ProfileRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfileService {

  private final ProfileRepository profileRepository;

  public Profile create(Profile profile) {
    final Profile newProfile = Profile.builder()
        .profileType(profile.getProfileType())
        .build();
    return this.profileRepository.save(newProfile);
  }

  public Profile findById(long id) {
    return this.profileRepository.findById(id)
    .orElseThrow(() -> new EntityNotFoundException(String.format("The profile with id %s could not be found", id)));
  }

  public List<Profile> findAll() {
    return IterableUtils.toList(this.profileRepository.findAll())
        .stream()
        .sorted(Comparator.comparingLong(Profile::getId))
        .collect(Collectors.toList());
  }

  public void deleteById(long id) {
    this.profileRepository.deleteById(id);
  }
}
