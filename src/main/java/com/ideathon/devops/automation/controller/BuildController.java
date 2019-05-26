package com.ideathon.devops.automation.controller;

import com.ideathon.devops.automation.model.BuildDetails;
import com.ideathon.devops.automation.services.BuildServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BuildController {

    @Autowired
    BuildServices buildServices;

    @PostMapping(value = "/build", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> build(@RequestBody BuildDetails buildDetails) throws Exception{

        buildServices.build(buildDetails);
        return new ResponseEntity<String>("Build and Deploy Successful", HttpStatus.OK);
    }
}
