package com.unitins.guideDocs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GuideDocsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GuideDocsApplication.class, args);
    }
}