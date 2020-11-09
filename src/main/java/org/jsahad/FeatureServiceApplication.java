package org.jsahad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Spring boot application entry point.
 */
@SpringBootApplication
public class FeatureServiceApplication implements WebMvcConfigurer {

    /**
     * Spring boot application bootstrap. Application main method.
     *
     * @param args JVM command arguments.
     */
    public static void main(String[] args) {
        SpringApplication.run(FeatureServiceApplication.class, args);
    }

}

