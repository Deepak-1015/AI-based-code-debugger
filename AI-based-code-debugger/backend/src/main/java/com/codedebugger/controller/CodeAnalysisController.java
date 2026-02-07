package com.codedebugger.controller;

import com.codedebugger.dto.AnalysisResultDTO;
import com.codedebugger.dto.CodeRequestDTO;
import com.codedebugger.model.CodeAnalysisResult;
import com.codedebugger.service.AnalysisHistoryService;
import com.codedebugger.service.CodeAnalysisService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/analysis")
@RequiredArgsConstructor
public class CodeAnalysisController {

    private final CodeAnalysisService analysisService;
    private final AnalysisHistoryService historyService;

    @PostMapping("/analyze")
    public ResponseEntity<AnalysisResultDTO> analyzeCode(@Valid @RequestBody CodeRequestDTO request) {
        AnalysisResultDTO result = analysisService.analyzeCode(request);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/history")
    public ResponseEntity<List<CodeAnalysisResult>> getHistory() {
        return ResponseEntity.ok(historyService.getAllHistory());
    }

    @GetMapping("/history/{id}")
    public ResponseEntity<CodeAnalysisResult> getHistoryById(@PathVariable Long id) {
        return ResponseEntity.ok(historyService.getHistoryById(id));
    }
}
