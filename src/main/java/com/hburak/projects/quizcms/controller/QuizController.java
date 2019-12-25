package com.hburak.projects.quizcms.controller;

import com.hburak.projects.quizcms.domain.dto.quiz.QuizCreateDTO;
import com.hburak.projects.quizcms.domain.dto.quiz.QuizLanguageUpdateDTO;
import com.hburak.projects.quizcms.domain.dto.quiz.QuizPlatformUpdateDTO;
import com.hburak.projects.quizcms.domain.dto.quiz.QuizQuestionUpdateDTO;
import com.hburak.projects.quizcms.service.QuizService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/quizzes")
public class QuizController {
    private final QuizService quizService;

    @GetMapping("/listAll")
    public ResponseEntity<?> getQuizzes() {
        return new ResponseEntity<Object>(quizService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public Long addQuiz(@RequestBody QuizCreateDTO quizCreateDTO) {
        return quizService.save(quizCreateDTO);
    }

    @PutMapping("/update/{id}")
    public void updateQuiz(@PathVariable(name = "id") Long id, @RequestBody QuizCreateDTO quizCreateDTO) {
        quizService.update(id, quizCreateDTO);
    }

    @GetMapping("/quiz/{id}")
    public ResponseEntity<?> getQuiz(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(quizService.getOne(id), HttpStatus.OK);
    }

    @DeleteMapping("/quiz/{id}")
    public void deleteQuiz(@PathVariable(name = "id") Long id) {
        quizService.delete(id);
    }

    @PutMapping("/{id}/set-language")
    public void updateLanguageOfQuiz(@PathVariable(name = "id") Long id, @RequestBody QuizLanguageUpdateDTO quizLanguageUpdateDTO) {
        quizService.updateLanguageOfQuiz(id, quizLanguageUpdateDTO);
    }

    @PutMapping("/{id}/add-question")
    public void updateQuestionsOfQuiz(@PathVariable(name = "id") Long id, @RequestBody QuizQuestionUpdateDTO quizQuestionUpdateDTO) {
        quizService.updateQuestionsOfQuiz(id, quizQuestionUpdateDTO);
    }

    @PutMapping("/{id}/set-platform")
    public void updatePlatformOfQuiz(@PathVariable(name = "id") Long id, @RequestBody QuizPlatformUpdateDTO quizPlatformUpdateDTO) {
        quizService.updatePlatformOfQuiz(id, quizPlatformUpdateDTO);
    }
}
