package com.uuhere.mainjavaapp.service;

import com.uuhere.mainjavaapp.model.Student;
import com.uuhere.mainjavaapp.repository.StudentRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Mono<Student> saveStudent(Student student) {
        return studentRepository.save(student);
    }
}
