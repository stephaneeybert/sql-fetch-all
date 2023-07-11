package com.thalasoft.sqlfetchall.data.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LayoutProduct {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @NotNull
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  // @JoinColumn(name = "layout_id", nullable = false)
  //  @Fetch(FetchMode.JOIN)
  private Layout layout;

  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  // @JoinColumn(name = "product_id", nullable = false)
  //  @Fetch(FetchMode.JOIN)
  private Product product;

}
