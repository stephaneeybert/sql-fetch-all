package com.thalasoft.sqlfetchall.data.model.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.thalasoft.sqlfetchall.data.model.domain.Layout;
import com.thalasoft.sqlfetchall.data.model.domain.LayoutProduct;
import com.thalasoft.sqlfetchall.data.model.domain.Product;
import com.thalasoft.sqlfetchall.data.model.domain.ProductPart;
import com.thalasoft.sqlfetchall.data.model.domain.Profile;
import com.thalasoft.sqlfetchall.data.model.domain.ProfileType;
import com.thalasoft.sqlfetchall.data.model.dto.LayoutGetDto;
import com.thalasoft.sqlfetchall.data.model.dto.LayoutPostDto;
import com.thalasoft.sqlfetchall.data.model.dto.LayoutProductDto;
import com.thalasoft.sqlfetchall.data.model.dto.ProductDto;
import com.thalasoft.sqlfetchall.data.model.dto.ProductPartDto;
import com.thalasoft.sqlfetchall.data.model.dto.ProfileDto;
import com.thalasoft.sqlfetchall.data.model.dto.ProfileTypeDto;

@Mapper(componentModel = "spring")
public interface LayoutMapper {

  @Mapping(target = "profile", source = "profileDto")
  @Mapping(target = "layoutProducts", source = "layoutProductDtos")
  public Layout dtoToEntity(LayoutPostDto layoutDto);

  @Mapping(target = "profile", source = "profileDto")
  @Mapping(target = "layoutProducts", source = "layoutProductDtos", ignore = true)
  public Layout dtoToEntity(LayoutGetDto layoutDto);

  @Mapping(target = "profileDto", source = "profile")
  @Mapping(target = "layoutProductDtos", source = "layoutProducts", ignore = true)
  public LayoutGetDto entityToDto(Layout layout);

  @Mapping(target = "layout", source = "layoutDto")
  @Mapping(target = "product", source = "productDto")
  public LayoutProduct dtoToEntity(LayoutProductDto dto);

  @Mapping(target = "layoutDto", source = "layout")
  @Mapping(target = "productDto", source = "product")
  public LayoutProductDto entityToDto(LayoutProduct entity);

  @Mapping(target = "profileType", source = "profileTypeDto")
  public Profile dtoToEntity(ProfileDto profileDto);

  @Mapping(target = "profileTypeDto", source = "profileType")
  public ProfileDto entityToDto(Profile profile);

  public ProfileType dtoToEntity(ProfileTypeDto profileTypeDto);

  public ProfileTypeDto entityToDto(ProfileType profileType);

  @Mapping(target = "productParts", source = "productPartDtos")
  public Product dtoToEntity(ProductDto dto);

  @Mapping(target = "productPartDtos", source = "productParts")
  public ProductDto entityToDto(Product entity);

  public ProductPart dtoToEntity(ProductPartDto dto);

  public ProductPartDto entityToDto(ProductPart entity);

}
