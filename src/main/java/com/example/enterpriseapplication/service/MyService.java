package com.example.enterpriseapplication.service;

import com.example.enterpriseapplication.model.MyResource;
import com.example.enterpriseapplication.model.CreateResourceResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

// MyService.java
@Service
public class MyService {
    private List<MyResource> resourceList = new ArrayList<>();
    private Long idCounter = 1L;

    public ResponseEntity<CreateResourceResponse> createResource(MyResource resource) {
        resource.setId(idCounter++);
        resourceList.add(resource);

        // Create a custom response object
        CreateResourceResponse response = new CreateResourceResponse(
                resource.getId(),
                resource.getName(),
                "Resource created successfully"
        );
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<MyResource> getResource(Long id) {
        // logic for getting a resource by id
        Optional<MyResource> foundResource = resourceList.stream()
                .filter(resource -> resource.getId().equals(id))
                .findFirst();

        if (foundResource.isPresent()) {
            return ResponseEntity.ok(foundResource.get());
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    public ResponseEntity<String> deleteResource(Long id) {
        Iterator<MyResource> iterator = resourceList.iterator();

        while (iterator.hasNext()) {
            MyResource resource = iterator.next();
            if (resource.getId().equals(id)) {
                iterator.remove();
                return ResponseEntity.ok("Resource deleted successfully");
            }
        }

        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<MyResource> updateResource(Long id, MyResource updatedResource) {
        // Find the resource with the specified ID
        Optional<MyResource> foundResource = resourceList.stream()
                .filter(resource -> resource.getId().equals(id))
                .findFirst();

        if (foundResource.isPresent()) {
            MyResource existingResource = foundResource.get();

            // Update the fields of the existing resource
            existingResource.setName(updatedResource.getName());

            return ResponseEntity.ok(existingResource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<MyResource> patchResource(Long id, MyResource partialResource) {
        // Find the resource with the specified ID
        Optional<MyResource> foundResource = resourceList.stream()
                .filter(resource -> resource.getId().equals(id))
                .findFirst();

        if (foundResource.isPresent()) {
            MyResource existingResource = foundResource.get();

            // Apply partial update
            if (partialResource.getName() != null) {
                existingResource.setName(partialResource.getName());
            }
            return ResponseEntity.ok(existingResource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
