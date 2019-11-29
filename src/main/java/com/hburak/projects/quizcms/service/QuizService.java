package com.hburak.projects.quizcms.service;

import com.hburak.projects.quizcms.domain.dto.quiz.QuizCreateDTO;
import com.hburak.projects.quizcms.domain.dto.quiz.QuizGetDTO;

import java.util.List;

public interface QuizService {
    List<QuizGetDTO> getAll();
    Long save(QuizCreateDTO quizCreateDTO);
    void update(Long id, QuizCreateDTO quizCreateDTO);
    void delete(Long id);
    QuizGetDTO getOne(Long id);
}
