package com.hburak.projects.quizcms.domain.dto.question;

import com.hburak.projects.quizcms.domain.entity.Answer;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class QuestionCreateDTO {
    private List<Long> quizIds = new ArrayList<>();
    private List<Answer> answers = new ArrayList<>();
    private Long langId;
    private String content;
    private String hint;
}
