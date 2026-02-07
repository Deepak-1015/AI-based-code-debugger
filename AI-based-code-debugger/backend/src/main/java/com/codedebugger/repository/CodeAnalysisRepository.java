package com.codedebugger.repository;

import com.codedebugger.model.CodeAnalysisResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeAnalysisRepository extends JpaRepository<CodeAnalysisResult, Long> {
}
