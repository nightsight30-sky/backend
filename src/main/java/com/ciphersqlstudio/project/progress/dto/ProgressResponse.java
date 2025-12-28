package com.ciphersqlstudio.project.progress.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ProgressResponse {
    private String userId;
    private Long assignmentId;
    private int attemptCount;
    private boolean completed;
    private LocalDateTime lastAttemptAt;
}
