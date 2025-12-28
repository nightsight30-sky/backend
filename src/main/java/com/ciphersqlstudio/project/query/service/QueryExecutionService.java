package com.ciphersqlstudio.project.query.service;


import com.ciphersqlstudio.project.query.dto.QueryExecutionRequest;
import com.ciphersqlstudio.project.query.dto.QueryExecutionResponse;
import com.ciphersqlstudio.project.query.validator.SqlValidator;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class QueryExecutionService {

    private final JdbcTemplate jdbcTemplate;
    private final SqlValidator sqlValidator;

    public QueryExecutionService(JdbcTemplate jdbcTemplate, SqlValidator sqlValidator) {
        this.jdbcTemplate = jdbcTemplate;
        this.sqlValidator = sqlValidator;
    }

    @Transactional
    public QueryExecutionResponse execute(QueryExecutionRequest request) {

        sqlValidator.validate(request.getSql());

        long start = System.currentTimeMillis();

        String schema = "assignment_" + request.getAssignmentId();
        jdbcTemplate.execute("SET search_path TO " + schema);

        List<Map<String, Object>> rows =
                jdbcTemplate.query(request.getSql(), new ColumnMapRowMapper());

        long end = System.currentTimeMillis();

        return new QueryExecutionResponse(
                rows,
                rows.size(),
                end - start
        );
    }
}

