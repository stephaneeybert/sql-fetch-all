package com.thalasoft.sqlfetchall.data.model.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ProductDto {

  private Long id;

  private String name;

  private String supplier;

  @JsonProperty("productParts")
  private Set<ProductPartDto> productPartDtos;

}
