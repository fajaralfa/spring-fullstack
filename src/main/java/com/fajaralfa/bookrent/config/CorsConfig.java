package com.fajaralfa.bookrent.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class CorsConfig {

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry cors) {
                cors.addMapping("/**")
                        .allowedOrigins("http://localhost:5173", "http://localhost:4173")
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowCredentials(true);
            }
        };
    }

    @Bean
    public RepositoryRestConfigurer repositoryRestConfigurer() {
        return new RepositoryRestConfigurer() {
            @Override
            public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
                cors.addMapping("/api/v1/**")
                        .allowedOrigins("http://localhost:5173", "http://localhost:4173")
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowCredentials(true);
            }
        };
    }
}
