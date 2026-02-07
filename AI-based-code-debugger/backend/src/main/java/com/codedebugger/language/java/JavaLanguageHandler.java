package com.codedebugger.language.java;

import com.codedebugger.language.LanguageHandler;
import org.springframework.stereotype.Component;

@Component
public class JavaLanguageHandler implements LanguageHandler {
    
    @Override
    public String getSyntaxRules() {
        return "Java Syntax Rules...";
    }
}
