package com.codedebugger.pipeline;

import com.codedebugger.dto.AnalysisResultDTO;
import com.codedebugger.dto.CodeRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AnalysisPipeline {

    private final List<AnalysisStep> steps;

    public AnalysisResultDTO execute(CodeRequestDTO request) {
        AnalysisContext context = new AnalysisContext(request);
        long startTime = System.currentTimeMillis();

        // Sort steps if order matters (based on getOrder())
        steps.stream()
            .sorted(Comparator.comparingInt(AnalysisStep::getOrder))
            .forEach(step -> {
                try {
                    step.execute(context);
                } catch (Exception e) {
                    context.getResult().setSuccess(false);
                    // Add generic error or handle specifically
                    // For now, we continue execution or break based on design.
                    // Let's assume we log and continue or mark fatal errors.
                }
            });

        long endTime = System.currentTimeMillis();
        context.getResult().setExecutionTimeMs(endTime - startTime);
        return context.getResult();
    }
}
