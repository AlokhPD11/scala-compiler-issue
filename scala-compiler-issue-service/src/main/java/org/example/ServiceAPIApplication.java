package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@SpringBootApplication
@EnableWebMvc
@Slf4j
public class ServiceAPIApplication {

    public static void main(String[] args) {
        Map<String, String> env = System.getenv();
        for (String envName : env.keySet()) {
            log.info(String.format("%s=%s%n", envName, env.get(envName)));
        }
        java.security.Security.setProperty("networkaddress.cache.ttl", "3");
        SpringApplication.run(ServiceAPIApplication.class, args);
    }

}
