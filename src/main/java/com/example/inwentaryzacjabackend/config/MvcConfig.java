package com.example.inwentaryzacjabackend.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
/**
 * Klasa MvcConfig typu public
 */
public class MvcConfig implements WebMvcConfigurer {
    /**
     * Funkcja addViewControllers typu  public void
     * @param registry ViewControllerRegistry
     */
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/api/auth/signin").setViewName("signin");
    }

    /**
     * Funkcja addCorsMappings typu public void
     * @param registry CorsRegistry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("https://20.218.104.224:8443")
                .allowedMethods("GET", "PUT", "POST", "GET", "OPTIONS")
                .allowCredentials(false).maxAge(3600);
    }

}