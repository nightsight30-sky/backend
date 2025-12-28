package com.ciphersqlstudio.project.query.validator;

import org.springframework.stereotype.Component;

@Component
public class SqlValidator {

    public void validate(String sql) {
        String normalized = sql.trim().toLowerCase();

        if (!(normalized.startsWith("select") || normalized.startsWith("with"))) {
            throw new IllegalArgumentException("Only SELECT queries are allowed");
        }

        if (normalized.contains(";")) {
            throw new IllegalArgumentException("Multiple statements are not allowed");
        }

        String[] forbidden = {
                "insert ", "update ", "delete ", "drop ",
                "alter ", "truncate ", "create ", "grant ", "revoke "
        };

        for (String keyword : forbidden) {
            if (normalized.contains(keyword)) {
                throw new IllegalArgumentException("Unsafe SQL detected");
            }
        }
    }
}

