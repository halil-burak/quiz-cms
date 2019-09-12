package com.hburak.projects.quizcms.repository;

import com.hburak.projects.quizcms.domain.entity.Platform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatformRepository extends JpaRepository<Platform, Long> {
}
