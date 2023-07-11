package com.thalasoft.sqlfetchall.data.model.constant;

public enum ProfileTypeEnum {

    CAR(ProductFamilyEnum.TRANSPORTATION),
    SMARTPHONE(ProductFamilyEnum.TELECOM);

    ProductFamilyEnum productFamilyEnum;

    private ProfileTypeEnum(ProductFamilyEnum productFamilyEnum) {
      this.productFamilyEnum = productFamilyEnum;
    }

}
