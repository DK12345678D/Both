package com.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Student;
import com.app.service.StudentService;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "http://localhost:4200") // adjust if frontend hosted elsewhere
public class StudentController {

    private final StudentService svc;

    public StudentController(StudentService svc) {
        this.svc = svc;
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@Validated @RequestBody Student s) {
        Student saved = svc.addStudent(s);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAll() {
        return ResponseEntity.ok(svc.getAll());
    }

    @PutMapping("/{id}/course")
    public ResponseEntity<Student> updateCourse(@PathVariable Long id, @RequestBody String newCourse) {
        Student updated = svc.updateCourse(id, newCourse);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        svc.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
 // Basic exception mapping
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleNotFound(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}

