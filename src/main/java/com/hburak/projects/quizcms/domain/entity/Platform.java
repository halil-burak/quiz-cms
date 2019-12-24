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

    //@OneToMany(mappedBy = "platform", cascade = CascadeType.ALL, orphanRemoval = true)
    @OneToMany
    @JoinColumn(name = "platform_id")
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

    public Platform(Long id) {
        super.setId(id);
    }

    private void addQuizz(Quiz quiz) {
        this.getQuizzes().add(quiz);
    }

    public void removeQuiz(Quiz quiz) {
        this.getQuizzes().remove(quiz);
    }

    public void addLanguage(Language language) {
        this.getLanguages().add(language);
    }

    public void removeLanguage(Language language) {
        this.getLanguages().remove(language);
    }

    public void addCategory(Category category) {
        this.getCategories().add(category);
    }

    public void removeCategory(Category category) {
        this.getCategories().remove(category);
    }
}
