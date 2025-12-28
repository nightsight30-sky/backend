package com.ciphersqlstudio.project.hint.service;

import com.ciphersqlstudio.project.hint.dto.HintRequest;
import org.springframework.stereotype.Service;

@Service
public class HintService {

    private final LlmClientService llmClient;

    public HintService(LlmClientService llmClient) {
        this.llmClient = llmClient;
    }

    public String getHint(HintRequest request) {

        String prompt = """
            You are a strict SQL tutor.

            Rules:
            - DO NOT provide SQL queries.
            - DO NOT mention table or column names.
            - DO NOT provide solutions.

            Assignment:
            %s

            User Attempt:
            %s

            Give one conceptual hint.
            """.formatted(request.getQuestion(), request.getUserSql());

        String hint = llmClient.generateHint(prompt);

        return sanitize(hint);
    }

    private String sanitize(String hint) {
        if (hint.toLowerCase().contains("select")) {
            return "Focus on the underlying SQL concept rather than syntax.";
        }
        return hint;
    }
}

