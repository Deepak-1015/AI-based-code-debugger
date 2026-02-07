package com.codedebugger.complexity;

import com.codedebugger.pipeline.AnalysisContext;
import com.codedebugger.pipeline.AnalysisStep;
import org.springframework.stereotype.Component;

@Component
public class SpaceComplexityAnalyzer implements AnalysisStep {

    @Override
    public void execute(AnalysisContext context) {
        // Similar to TimeComplexity, can use AI or static analysis
        // For now, assume TimeComplexityAnalyzer handles both or this is a placeholder
    }

    @Override
    public int getOrder() {
        return 51;
    }
}
