package com.example.cicdapp.controller;

import com.example.cicdapp.entity.Deployment;
import com.example.cicdapp.service.DeploymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deployments")
public class DeploymentController {

    private final DeploymentService service;

    public DeploymentController(DeploymentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Deployment> getAllDeployments() {
        return service.getAllDeployments();
    }

    @PostMapping
    public Deployment createDeployment(@RequestBody Deployment deployment) {
        return service.createDeployment(deployment);
    }
}