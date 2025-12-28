package com.ciphersqlstudio.project.query.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class QueryExecutionResponse {
    private List<Map<String, Object>> rows;
    private int rowCount;
    private long executionTimeMs;
}

