package com.hburak.projects.quizcms.repository;

import com.hburak.projects.quizcms.domain.entity.Platform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlatformRepository extends JpaRepository<Platform, Long> {
    //getPlatformsByCategory
    List<Platform> findByCategoriesId(Long categoryId);
}
