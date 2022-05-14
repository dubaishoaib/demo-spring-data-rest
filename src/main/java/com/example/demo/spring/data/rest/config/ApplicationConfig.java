package com.example.demo.spring.data.rest.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@Import(RepositoryRestMvcConfiguration.class)
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.example.demo.spring.data.rest.student.repository")
@EntityScan("com.example.demo.spring.data.rest.student.domain")
public class ApplicationConfig {
}
