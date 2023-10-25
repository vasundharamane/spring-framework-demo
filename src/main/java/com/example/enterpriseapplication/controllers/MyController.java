package com.example.enterpriseapplication.controllers;

import com.example.enterpriseapplication.model.MyResource;
import com.example.enterpriseapplication.service.MyService;
import com.example.enterpriseapplication.model.CreateResourceResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// MyController.java
@RestController
@RequestMapping("/api")
public class MyController {

    @Autowired
    private MyService myService;

    @PostMapping("/resource")
    public ResponseEntity<CreateResourceResponse> createResource(@RequestBody MyResource resource) {
        return myService.createResource(resource);
    }

    @GetMapping("/resource/{id}")
    public ResponseEntity<MyResource> getResource(@PathVariable Long id) {
        return myService.getResource(id);
    }

    @DeleteMapping("/resource/{id}")
    public ResponseEntity<String> deleteResource(@PathVariable Long id) {
        return myService.deleteResource(id);
    }

    @PutMapping("/resource/{id}")
    public ResponseEntity<MyResource> updateResource(@PathVariable Long id, @RequestBody MyResource resource) {
        return myService.updateResource(id, resource);
    }

    @PatchMapping("/resource/{id}")
    public ResponseEntity<MyResource> patchResource(@PathVariable Long id, @RequestBody MyResource resource) {
        return myService.patchResource(id, resource);
    }

}

