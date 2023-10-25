package com.example.enterpriseapplication.controllers;

import com.example.enterpriseapplication.service.ExternalApiClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ExternalController {
    @Autowired
    private ExternalApiClient externalApiClient;

    @PostMapping("/make-external-call")
    public ResponseEntity<String> makeExternalCall(@RequestBody Object requestObject) {
        ResponseEntity<String> responseEntity = externalApiClient.postToExternalUrl(requestObject);
        return responseEntity;
    }
}
