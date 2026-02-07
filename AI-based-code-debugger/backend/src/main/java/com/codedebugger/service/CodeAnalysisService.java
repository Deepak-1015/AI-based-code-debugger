package com.codedebugger.service;

import com.codedebugger.dto.AnalysisResultDTO;
import com.codedebugger.dto.CodeRequestDTO;
import com.codedebugger.model.CodeAnalysisResult;
import com.codedebugger.pipeline.AnalysisPipeline;
import com.codedebugger.repository.CodeAnalysisRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CodeAnalysisService {

    private final AnalysisPipeline analysisPipeline;
    private final CodeAnalysisRepository analysisRepository;
    private final ObjectMapper objectMapper;

    public AnalysisResultDTO analyzeCode(CodeRequestDTO request) {
        // Run pipeline
        AnalysisResultDTO result = analysisPipeline.execute(request);

        // Save result asynchronously or synchronously
        saveAnalysisResult(request, result);

        return result;
    }

    private void saveAnalysisResult(CodeRequestDTO request, AnalysisResultDTO result) {
        try {
            CodeAnalysisResult entity = CodeAnalysisResult.builder()
                    .code(request.getCode())
                    .language(request.getLanguage())
                    .resultJson(objectMapper.writeValueAsString(result))
                    .build();
            analysisRepository.save(entity);
        } catch (Exception e) {
            // Log error but don't fail analysis
            e.printStackTrace();
        }
    }
}
