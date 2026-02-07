package com.codedebugger.optimization;

import com.codedebugger.ai.AIReasoningService;
import com.codedebugger.dto.OptimizationDTO;
import com.codedebugger.pipeline.AnalysisContext;
import com.codedebugger.pipeline.AnalysisStep;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Collections;

@Component
@RequiredArgsConstructor
public class OptimizationService implements AnalysisStep {

    private final AIReasoningService aiReasoningService;

    @Override
    public void execute(AnalysisContext context) {
        String code = context.getRequest().getCode();
        String suggestion = aiReasoningService.suggestOptimization(code);
        
        OptimizationDTO optimization = context.getResult().getOptimization();
        optimization.setExplanation(suggestion);
        // optimization.setOptimizedCode(...) // Parse from suggestion
        // optimization.setImprovements(...)
    }

    @Override
    public int getOrder() {
        return 60;
    }
}
