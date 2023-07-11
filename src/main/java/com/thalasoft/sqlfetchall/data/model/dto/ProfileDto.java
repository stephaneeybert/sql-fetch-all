package com.thalasoft.sqlfetchall.data.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ProfileDto {

  private Long id;

  @JsonProperty("profileType")
  private ProfileTypeDto profileTypeDto;

}
