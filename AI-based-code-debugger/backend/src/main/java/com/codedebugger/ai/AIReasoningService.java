package com.codedebugger.ai;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AIReasoningService {

    private final LLMClient llmClient;
    private final PromptBuilder promptBuilder;
    private final AIResponseParser responseParser;

    public String analyzeErrorCode(String code, String errorContext) {
        String prompt = promptBuilder.buildPrompt("error_analysis_prompt.txt", code, errorContext);
        return llmClient.sendRequest(prompt);
    }
    
    public String analyzeComplexity(String code) {
        String prompt = promptBuilder.buildPrompt("complexity_prompt.txt", code, "");
        return llmClient.sendRequest(prompt);
    }

    public String suggestOptimization(String code) {
        String prompt = promptBuilder.buildPrompt("optimization_prompt.txt", code, "");
        return llmClient.sendRequest(prompt);
    }
}
