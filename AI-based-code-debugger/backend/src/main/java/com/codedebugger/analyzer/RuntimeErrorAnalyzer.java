package com.codedebugger.analyzer;

import com.codedebugger.pipeline.AnalysisContext;
import com.codedebugger.pipeline.AnalysisStep;
import org.springframework.stereotype.Component;

@Component
public class RuntimeErrorAnalyzer implements AnalysisStep {

    @Override
    public void execute(AnalysisContext context) {
        // Runtime analysis requires safe execution sandbox (Docker/isolate)
        // This is a placeholder for Phase 2
    }

    @Override
    public int getOrder() {
        return 40;
    }
}
