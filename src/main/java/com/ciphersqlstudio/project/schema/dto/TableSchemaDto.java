package com.ciphersqlstudio.project.schema.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class TableSchemaDto {
    private String tableName;
    private List<ColumnDto> columns;
}
