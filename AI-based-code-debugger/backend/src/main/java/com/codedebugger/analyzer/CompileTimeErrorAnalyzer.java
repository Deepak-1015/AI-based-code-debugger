package com.codedebugger.analyzer;

import com.codedebugger.pipeline.AnalysisContext;
import com.codedebugger.pipeline.AnalysisStep;
import org.springframework.stereotype.Component;

@Component
public class CompileTimeErrorAnalyzer implements AnalysisStep {

    @Override
    public void execute(AnalysisContext context) {
        // In a real implementation, this would invoke a compiler (javac, gcc, etc.)
        // For now, we assume syntax analysis covers most static errors or AI will catch them
    }

    @Override
    public int getOrder() {
        return 20;
    }
}
