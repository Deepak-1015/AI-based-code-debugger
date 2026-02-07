package com.codedebugger.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComplexityDTO {
    private String timeComplexity;
    private String spaceComplexity;
    private String description;
}
