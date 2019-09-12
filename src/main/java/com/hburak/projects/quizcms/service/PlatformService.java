package com.hburak.projects.quizcms.service;

import com.hburak.projects.quizcms.domain.dto.platform.PlatformCreateDTO;
import com.hburak.projects.quizcms.domain.dto.platform.PlatformGetDTO;
import com.hburak.projects.quizcms.domain.dto.platform.PlatformUpdateDTO;

import java.util.List;

public interface PlatformService {
    List<PlatformCreateDTO> getAll();
    Long save(PlatformCreateDTO platformDTO);
    void update(Long id, PlatformUpdateDTO platformUpdateDTO);
    void delete(Long id);
    PlatformGetDTO getOne(Long id);
    List<PlatformCreateDTO> getPlatformsByCategory(Long categoryId);
}
