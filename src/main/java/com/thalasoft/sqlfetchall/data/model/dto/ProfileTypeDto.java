package com.thalasoft.sqlfetchall.data.model.dto;

import com.thalasoft.sqlfetchall.data.model.constant.ProfileTypeEnum;

import lombok.Data;

@Data
public class ProfileTypeDto {

  private Long id;

  private ProfileTypeEnum profileTypeEnum;

}
