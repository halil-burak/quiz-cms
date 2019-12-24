package com.hburak.projects.quizcms.controller;

import com.hburak.projects.quizcms.domain.dto.question.QuestionCreateDTO;
import com.hburak.projects.quizcms.service.QuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/questions")
public class QuestionController {
    private final QuestionService questionService;

    @GetMapping("/listAll")
    public ResponseEntity<?> getLanguages() {
        return new ResponseEntity<Object>(questionService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public Long addQuestion(@RequestBody QuestionCreateDTO questionCreateDTO) {
        return questionService.save(questionCreateDTO);
    }

    @PutMapping("/question/{id}")
    public void updateQuestion(@PathVariable(name = "id") Long id, @RequestBody QuestionCreateDTO questionCreateDTO) {
        questionService.update(id, questionCreateDTO);
    }

    @GetMapping("/question/{id}")
    public ResponseEntity<?> getQuestion(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(questionService.getOne(id), HttpStatus.OK);
    }

    @DeleteMapping("/question/{id}")
    public void deleteQuestion(@PathVariable(name = "id") Long id) {
        questionService.delete(id);
    }
}
