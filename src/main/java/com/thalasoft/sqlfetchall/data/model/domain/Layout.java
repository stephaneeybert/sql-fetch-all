package com.thalasoft.sqlfetchall.data.model.domain;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "layout")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Layout {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @NotNull
  private String name;

  @NotNull
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  // @Fetch(FetchMode.JOIN) Try this if it helps
  private Profile profile;

  @OneToMany(mappedBy="layout", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<LayoutProduct> layoutProducts;

  public void addProduct(LayoutProduct layoutProduct) {
    layoutProducts.add(layoutProduct);
    layoutProduct.setLayout(this);
  }

  public void removeProduct(LayoutProduct layoutProduct) {
    layoutProducts.remove(layoutProduct);
    layoutProduct.setLayout(null);
  }
}
