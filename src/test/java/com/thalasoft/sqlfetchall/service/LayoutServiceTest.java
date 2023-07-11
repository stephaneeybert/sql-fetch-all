package com.thalasoft.sqlfetchall.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.thalasoft.sqlfetchall.data.model.constant.ProfileTypeEnum;
import com.thalasoft.sqlfetchall.data.model.domain.Layout;
import com.thalasoft.sqlfetchall.data.model.domain.Profile;
import com.thalasoft.sqlfetchall.data.model.domain.ProfileType;
import com.thalasoft.sqlfetchall.data.repository.LayoutRepository;
import com.thalasoft.sqlfetchall.data.repository.ProfileRepository;
import com.thalasoft.sqlfetchall.data.repository.ProfileTypeRepository;

@SpringBootTest
class LayoutServiceTest {

  @Autowired
  private LayoutRepository layoutRepository;

  @Autowired
  private ProfileRepository profileRepository;

  @Autowired
  private ProfileTypeRepository profileTypeRepository;

	@Test
	void givenLayoutEntityRepository_whenSaveAndRetreiveEntity_thenOK() {
    ProfileType profileType = profileTypeRepository.save(new ProfileType(1L, ProfileTypeEnum.CAR));
    Profile profile = profileRepository.save(new Profile(1L, profileType));
    Layout layout = layoutRepository.save(new Layout(1L, "Demo layout", profile, null));
	}

}
