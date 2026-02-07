package com.codedebugger.service;

import com.codedebugger.model.CodeAnalysisResult;
import com.codedebugger.repository.CodeAnalysisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnalysisHistoryService {

    private final CodeAnalysisRepository repository;

    public List<CodeAnalysisResult> getAllHistory() {
        return repository.findAll();
    }
    
    public CodeAnalysisResult getHistoryById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("History not found"));
    }
}
