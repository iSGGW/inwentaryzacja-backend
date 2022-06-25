package com.example.inwentaryzacjabackend;

import org.joda.time.DateTimeZone;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.convert.Jsr310Converters;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EntityScan(basePackageClasses = {InwentaryzacjaBackendApplication.class, Jsr310Converters.class})
public class InwentaryzacjaBackendApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(InwentaryzacjaBackendApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(InwentaryzacjaBackendApplication.class);
    }
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @PostConstruct
    public void setTimeZone(){
        DateTimeZone timeZone = DateTimeZone.forID("Europe/Warsaw");
    }

}
