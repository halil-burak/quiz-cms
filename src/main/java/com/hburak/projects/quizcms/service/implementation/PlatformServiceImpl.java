package com.hburak.projects.quizcms.service.implementation;

import com.hburak.projects.quizcms.domain.dto.category.CategoryGetDTO;
import com.hburak.projects.quizcms.domain.dto.language.LanguageGetDTO;
import com.hburak.projects.quizcms.domain.dto.platform.PlatformCreateDTO;
import com.hburak.projects.quizcms.domain.dto.platform.PlatformGetDTO;
import com.hburak.projects.quizcms.domain.dto.platform.PlatformUpdateDTO;
import com.hburak.projects.quizcms.domain.dto.quiz.QuizGetDTO;
import com.hburak.projects.quizcms.domain.entity.Category;
import com.hburak.projects.quizcms.domain.entity.Language;
import com.hburak.projects.quizcms.domain.entity.Platform;
import com.hburak.projects.quizcms.domain.entity.Quiz;
import com.hburak.projects.quizcms.repository.PlatformRepository;
import com.hburak.projects.quizcms.service.PlatformService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class PlatformServiceImpl implements PlatformService {
    private final PlatformRepository repository;

    @Override
    public List<PlatformCreateDTO> getAll() {
        return repository.findAll().stream().map(platform -> {
            PlatformCreateDTO platformDTO = new PlatformCreateDTO();
            platformDTO.setName(platform.getName());
            platformDTO.setCategories(platform.getCategories().stream().map(category -> {
                CategoryGetDTO categoryDTO = new CategoryGetDTO();
                return categoryDTO;
            }).collect(Collectors.toList()));
            platformDTO.setLanguages(platform.getLanguages().stream().map(language -> {
                LanguageGetDTO languageDTO = new LanguageGetDTO();
                return languageDTO;
            }).collect(Collectors.toList()));
            platformDTO.setQuizzes(platform.getQuizzes().stream().map(quiz -> {
                QuizGetDTO quizDTO = new QuizGetDTO();
                return quizDTO;
            }).collect(Collectors.toList()));
            return platformDTO;
        }).collect(Collectors.toList());
    }

    @Override
    public Long save(PlatformCreateDTO platformDTO) {
        Platform platform = new Platform();
        platform.setName(platformDTO.getName());
        platform.getCategories().addAll(platformDTO.getCategories().stream().map(categoryDTO -> new Category(categoryDTO.getId())).collect(Collectors.toList()));
        platform.getLanguages().addAll(platformDTO.getLanguages().stream().map(languageDTO -> new Language(languageDTO.getId())).collect(Collectors.toList()));
        platform.getQuizzes().addAll(platformDTO.getQuizzes().stream().map(quizGetDTO -> new Quiz(quizGetDTO.getId())).collect(Collectors.toList()));
        return repository.save(platform).getId();
    }

    @Override
    public void update(Long id, PlatformUpdateDTO platformUpdateDTO) {
        Platform platform = repository.getOne(id);
        platform.setName(platformUpdateDTO.getName());
        // todo add after filtering - use dto instance to mapping
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public PlatformGetDTO getOne(Long id) {
        Platform platform = repository.getOne(id);
        PlatformGetDTO platformGetDTO = new PlatformGetDTO();
        platformGetDTO.setId(platform.getId());
        platformGetDTO.setName(platform.getName());
        return platformGetDTO;
    }

    @Override
    public List<PlatformCreateDTO> getPlatformsByCategory(Long categoryId) {
        return null;
    }
}
