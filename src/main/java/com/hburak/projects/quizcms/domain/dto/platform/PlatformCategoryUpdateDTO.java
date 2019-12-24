package com.hburak.projects.quizcms.domain.dto.platform;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PlatformCategoryUpdateDTO {
    private List<Long> categories = new ArrayList<>();
}
