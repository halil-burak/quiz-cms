package com.hburak.projects.quizcms.service;

import com.hburak.projects.quizcms.domain.dto.category.CategoryCreateDTO;
import com.hburak.projects.quizcms.domain.dto.category.CategoryGetDTO;

import java.util.List;

public interface CategoryService {
    List<CategoryGetDTO> getAll();
    Long save(CategoryCreateDTO categoryCreateDTO);
    void update(Long id, CategoryCreateDTO categoryUpdateDTO);
    void delete(Long id);
    CategoryGetDTO getOne(Long id);
}
