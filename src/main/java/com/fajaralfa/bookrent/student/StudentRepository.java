package com.fajaralfa.bookrent.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
