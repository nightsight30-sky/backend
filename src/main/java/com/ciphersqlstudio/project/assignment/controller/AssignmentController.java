package com.ciphersqlstudio.project.assignment.controller;

import com.ciphersqlstudio.project.assignment.entity.Assignment;
import com.ciphersqlstudio.project.assignment.service.AssignmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentController {

    private final AssignmentService service;

    public AssignmentController(AssignmentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Assignment> listAssignments() {
        return service.getAllAssignments();
    }

    @GetMapping("/{id}")
    public Assignment getAssignment(@PathVariable Long id) {
        return service.getAssignmentById(id);
    }
}
