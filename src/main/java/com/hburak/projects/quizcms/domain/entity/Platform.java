package com.hburak.projects.quizcms.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Platform extends BaseEntity implements Serializable {
    private String name;

    @OneToMany(mappedBy = "platform", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Quiz> quizzes = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "platform_language",
            joinColumns = @JoinColumn(name = "platform_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id"))
    private List<Language> languages = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "platform_category",
            joinColumns = @JoinColumn(name = "platform_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories = new ArrayList<>();

    private void addQuizz(Quiz quiz) {
        this.getQuizzes().add(quiz);
    }

    private void remove(Quiz quiz) {
        this.getQuizzes().remove(quiz);
    }
}
