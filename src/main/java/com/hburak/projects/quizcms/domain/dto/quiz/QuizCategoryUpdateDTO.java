package com.hburak.projects.quizcms.domain.dto.quiz;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class QuizCategoryUpdateDTO {
    private List<Long> categories = new ArrayList<>();
}
