package com.ciphersqlstudio.project.progress.controller;

import com.ciphersqlstudio.project.progress.dto.ProgressResponse;
import com.ciphersqlstudio.project.progress.dto.ProgressUpdateRequest;
import com.ciphersqlstudio.project.progress.service.UserProgressService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/progress")
public class UserProgressController {

    private final UserProgressService service;

    public UserProgressController(UserProgressService service) {
        this.service = service;
    }

    @PostMapping
    public ProgressResponse updateProgress(@RequestBody ProgressUpdateRequest request) {
        return service.recordAttempt(request);
    }
}
