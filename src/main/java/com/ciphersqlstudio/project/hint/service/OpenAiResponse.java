package com.ciphersqlstudio.project.hint.service;

import java.util.List;

public class OpenAiResponse {

    private List<Choice> choices;

    public String getFirstMessage() {
        if (choices == null || choices.isEmpty()) {
            return "No hint available at this time.";
        }
        return choices.get(0).message.content;
    }

    static class Choice {
        Message message;
    }

    static class Message {
        String content;
    }
}

