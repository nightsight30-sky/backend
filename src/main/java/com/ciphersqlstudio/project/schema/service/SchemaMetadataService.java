package com.ciphersqlstudio.project.schema.service;

import com.ciphersqlstudio.project.schema.dto.ColumnDto;
import com.ciphersqlstudio.project.schema.dto.SchemaMetadataResponse;
import com.ciphersqlstudio.project.schema.dto.TableSchemaDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SchemaMetadataService {

    private final JdbcTemplate jdbcTemplate;

    public SchemaMetadataService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public SchemaMetadataResponse getSchemaMetadata(Long assignmentId) {

        String schema = "assignment_" + assignmentId;

        // 1) Fetch tables
        String tablesSql = """
            SELECT table_name
            FROM information_schema.tables
            WHERE table_schema = ?
            AND table_type = 'BASE TABLE'
        """;

        List<String> tables = jdbcTemplate.queryForList(
                tablesSql, String.class, schema
        );

        List<TableSchemaDto> tableSchemas = new ArrayList<>();

        // 2) Fetch columns per table
        String columnsSql = """
            SELECT column_name, data_type
            FROM information_schema.columns
            WHERE table_schema = ?
            AND table_name = ?
            ORDER BY ordinal_position
        """;

        for (String table : tables) {
            List<ColumnDto> columns = jdbcTemplate.query(
                    columnsSql,
                    (rs, rowNum) -> new ColumnDto(
                            rs.getString("column_name"),
                            rs.getString("data_type")
                    ),
                    schema, table
            );

            tableSchemas.add(new TableSchemaDto(table, columns));
        }

        return new SchemaMetadataResponse(schema, tableSchemas);
    }
}
