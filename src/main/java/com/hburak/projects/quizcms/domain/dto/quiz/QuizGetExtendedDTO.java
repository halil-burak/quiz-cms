package com.hburak.projects.quizcms.domain.dto.quiz;

import com.hburak.projects.quizcms.domain.dto.question.QuestionGetDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class QuizGetExtendedDTO {
    private Long id;
    private String name;
    private String description;
    private Long languageId;
    private Long platformId;
    private List<QuestionGetDTO> questions = new ArrayList<>();
}
