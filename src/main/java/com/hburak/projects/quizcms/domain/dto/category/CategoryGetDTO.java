package com.hburak.projects.quizcms.domain.dto.category;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CategoryGetDTO {
    private Long id;
    private String name;
    private String description;
    private List<Long> platformIds = new ArrayList<>();
    private List<Long> quizIds = new ArrayList<>();
}
