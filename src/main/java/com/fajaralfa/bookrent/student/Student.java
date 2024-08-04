package com.fajaralfa.bookrent.student;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nis;

    private String name;

    public Student() {
    }

    public Student(Integer id, String nis, String name) {
        this.id = id;
        this.nis = nis;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public String getNama() {
        return name;
    }

    public void setNama(String name) {
        this.name = name;
    }
}
