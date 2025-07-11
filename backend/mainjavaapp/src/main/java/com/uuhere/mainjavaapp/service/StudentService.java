package com.uuhere.mainjavaapp.service;

import com.uuhere.mainjavaapp.dto.StudentResponse;
import com.uuhere.mainjavaapp.model.Student;
import com.uuhere.mainjavaapp.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
@Slf4j
public class StudentService {

    private final StudentRepository studentRepository;
    private final WebClient sidecarWebClient;

    public StudentService(StudentRepository studentRepository, WebClient sidecarWebClient) {
        this.studentRepository = studentRepository;
        this.sidecarWebClient = sidecarWebClient;
    }


    public Mono<StudentResponse> saveStudent(Student studentInput) {
        log.info("Received student info from UI : {}",studentInput.toString());
        return decryptSSO(studentInput.getStudentSSO())
                .flatMap(decryptedSSO -> {
                    studentInput.setStudentSSO(decryptedSSO);
                    return studentRepository.save(studentInput);
                })
                .flatMap(savedStudent ->
                        encryptStudentId(savedStudent.getStudentId().toString())
                                .map(StudentResponse::new)
                )
                .doOnNext(response -> log.info("Sending response to UI: {}", response.getEncryptedStudentId()));
    }

    private Mono<String> decryptSSO(String encryptedSSO) {
        return sidecarWebClient.post()
                .uri("/decrypt")
                .bodyValue(Map.of("encrypted", encryptedSSO))
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<String, String>>() {})
                .map(resp -> resp.get("data"));
    }

    private Mono<String> encryptStudentId(String plainStudentId) {
        return sidecarWebClient.post()
                .uri("/encrypt")
                .bodyValue(Map.of("data", plainStudentId))
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<String, String>>() {})
                .map(resp -> resp.get("encrypted"));
    }
}
