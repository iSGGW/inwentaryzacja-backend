package com.example.inwentaryzacjabackend;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.convert.Jsr310Converters;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@EntityScan(basePackageClasses = {InwentaryzacjaBackendApplication.class, Jsr310Converters.class})
@ComponentScan(basePackages = "com.example.inwentaryzacjabackend.repository")
@ComponentScan(basePackages = "com.example.inwentaryzacjabackend.controller")
public class InwentaryzacjaBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(InwentaryzacjaBackendApplication.class, args);
    }

    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
