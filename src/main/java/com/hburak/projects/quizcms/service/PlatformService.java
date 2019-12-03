package com.hburak.projects.quizcms.service;

import com.hburak.projects.quizcms.domain.dto.platform.*;

import java.util.List;

public interface PlatformService {
    List<PlatformLightGetDTO> getAll();
    Long save(PlatformCreateDTO platformDTO);
    void update(Long id, PlatformUpdateDTO platformUpdateDTO);
    void delete(Long id);
    PlatformLightGetDTO getOne(Long id);
    List<PlatformCreateDTO> getPlatformsByCategory(Long categoryId);
    void updateLangOfPlatform(Long id, PlatformLangUpdateDTO platformLangUpdateDTO);
}
