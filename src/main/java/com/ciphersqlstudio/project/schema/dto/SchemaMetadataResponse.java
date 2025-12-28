package com.ciphersqlstudio.project.schema.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class SchemaMetadataResponse {
    private String schema;
    private List<TableSchemaDto> tables;
}
