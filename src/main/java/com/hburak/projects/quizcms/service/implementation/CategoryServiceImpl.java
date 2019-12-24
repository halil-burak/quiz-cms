package com.hburak.projects.quizcms.service.implementation;

import com.hburak.projects.quizcms.domain.dto.category.CategoryCreateDTO;
import com.hburak.projects.quizcms.domain.dto.category.CategoryGetDTO;
import com.hburak.projects.quizcms.domain.entity.Category;
import com.hburak.projects.quizcms.domain.entity.Platform;
import com.hburak.projects.quizcms.domain.entity.Quiz;
import com.hburak.projects.quizcms.repository.CategoryRepository;
import com.hburak.projects.quizcms.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository repository;

    @Override
    public List<CategoryGetDTO> getAll() {
        return repository.findAll().stream().map(category -> {
            CategoryGetDTO categoryGetDTO = new CategoryGetDTO();
            categoryGetDTO.setId(category.getId());
            categoryGetDTO.setName(category.getName());
            categoryGetDTO.setDescription(category.getDescription());
            categoryGetDTO.setPlatformIds(category.getPlatforms().stream().map(Platform::getId).collect(Collectors.toList()));
            categoryGetDTO.setQuizIds(category.getQuizzes().stream().map(Quiz::getId).collect(Collectors.toList()));
            return categoryGetDTO;
        }).collect(Collectors.toList());
    }

    @Override
    public Long save(CategoryCreateDTO categoryCreateDTO) {
        Category category = Category.builder()
                .name(categoryCreateDTO.getName())
                .description(categoryCreateDTO.getDescription())
                .platforms(categoryCreateDTO.getPlatformIds().stream().map(aLong -> {
                    Platform platform = new Platform();
                    platform.setId(aLong);
                    return platform;
                }).collect(Collectors.toList()))
                .quizzes(categoryCreateDTO.getQuizIds().stream().map(aLong -> {
                    Quiz quiz = new Quiz();
                    quiz.setId(aLong);
                    return quiz;
                }).collect(Collectors.toList()))
                .build();
        return repository.save(category).getId();
    }

    @Override
    public void update(Long id, CategoryCreateDTO categoryUpdateDTO) {
        if (repository.existsById(id)) {
            Category category = repository.getOne(id);
            category.setDescription(categoryUpdateDTO.getDescription());
            category.setName(categoryUpdateDTO.getName());
            category.setPlatforms(categoryUpdateDTO.getPlatformIds().stream().map(aLong -> {
                return new Platform(aLong);
            }).collect(Collectors.toList()));
            category.setQuizzes(categoryUpdateDTO.getQuizIds().stream().map(aLong -> {
                return new Quiz(aLong);
            }).collect(Collectors.toList()));
        }
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public CategoryGetDTO getOne(Long id) {
        Category category = repository.getOne(id);
        CategoryGetDTO categoryGetDTO = new CategoryGetDTO();
        categoryGetDTO.setName(category.getName());
        categoryGetDTO.setDescription(category.getDescription());
        categoryGetDTO.setPlatformIds(category.getPlatforms().stream().map(Platform::getId).collect(Collectors.toList()));
        categoryGetDTO.setQuizIds(category.getQuizzes().stream().map(Quiz::getId).collect(Collectors.toList()));
        return categoryGetDTO;
    }
}
