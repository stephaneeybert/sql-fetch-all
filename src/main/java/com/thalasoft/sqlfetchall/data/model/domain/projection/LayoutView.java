package com.thalasoft.sqlfetchall.data.model.domain.projection;

import com.thalasoft.sqlfetchall.data.model.domain.Layout;
import com.thalasoft.sqlfetchall.data.model.domain.LayoutProduct;
import com.thalasoft.sqlfetchall.data.model.domain.Product;
import com.thalasoft.sqlfetchall.data.model.domain.Profile;
import com.thalasoft.sqlfetchall.data.model.domain.ProfileType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class LayoutView {

  private Layout layout;
  private Profile profile;
  private ProfileType profileType;
  private LayoutProduct layoutProduct;
  private Product product;

}
