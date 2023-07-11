package com.thalasoft.sqlfetchall.data.model.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class LayoutGetDto {

  private Long id;

  private String name;

  @JsonProperty("profile")
  private ProfileDto profileDto;

  @JsonProperty("layoutProducts")
  private Set<LayoutProductDto> layoutProductDtos;

}
