package com.codedebugger.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnalysisResultDTO {
    private List<ErrorDTO> errors;
    private ComplexityDTO complexity;
    private OptimizationDTO optimization;
    private String aiFeedback;
    private boolean isSuccess;
    private long executionTimeMs;
}
