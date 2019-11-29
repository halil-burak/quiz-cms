package com.hburak.projects.quizcms.service;

import com.hburak.projects.quizcms.domain.dto.question.QuestionCreateDTO;
import com.hburak.projects.quizcms.domain.dto.question.QuestionGetDTO;

import java.util.List;

public interface QuestionService {
    List<QuestionGetDTO> getAll();
    Long save(QuestionCreateDTO platformDTO);
    void update(Long id, QuestionCreateDTO platformUpdateDTO);
    void delete(Long id);
    QuestionGetDTO getOne(Long id);
}
