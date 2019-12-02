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
public class Question extends BaseEntity implements Serializable {
    private String content;
    private String hint;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "language_id", referencedColumnName = "id")
    private Language language;

    @ManyToMany
    @JoinTable(name = "question_quiz",
            joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "quiz_id"))
    private List<Quiz> quizzes = new ArrayList<>();

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Answer> answers = new ArrayList<>();

    public Question(Long id) {
        super.setId(id);
    }

    private void addAnswer(Answer answer) {
        this.getAnswers().add(answer);
    }

    private void remove(Answer answer) {
        this.getAnswers().remove(answer);
    }
}
