package com.example.demo.spring.data.rest.student.domain;


import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Version
    @Column(name = "version")
    private Integer version;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "grade")
    private String grade;

    @Column(name = "section")
    private String section;

    @Column(name = "age")
    private Integer age;

    @Column(name = "enrolled")
    private Boolean enrolled;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "register_date")
    private LocalDate registerDate;

}
