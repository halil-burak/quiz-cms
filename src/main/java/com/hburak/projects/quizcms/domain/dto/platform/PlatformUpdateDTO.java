package com.hburak.projects.quizcms.domain.dto.platform;

import com.hburak.projects.quizcms.domain.dto.category.CategoryGetDTO;
import com.hburak.projects.quizcms.domain.dto.language.LanguageGetDTO;
import com.hburak.projects.quizcms.domain.dto.quiz.QuizGetDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PlatformUpdateDTO {
    private String name;
    private List<CategoryGetDTO> categories = new ArrayList<>();
    private List<QuizGetDTO> quizzes = new ArrayList<>();
    private List<LanguageGetDTO> languages = new ArrayList<>();
}
