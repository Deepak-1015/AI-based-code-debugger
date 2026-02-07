package com.codedebugger.pipeline;

import com.codedebugger.dto.AnalysisResultDTO;
import com.codedebugger.dto.CodeRequestDTO;
import com.codedebugger.dto.ComplexityDTO;
import com.codedebugger.dto.OptimizationDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Data
public class AnalysisContext {
    private final CodeRequestDTO request;
    private final AnalysisResultDTO result;
    private final Map<String, Object> intermediateData;

    public AnalysisContext(CodeRequestDTO request) {
        this.request = request;
        this.result = AnalysisResultDTO.builder()
                .errors(new ArrayList<>())
                .complexity(new ComplexityDTO())
                .optimization(new OptimizationDTO())
                .isSuccess(true) // Default to true, set to false if critical error occurs
                .build();
        this.intermediateData = new HashMap<>();
    }
}
