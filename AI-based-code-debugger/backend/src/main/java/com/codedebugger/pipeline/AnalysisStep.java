package com.codedebugger.pipeline;

public interface AnalysisStep {
    void execute(AnalysisContext context);
    
    // Optional order definition if using ordered list injection
    default int getOrder() {
        return 0;
    }
}
