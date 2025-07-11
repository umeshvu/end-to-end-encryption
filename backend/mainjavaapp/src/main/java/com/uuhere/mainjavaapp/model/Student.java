package com.uuhere.mainjavaapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("student")
public class Student {

    @Id
    @Column("student_id")
    private UUID studentId;

    @Column("student_name")
    private String studentName;

    @Column("student_age")
    private Integer studentAge;

    @Column("student_sso")
    private String studentSSO;
}
