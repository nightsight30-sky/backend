package com.ciphersqlstudio.project.hint.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HintRequest {
    private Long assignmentId;
    private String question;
    private String userSql;
}
