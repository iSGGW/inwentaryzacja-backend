package com.example.inwentaryzacjabackend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.inwentaryzacjabackend.repository")
public class ProjectConfig {
}