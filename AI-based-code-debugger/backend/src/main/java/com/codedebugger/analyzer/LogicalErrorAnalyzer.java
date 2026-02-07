package com.codedebugger.analyzer;

import com.codedebugger.ai.AIReasoningService;
import com.codedebugger.pipeline.AnalysisContext;
import com.codedebugger.pipeline.AnalysisStep;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LogicalErrorAnalyzer implements AnalysisStep {

    private final AIReasoningService aiReasoningService;

    @Override
    public void execute(AnalysisContext context) {
        // Only run if no severe syntax errors?
        String code = context.getRequest().getCode();
        String analysis = aiReasoningService.analyzeErrorCode(code, "Check for logical errors");
        
        // Parse analysis result and add to context
        // For now, we append to AI feedback
        String currentFeedback = context.getResult().getAiFeedback();
        context.getResult().setAiFeedback((currentFeedback != null ? currentFeedback : "") + "\nLogical Analysis:\n" + analysis);
    }
    
    @Override
    public int getOrder() {
        return 30;
    }
}
