package com.codedebugger.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;

@Data
public class CodeRequestDTO {
    @NotBlank(message = "Code cannot be empty")
    private String code;
    
    @NotBlank(message = "Language cannot be empty")
    private String language;
    
    private String description;
}
