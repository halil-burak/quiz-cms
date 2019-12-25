package com.hburak.projects.quizcms.service;

import com.hburak.projects.quizcms.domain.dto.question.QuestionAnswerUpdateDTO;
import com.hburak.projects.quizcms.domain.dto.question.QuestionCreateDTO;
import com.hburak.projects.quizcms.domain.dto.question.QuestionGetDTO;
import com.hburak.projects.quizcms.domain.dto.question.QuestionQuizzesUpdateDTO;

import java.util.List;

public interface QuestionService {
    List<QuestionGetDTO> getAll();
    Long save(QuestionCreateDTO platformDTO);
    void update(Long id, QuestionCreateDTO platformUpdateDTO);
    void delete(Long id);
    QuestionGetDTO getOne(Long id);
    void updateAnswerForQuestion(Long id, QuestionAnswerUpdateDTO questionAnswerUpdateDTO);
    void updateQuizzesForQuestion(Long id, QuestionQuizzesUpdateDTO questionQuizzesUpdateDTO);
}
