package com.ciphersqlstudio.project.progress.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProgressUpdateRequest {
    private String userId;        // sessionId for now
    private Long assignmentId;
    private String sql;
    private boolean completed;
}
