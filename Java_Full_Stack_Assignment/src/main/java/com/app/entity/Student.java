package com.app.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String course;
    private LocalDate dateOfJoining;

    public Student() {}

    public Student(String name, String email, String course, LocalDate dateOfJoining) {
        this.name = name;
        this.email = email;
        this.course = course;
        this.dateOfJoining = dateOfJoining;
    }

    

}

