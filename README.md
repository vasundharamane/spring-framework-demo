# Spring Framework Demo

This is a demo spring framework developed.[To explain MockServer : https://medium.com/@vasundharamane/achieve-early-testing-using-mockserver-57c43bab3e45]
This is created to show how MockServer can be used lower envirnments where dependent external service is not available.

## Table of Contents

- [Getting Started](#getting-started)
- [Prerequisites](#prerequisites)
- [Usage](#usage)
- [Configuration](#configuration)

## Getting Started
Run main class -  src/main/java/com/example/SpringFrameworkDemoApplication.java

## Prerequisites
- JAVA  - installed
- MAVEN  -  installed

## Usage
src/main/java/com/example/enterpriseapplication contains two controllers ExternalController and MyController.
ExternalController contains call to POST API - /make-external-call which depends on external service http://localhost:1080/api/external-endpoint-getUserDetails.
(Assume this as external service such as providing firstname and last name of user by provided PAN number)

## Configuration
Here we assumed that Mockserver is installed locally using port number 1080.
But we recommend to install mockserver on your environment and use associate url for external services
