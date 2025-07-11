package com.uuhere.mainjavaapp.controller;

import com.uuhere.mainjavaapp.model.Student;
import com.uuhere.mainjavaapp.service.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Mono<Student> createStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }
}