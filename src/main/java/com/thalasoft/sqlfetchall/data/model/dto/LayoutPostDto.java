package com.thalasoft.sqlfetchall.data.model.dto;

import java.util.Set;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class LayoutPostDto {

  private Long id;

  @NotBlank(message = "The name is required")
  @Size(min = 3, max = 30)
  private String name;

  @NotNull
  @JsonProperty("profile")
  private ProfileDto profileDto;

  @JsonProperty("layoutProducts")
  private Set<LayoutProductDto> layoutProductDtos;

}
