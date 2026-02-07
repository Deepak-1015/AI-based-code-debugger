package com.codedebugger.parser;

import com.codedebugger.dto.ErrorDTO;
import java.util.List;

public interface CodeParser {
    List<ErrorDTO> parse(String code);
}
