package com.hburak.projects.quizcms.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class CommonApplicationProperties {
    @Value("${hello.message}")
    private String helloMessage;
}
