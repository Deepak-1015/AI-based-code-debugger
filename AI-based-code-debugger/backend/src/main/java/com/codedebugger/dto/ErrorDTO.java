package com.codedebugger.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDTO {
    private String type; // SYNTAX, LOGICAL, RUNTIME, COMPILE_TIME
    private int line;
    private String message;
    private String suggestion;
    private String severity; // HIGH, MEDIUM, LOW
}
