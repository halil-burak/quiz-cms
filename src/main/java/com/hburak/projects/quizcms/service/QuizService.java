package com.hburak.projects.quizcms.service;

import com.hburak.projects.quizcms.domain.dto.quiz.*;

import java.util.List;

public interface QuizService {
    List<QuizGetDTO> getAll();
    List<QuizGetExtendedDTO> getAllExtended();
    Long save(QuizCreateDTO quizCreateDTO);
    void update(Long id, QuizCreateDTO quizCreateDTO);
    void delete(Long id);
    QuizGetDTO getOne(Long id);
    void updateQuestionsOfQuiz(Long id, QuizQuestionUpdateDTO platformCategoryUpdateDTO);
    void updatePlatformOfQuiz(Long id, QuizPlatformUpdateDTO quizPlatformUpdateDTO);
    void updateLanguageOfQuiz(Long id, QuizLanguageUpdateDTO quizLanguageUpdateDTO);
}
