package com.indie.dental;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@RestController
public class IndieDentalApplication {

    private static final Logger logger = LoggerFactory.getLogger(IndieDentalApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(IndieDentalApplication.class, args);
        logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>:<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
    }

//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")
//                        .allowedOrigins("*");
//                        //.allowCredentials(true)
//                        //.allowedMethods("POST, PUT, GET, OPTIONS, DELETE");
//                        //.maxAge(3600);
//                        //.allowedHeaders("Authorization, Origin, X-Requested-With, Content-Type, Accept");
//            }
//        };
//    }
}
