package com.unitins.guideDocs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableJpaAuditing
public class GuideDocsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GuideDocsApplication.class, args);
        System.out.println(new BCryptPasswordEncoder().encode("admin"));
    }
}