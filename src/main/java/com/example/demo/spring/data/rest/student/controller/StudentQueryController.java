package com.example.demo.spring.data.rest.student.controller;

import com.example.demo.spring.data.rest.student.domain.Student;
import com.example.demo.spring.data.rest.student.repository.StudentQueryRepository;
import com.querydsl.core.types.Predicate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/query")
@Slf4j
public class StudentQueryController {

    @Autowired
    private StudentQueryRepository studentQueryRepository;

    @GetMapping("/ok")
    public ResponseEntity ok() {
        log.info("Testing Controller....");
        return ResponseEntity.ok().build();
    }

    @GetMapping("/students")
    public ResponseEntity getFiltered(@QuerydslPredicate(root = Student.class, bindings = StudentQueryRepository.class)
                                          Predicate predicate, Pageable pageable) {
        log.info("Filtering Student Query Data....");
        return ResponseEntity.ok(studentQueryRepository.findAll(predicate, pageable));
    }
}
