package com.hburak.projects.quizcms.controller;

import com.hburak.projects.quizcms.domain.dto.language.LanguageCreateDTO;
import com.hburak.projects.quizcms.service.LanguageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/languages")
public class LanguageController {
    private final LanguageService languageService;

    @GetMapping("/listAll")
    public ResponseEntity<?> getLanguages() {
        return new ResponseEntity<Object>(languageService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public Long addLanguage(@RequestBody LanguageCreateDTO languageCreateDTO) {
        return languageService.save(languageCreateDTO);
    }

    @PutMapping("/update/{id}")
    public void updateLanguage(@PathVariable(name = "id") Long id, @RequestBody LanguageCreateDTO languageUpdateDTO) {
        languageService.update(id, languageUpdateDTO);
    }

    @GetMapping("/language/{id}")
    public ResponseEntity<?> getLanguage(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(languageService.getOne(id), HttpStatus.OK);
    }

    @DeleteMapping("/language/{id}")
    public void deleteLanguage(@PathVariable(name = "id") Long id) {
        languageService.delete(id);
    }
}
