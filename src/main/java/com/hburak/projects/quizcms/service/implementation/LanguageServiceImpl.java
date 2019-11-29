package com.hburak.projects.quizcms.service.implementation;

import com.hburak.projects.quizcms.domain.dto.language.LanguageCreateDTO;
import com.hburak.projects.quizcms.domain.dto.language.LanguageGetDTO;
import com.hburak.projects.quizcms.domain.entity.Language;
import com.hburak.projects.quizcms.repository.LanguageRepository;
import com.hburak.projects.quizcms.service.LanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class LanguageServiceImpl implements LanguageService {
    private final LanguageRepository repository;

    @Override
    public List<LanguageGetDTO> getAll() {
        return repository.findAll().stream().map(language -> {
            LanguageGetDTO languageGetDTO = new LanguageGetDTO();
            languageGetDTO.setId(language.getId());
            languageGetDTO.setName(language.getName());
            languageGetDTO.setShortName(language.getShortName());
            return languageGetDTO;
        }).collect(Collectors.toList());
    }

    @Override
    public Long save(LanguageCreateDTO langDTO) {
        Language language = Language.builder()
                .name(langDTO.getName())
                .shortName(langDTO.getShortName())
                .build();
        return repository.save(language).getId();
    }

    @Override
    public void update(Long id, LanguageCreateDTO platformUpdateDTO) {

    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public LanguageGetDTO getOne(Long id) {
        Language language = repository.getOne(id);
        LanguageGetDTO languageGetDTO = new LanguageGetDTO();
        languageGetDTO.setId(language.getId());
        languageGetDTO.setShortName(language.getShortName());
        languageGetDTO.setName(language.getName());
        return languageGetDTO;
    }
}
