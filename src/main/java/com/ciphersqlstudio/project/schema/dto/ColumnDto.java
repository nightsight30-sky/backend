package com.ciphersqlstudio.project.schema.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ColumnDto {
    private String name;
    private String type;
}
