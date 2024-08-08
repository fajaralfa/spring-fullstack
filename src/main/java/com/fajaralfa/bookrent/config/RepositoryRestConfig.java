package com.fajaralfa.bookrent.config;

import com.fajaralfa.bookrent.book.Book;
import com.fajaralfa.bookrent.student.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class RepositoryRestConfig {

    @Bean
    public RepositoryRestConfigurer configurer() {
        return RepositoryRestConfigurer.withConfig(configuration -> {
            configuration.exposeIdsFor(Book.class);
            configuration.exposeIdsFor(Student.class);
        });
    }
}
