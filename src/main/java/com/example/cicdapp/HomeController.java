package com.example.cicdapp;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@RestController
public class HomeController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/")
    public String home() {
        return "App running..."; // Simplified response for testing
    }

    @GetMapping("/db")
    public String dbTest() {
        try {
            String result = jdbcTemplate.queryForObject(
                "SELECT 'Database connected successfully!'",
                String.class
            );
            return result;
        } catch (Exception e) {
            return "DB ERROR: " + e.getMessage();
        }
    }
}