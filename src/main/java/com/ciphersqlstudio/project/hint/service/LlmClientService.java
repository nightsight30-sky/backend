package com.ciphersqlstudio.project.hint.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class LlmClientService {

    private final WebClient webClient;

    public LlmClientService(@Value("${OPENAI_API_KEY}") String apiKey) {
        if (apiKey == null || apiKey.isBlank()) {
            throw new IllegalStateException("LLM API key is not configured");
        }
        this.webClient = WebClient.builder()
                .baseUrl("https://api.openai.com/v1/chat/completions")
                .defaultHeader("Authorization", "Bearer " + apiKey)
                .defaultHeader("Content-Type", "application/json")
                .build();
    }

    public String generateHint(String prompt) {
        try {
            OpenAiRequest request = new OpenAiRequest(prompt);

            OpenAiResponse response = webClient.post()
                    .bodyValue(request)
                    .retrieve()
                    .onStatus(
                            status -> !status.is2xxSuccessful(),
                            clientResponse ->
                                    clientResponse.bodyToMono(String.class)
                                            .map(body -> new RuntimeException(
                                                    "OpenAI API error: " + body
                                            ))
                    )
                    .bodyToMono(OpenAiResponse.class)
                    .block();

            if (response == null) {
                return "Hint service unavailable.";
            }

            return response.getFirstMessage();

        } catch (Exception ex) {
            ex.printStackTrace();
            return "Hint service temporarily unavailable. Please try again.";
        }
    }

}
