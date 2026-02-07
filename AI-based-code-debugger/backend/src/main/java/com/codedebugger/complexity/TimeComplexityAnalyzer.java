package com.codedebugger.complexity;

import com.codedebugger.ai.AIReasoningService;
import com.codedebugger.dto.ComplexityDTO;
import com.codedebugger.pipeline.AnalysisContext;
import com.codedebugger.pipeline.AnalysisStep;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TimeComplexityAnalyzer implements AnalysisStep {

    private final AIReasoningService aiReasoningService;

    @Override
    public void execute(AnalysisContext context) {
        String code = context.getRequest().getCode();
        String complexityAnalysis = aiReasoningService.analyzeComplexity(code);
        
        // Parse complexityAnalysis to extract Big O notation if possible
        // For now, put the whole response in description
        ComplexityDTO complexity = context.getResult().getComplexity();
        complexity.setDescription(complexityAnalysis);
        // complexity.setTimeComplexity(parsed value);
    }

    @Override
    public int getOrder() {
        return 50;
    }
}
