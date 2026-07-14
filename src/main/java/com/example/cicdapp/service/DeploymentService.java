package com.example.cicdapp.service;

import com.example.cicdapp.entity.Deployment;
import com.example.cicdapp.repository.DeploymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeploymentService {

    private final DeploymentRepository repository;

    public DeploymentService(DeploymentRepository repository) {
        this.repository = repository;
    }

    public List<Deployment> getAllDeployments() {
        return repository.findAll();
    }

    public Deployment getDeployment(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Deployment not found"));
    }

    public Deployment createDeployment(Deployment deployment) {
        return repository.save(deployment);
    }

    public Deployment updateDeployment(Long id, Deployment deployment) {
        Deployment existing = getDeployment(id);

        existing.setApplicationName(deployment.getApplicationName());
        existing.setVersion(deployment.getVersion());
        existing.setEnvironment(deployment.getEnvironment());
        existing.setStatus(deployment.getStatus());

        return repository.save(existing);
    }

    public void deleteDeployment(Long id) {
        repository.deleteById(id);
    }
}