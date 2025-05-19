package com.noraai.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.*;

@Component
public class ClaudeClient {

    @Value("${claude.api.key}")
    private String apiKey;

    @Value("${claude.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public String getNextQuestion(String context, String lastAnswer) {
        try {
            Map<String, Object> message = Map.of(
                "model", "claude-3-sonnet-20240229",
                "max_tokens", 100,
                "messages", List.of(
                    Map.of("role", "user", "content", context + "\n\nCandidate: " + lastAnswer + "\nNext question:")
                )
            );

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("x-api-key", apiKey);
            headers.set("anthropic-version", "2023-06-01");

            HttpEntity<Map<String, Object>> entity = new HttpEntity<>(message, headers);

            ResponseEntity<Map> response = restTemplate.exchange(apiUrl, HttpMethod.POST, entity, Map.class);

            Map<String, Object> body = response.getBody();
            List<Map<String, Object>> completions = (List<Map<String, Object>>) body.get("content");
            return (String) completions.get(0).get("text");

        } catch (Exception e) {
            return "Thanks for your response. Can you elaborate further?";
        }
    }
}