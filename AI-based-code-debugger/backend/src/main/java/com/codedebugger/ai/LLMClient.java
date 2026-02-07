package com.codedebugger.ai;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LLMClient {

    @Value("${llm.api.key:dummy}")
    private String apiKey;

    @Value("${llm.model:gpt-4}")
    private String model;

    public String sendRequest(String prompt) {
        // Implement logic to call LLM API (OpenAI / Gemini / etc.)
        // For now, return a mock response or log the interaction
        System.out.println("Sending prompt to LLM: " + prompt);
        return "Mock LLM Response for prompt: " + prompt.substring(0, Math.min(prompt.length(), 50)) + "...";
    }
}
