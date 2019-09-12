package com.hburak.projects.quizcms.controller;

import com.hburak.projects.quizcms.configuration.CommonApplicationProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class QuizController {
    private final CommonApplicationProperties commonApplicationProperties;

    @GetMapping("")
    public String hello() {
        return commonApplicationProperties.getHelloMessage();
    }
}
