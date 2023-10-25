package com.example.enterpriseapplication.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ExternalApiClient {

    private final RestTemplate restTemplate;

    @Value("${external.url}")
    private String externalUrl;

    public ExternalApiClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public ResponseEntity<String> postToExternalUrl(Object requestObject) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Object> requestEntity = new HttpEntity<>(requestObject, headers);
        return restTemplate.exchange(externalUrl, HttpMethod.POST, requestEntity, String.class);
    }
}
