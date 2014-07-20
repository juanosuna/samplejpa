Sample Spring Boot JPA Project
==============================

This sample project demonstrates the use of Spring Boot, JPA with Hibernate, MVC, Flyway, H2, jpa-schema-maven-plugin.
It generates DDL using jpa-schema-maven-plugin and then executes DDL using Flyway as part of build process.
Sample data is then populated for integration testing purposes.

Note: Maven profile regenerate is turned on by default and regenerates DB (file in H2) with each build.

1. Execute build.bat
2. Execute run.bat
3. Test rest services in browser that execute sample queries and return JSON:
    * http://localhost:8080/sample1
    * http://localhost:8080/sample2
    * http://localhost:8080/sample3
    * http://localhost:8080/sample4
