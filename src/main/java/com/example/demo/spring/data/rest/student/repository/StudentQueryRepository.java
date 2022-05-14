package com.example.demo.spring.data.rest.student.repository;

import com.example.demo.spring.data.rest.student.domain.QStudent;
import com.example.demo.spring.data.rest.student.domain.Student;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.Optional;

public interface StudentQueryRepository extends PagingAndSortingRepository<Student, Long>,
        QuerydslPredicateExecutor<Student> , QuerydslBinderCustomizer<QStudent> {
    @Override
    default void customize(QuerydslBindings bindings, QStudent model) {
        // Make case-insensitive 'like' filter for all string properties
        bindings.bind(String.class).first((SingleValueBinding<StringPath, String>) StringExpression ::containsIgnoreCase);

        bindings.bind(model.age).all((path, value) -> {
            Iterator<? extends Integer> it = value.iterator();
            Integer from = it.next();
            if (value.size() >= 2) {
                Integer to = it.next();
                return Optional.of(path.between(from, to));
            } else {
                return Optional.of(path.goe(from));
            }
        });

        bindings.bind(model.registerDate).all((path, value) -> {
            Iterator<? extends LocalDate> it = value.iterator();
            LocalDate from = it.next();
            if (value.size() >= 2) {
                LocalDate to = it.next();
                return Optional.of(path.between(from, to));
            } else {
                return Optional.of(path.goe(from));
            }
        });
    }
}
