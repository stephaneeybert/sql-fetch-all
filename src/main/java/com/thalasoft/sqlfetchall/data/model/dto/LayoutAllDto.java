package com.thalasoft.sqlfetchall.data.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class LayoutAllDto {

  private Long id;

  private String name;

  @JsonProperty("profile")
  private ProfileDto profileDto;

}
