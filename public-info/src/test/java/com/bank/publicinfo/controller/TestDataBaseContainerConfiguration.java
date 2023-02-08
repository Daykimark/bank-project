package com.bank.publicinfo.controller;

import org.junit.jupiter.api.BeforeAll;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.containers.PostgreSQLContainer;

@Sql({"classpath:test.sql"})
public abstract class TestDataBaseContainerConfiguration {

    @SuppressWarnings("all")
    private static PostgreSQLContainer<?> database = new PostgreSQLContainer<>("postgres")
            .withDatabaseName("postgres")
            .withUsername("user")
            .withPassword("password");

    @BeforeAll
    static void runContainer() {
        database.start();
    }

    @DynamicPropertySource
    public static void properties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", database::getJdbcUrl);
        registry.add("spring.datasource.username", database::getUsername);
        registry.add("spring.datasource.password", database::getPassword);
    }
}
