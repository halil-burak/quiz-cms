package com.hburak.projects.quizcms.domain.dto.quiz;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class QuizCreateDTO {
    private String name;
    private String description;
    private Long languageId;
    private Long platformId;
    private List<Long> questionIds = new ArrayList<>();
    private List<Long> categoryIds = new ArrayList<>();
}
