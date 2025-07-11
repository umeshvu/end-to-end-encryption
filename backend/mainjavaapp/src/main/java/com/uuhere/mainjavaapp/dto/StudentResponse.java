package com.uuhere.mainjavaapp.dto;

public class StudentResponse {
    private String encryptedStudentId;

    public StudentResponse(String encryptedStudentId) {
        this.encryptedStudentId = encryptedStudentId;
    }

    public String getEncryptedStudentId() {
        return encryptedStudentId;
    }

    public void setEncryptedStudentId(String encryptedStudentId) {
        this.encryptedStudentId = encryptedStudentId;
    }
}
