package com.hburak.projects.quizcms.domain.dto.question;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class QuestionAnswerUpdateDTO {
    private List<String> answers = new ArrayList<>();
}
