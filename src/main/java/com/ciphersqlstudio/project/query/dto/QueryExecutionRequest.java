package com.ciphersqlstudio.project.query.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QueryExecutionRequest {
    private Long assignmentId;
    private String sql;
}
