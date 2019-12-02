package com.hburak.projects.quizcms.service.implementation;

import com.hburak.projects.quizcms.domain.dto.quiz.QuizCreateDTO;
import com.hburak.projects.quizcms.domain.dto.quiz.QuizGetDTO;
import com.hburak.projects.quizcms.domain.entity.*;
import com.hburak.projects.quizcms.repository.QuizRepository;
import com.hburak.projects.quizcms.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {
    private final QuizRepository repository;

    @Override
    public List<QuizGetDTO> getAll() {
        return repository.findAll().stream().map(quiz -> {
            QuizGetDTO quizGetDTO = new QuizGetDTO();
            quizGetDTO.setId(quiz.getId());
            quizGetDTO.setName(quiz.getName());
            quizGetDTO.setDescription(quiz.getDescription());
            quizGetDTO.setLanguageId(quiz.getLanguage().getId());
            quizGetDTO.setPlatformId(quiz.getPlatform().getId());
            return quizGetDTO;
        }).collect(Collectors.toList());
    }

    @Override
    public Long save(QuizCreateDTO quizCreateDTO) {
        Quiz quiz = Quiz.builder()
                .name(quizCreateDTO.getName())
                .description(quizCreateDTO.getDescription())
                .language(new Language(quizCreateDTO.getLanguageId()))
                .platform(new Platform(quizCreateDTO.getPlatformId()))
                .categories(quizCreateDTO.getCategoryIds().stream().map(Category::new).collect(Collectors.toList()))
                .questions(quizCreateDTO.getQuestionIds().stream().map(Question::new).collect(Collectors.toList()))
                .build();
        return repository.save(quiz).getId();
    }

    @Override
    public void update(Long id, QuizCreateDTO quizCreateDTO) {

    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public QuizGetDTO getOne(Long id) {
        Quiz quiz = repository.getOne(id);
        QuizGetDTO quizGetDTO = new QuizGetDTO();
        quizGetDTO.setId(quiz.getId());
        quizGetDTO.setName(quiz.getName());
        quizGetDTO.setDescription(quiz.getDescription());
        quizGetDTO.setPlatformId(quiz.getPlatform().getId());
        quizGetDTO.setLanguageId(quiz.getLanguage().getId());
        return quizGetDTO;
    }
}
