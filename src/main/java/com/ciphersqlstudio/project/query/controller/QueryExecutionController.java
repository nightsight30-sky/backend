package com.ciphersqlstudio.project.query.controller;

import com.ciphersqlstudio.project.query.dto.QueryExecutionRequest;
import com.ciphersqlstudio.project.query.dto.QueryExecutionResponse;
import com.ciphersqlstudio.project.query.service.QueryExecutionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/query")
public class QueryExecutionController {

    private final QueryExecutionService service;

    public QueryExecutionController(QueryExecutionService service) {
        this.service = service;
    }

    @PostMapping("/execute")
    public QueryExecutionResponse execute(@RequestBody QueryExecutionRequest request) {
        return service.execute(request);
    }
}

