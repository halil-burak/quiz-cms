package com.hburak.projects.quizcms.service.implementation;

import com.hburak.projects.quizcms.domain.dto.platform.*;
import com.hburak.projects.quizcms.domain.entity.Category;
import com.hburak.projects.quizcms.domain.entity.Language;
import com.hburak.projects.quizcms.domain.entity.Platform;
import com.hburak.projects.quizcms.domain.entity.Quiz;
import com.hburak.projects.quizcms.repository.PlatformRepository;
import com.hburak.projects.quizcms.service.PlatformService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class PlatformServiceImpl implements PlatformService {
    private final PlatformRepository repository;

    @Override
    public List<PlatformLightGetDTO> getAll() {
        return repository.findAll().stream().map(platform -> {
            PlatformLightGetDTO platformDTO = new PlatformLightGetDTO();
            platformDTO.setId(platform.getId());
            platformDTO.setName(platform.getName());
            platformDTO.setCategories(platform.getCategories().stream().map(Category::getId).collect(Collectors.toList()));
            platformDTO.setLanguages(platform.getLanguages().stream().map(Language::getId).collect(Collectors.toList()));
            platformDTO.setQuizzes(platform.getQuizzes().stream().map(Quiz::getId).collect(Collectors.toList()));
            return platformDTO;
        }).collect(Collectors.toList());
    }

    // todo code refactoring : replace lambda with method reference
    @Override
    public Long save(PlatformCreateDTO platformDTO) {
        Platform platform = new Platform();
        platform.setName(platformDTO.getName());
        platform.getLanguages().addAll(platformDTO.getLanguages().stream().map(aLong -> {
            return new Language(aLong);
        }).collect(Collectors.toList()));
        platform.getCategories().addAll(platformDTO.getCategories().stream().map(aLong -> {
            return new Category(aLong);
        }).collect(Collectors.toList()));
        platform.getQuizzes().addAll(platformDTO.getQuizzes().stream().map(aLong -> {
            return new Quiz(aLong);
        }).collect(Collectors.toList()));

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
    public PlatformLightGetDTO getOne(Long id) {
        Platform platform = repository.getOne(id);
        PlatformLightGetDTO platformGetDTO = new PlatformLightGetDTO();
        platformGetDTO.setId(platform.getId());
        platformGetDTO.setName(platform.getName());
        platformGetDTO.setCategories(platform.getCategories().stream().map(Category::getId).collect(Collectors.toList()));
        platformGetDTO.setLanguages(platform.getLanguages().stream().map(Language::getId).collect(Collectors.toList()));
        platformGetDTO.setQuizzes(platform.getQuizzes().stream().map(Quiz::getId).collect(Collectors.toList()));
        return platformGetDTO;
    }

    @Override
    public List<PlatformCreateDTO> getPlatformsByCategory(Long categoryId) {
        return null;
    }

    @Override
    public void updateLangOfPlatform(Long id, PlatformLangUpdateDTO platformLangUpdateDTO) {
        Platform platform = repository.getOne(id);
        platform.getLanguages().clear();
        List<Language> languages = new ArrayList<>();
        for (Long lang : platformLangUpdateDTO.getLanguages()) {
            Language lang1 = new Language(lang);
            languages.add(lang1);
        }
        platform.setLanguages(languages);
    }
}
