package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.entity.Student;
import com.app.repo.StudentRepository;

@Service
public class StudentService {
    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public Student addStudent(Student s) {
        return repo.save(s);
    }

    public List<Student> getAll() {
        return repo.findAll();
    }

    public Optional<Student> getById(Long id) {
        return repo.findById(id);
    }

    public Student updateCourse(Long id, String newCourse) {
        Student s = repo.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        s.setCourse(newCourse);
        return repo.save(s);
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
