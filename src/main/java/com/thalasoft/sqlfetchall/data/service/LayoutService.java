package com.thalasoft.sqlfetchall.data.service;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import jakarta.persistence.EntityNotFoundException;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.stereotype.Service;

import com.thalasoft.sqlfetchall.data.model.domain.Layout;
import com.thalasoft.sqlfetchall.data.model.domain.LayoutProduct;
import com.thalasoft.sqlfetchall.data.model.domain.projection.LayoutView;
import com.thalasoft.sqlfetchall.data.repository.LayoutRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LayoutService {

  private final LayoutRepository layoutRepository;

  public Layout create(Layout layout) {
    final var newLayout = Layout.builder()
        .name(layout.getName())
        .profile(layout.getProfile())
        .build();
    return this.layoutRepository.save(newLayout);
  }

  public Layout findById(long id) {
    return this.layoutRepository.findById(id).orElseThrow(EntityNotFoundException::new);
  }

  public List<Layout> findAll() {
    return IterableUtils.toList(this.layoutRepository.findAll())
        .stream()
        .sorted(Comparator.comparingLong(Layout::getId))
        .collect(Collectors.toList());
  }

  public void deleteById(long id) {
    this.layoutRepository.deleteById(id);
  }

  public Layout findByIdFetching(Long id) {
    return toLayout(layoutRepository.findByIdFetching(id));
  }

  private Layout toLayout(List<LayoutView> layoutViews) {
    if (!layoutViews.isEmpty()) {
      Layout layout = null;
      Set<LayoutProduct> layoutProducts = new HashSet<>();
      for (LayoutView layoutView : layoutViews) {
        layout = layoutView.getLayout();
        layout.setProfile(layoutView.getProfile());
        layout.getProfile().setProfileType(layoutView.getProfileType());
        LayoutProduct layoutProduct = layoutView.getLayoutProduct();
        layoutProduct.setLayout(layout);
        layoutProduct.setProduct(layoutView.getProduct());
        layoutProducts.add(layoutProduct);
      }
      if (Objects.nonNull(layout)) {
        layout.getLayoutProducts().clear();
        layout.getLayoutProducts().addAll(layoutProducts);
      }
      return layout;
    } else {
      throw new RuntimeException("The home layout projection was empty");
    }
  }

}
