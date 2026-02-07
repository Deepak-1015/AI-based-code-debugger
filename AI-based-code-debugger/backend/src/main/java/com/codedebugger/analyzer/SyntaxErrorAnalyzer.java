package com.codedebugger.analyzer;

import com.codedebugger.dto.ErrorDTO;
import com.codedebugger.parser.CodeParser;
import com.codedebugger.pipeline.AnalysisContext;
import com.codedebugger.pipeline.AnalysisStep;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SyntaxErrorAnalyzer implements AnalysisStep {

    private final CodeParser codeParser;

    @Override
    public void execute(AnalysisContext context) {
        String code = context.getRequest().getCode();
        List<ErrorDTO> errors = codeParser.parse(code);
        
        if (!errors.isEmpty()) {
            context.getResult().getErrors().addAll(errors);
        }
    }

    @Override
    public int getOrder() {
        return 10;
    }
}
