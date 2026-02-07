package com.codedebugger.language;

public enum CodeLanguage {
    JAVA,
    PYTHON,
    JAVASCRIPT,
    CPP;
    
    public static CodeLanguage fromString(String lang) {
        try {
            return CodeLanguage.valueOf(lang.toUpperCase());
        } catch (IllegalArgumentException e) {
            return JAVA; // Default or throw exception
        }
    }
}
