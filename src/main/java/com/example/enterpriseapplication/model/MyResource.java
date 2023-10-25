package com.example.enterpriseapplication.model;

public class MyResource {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Define your resource properties
    private Long id;
    private String name;

    // Getters and setters
}

