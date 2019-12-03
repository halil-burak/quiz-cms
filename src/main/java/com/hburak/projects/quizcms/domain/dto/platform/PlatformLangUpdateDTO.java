package com.hburak.projects.quizcms.domain.dto.platform;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PlatformLangUpdateDTO {
    private List<Long> languages;
}
