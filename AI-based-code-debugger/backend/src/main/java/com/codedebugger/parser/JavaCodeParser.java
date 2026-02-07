package com.codedebugger.parser;

import com.codedebugger.dto.ErrorDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JavaCodeParser implements CodeParser {

    @Override
    public List<ErrorDTO> parse(String code) {
        // Implement Java syntax checking (e.g., using JavaParser library or javax.tools)
        // For now, returning empty list or mock errors
        List<ErrorDTO> errors = new ArrayList<>();
        if (!code.contains("class ")) {
             errors.add(ErrorDTO.builder()
                     .type("SYNTAX")
                     .message("Missing class definition")
                     .line(1)
                     .severity("HIGH")
                     .build());
        }
        return errors;
    }
}
