package com.hburak.projects.quizcms.domain.dto.quiz;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class QuizQuestionUpdateDTO {
    private List<Long> questionIds = new ArrayList<>();
}
