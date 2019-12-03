package com.hburak.projects.quizcms.domain.dto.platform;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PlatformLightGetDTO {
    private Long id;
    private String name;
    private List<Long> categories = new ArrayList<>();
    private List<Long> quizzes = new ArrayList<>();
    private List<Long> languages = new ArrayList<>();
}
