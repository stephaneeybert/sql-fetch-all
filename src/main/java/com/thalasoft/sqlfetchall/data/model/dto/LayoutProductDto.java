package com.thalasoft.sqlfetchall.data.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class LayoutProductDto {

  private Long id;

  @JsonIgnore
  private LayoutGetDto layoutDto;

  @JsonIgnore
  private ProductDto productDto;

}
