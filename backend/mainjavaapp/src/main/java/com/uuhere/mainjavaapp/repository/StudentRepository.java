package com.uuhere.mainjavaapp.repository;

import com.uuhere.mainjavaapp.model.Student;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface StudentRepository extends ReactiveCrudRepository<Student, UUID> {
}
