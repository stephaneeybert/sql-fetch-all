package com.thalasoft.sqlfetchall.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.thalasoft.sqlfetchall.data.model.domain.projection.LayoutView;
import com.thalasoft.sqlfetchall.data.model.domain.Layout;

@Repository
public interface LayoutRepository extends JpaRepository<Layout, Long> {

  @Query("SELECT new com.thalasoft.sqlfetchall.data.model.domain.projection.LayoutView(l, pf, pt, lp, pd) FROM LayoutProduct lp JOIN lp.layout l JOIN l.profile pf JOIN pf.profileType pt JOIN lp.product pd WHERE l.id = :id")
  List<LayoutView> findByIdFetching(@Param("id") Long id);

}
