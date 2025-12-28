package com.ciphersqlstudio.project.hint.service;

import java.util.List;

public class OpenAiRequest {

    private String model;
    private List<Message> messages;

    public OpenAiRequest(String prompt) {
        this.model = "gpt-4o-mini";
        this.messages = List.of(new Message("user", prompt));
    }

    static class Message {
        public String role;
        public String content;

        public Message(String role, String content) {
            this.role = role;
            this.content = content;
        }
    }
}
