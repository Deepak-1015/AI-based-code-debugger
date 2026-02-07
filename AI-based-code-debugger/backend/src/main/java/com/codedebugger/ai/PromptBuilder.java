package com.codedebugger.ai;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
public class PromptBuilder {

    public String buildPrompt(String templateName, String code, String context) {
        try {
            ClassPathResource resource = new ClassPathResource("prompts/" + templateName);
            String template = new String(resource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
            return template.replace("{{CODE}}", code)
                           .replace("{{CONTEXT}}", context);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load prompt template: " + templateName, e);
        }
    }
}
