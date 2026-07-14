package com.example.cicdapp.repository;

import com.example.cicdapp.entity.Deployment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeploymentRepository
        extends JpaRepository<Deployment, Long> {

    List<Deployment> findByStatus(String status);

    List<Deployment> findByEnvironment(String environment);
}