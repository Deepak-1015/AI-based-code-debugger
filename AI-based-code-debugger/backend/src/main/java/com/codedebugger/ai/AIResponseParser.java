package com.codedebugger.ai;

import org.springframework.stereotype.Component;

@Component
public class AIResponseParser {

    public String extractJson(String llmResponse) {
        // Basic logic to extract JSON from markdown code blocks if present
        if (llmResponse.contains("```json")) {
            int start = llmResponse.indexOf("```json") + 7;
            int end = llmResponse.indexOf("```", start);
            if (end > start) {
                return llmResponse.substring(start, end).trim();
            }
        }
        return llmResponse;
    }
}
