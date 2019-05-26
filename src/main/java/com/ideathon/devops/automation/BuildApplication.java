package com.ideathon.devops.automation;

import com.ideathon.devops.automation.model.BuildDetails;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class BuildApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuildApplication.class, args);
    }

}
