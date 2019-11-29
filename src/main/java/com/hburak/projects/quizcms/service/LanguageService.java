package com.hburak.projects.quizcms.service;

import com.hburak.projects.quizcms.domain.dto.language.LanguageCreateDTO;
import com.hburak.projects.quizcms.domain.dto.language.LanguageGetDTO;

import java.util.List;

public interface LanguageService {
    List<LanguageGetDTO> getAll();
    Long save(LanguageCreateDTO langDTO);
    void update(Long id, LanguageCreateDTO platformUpdateDTO);
    void delete(Long id);
    LanguageGetDTO getOne(Long id);
}
