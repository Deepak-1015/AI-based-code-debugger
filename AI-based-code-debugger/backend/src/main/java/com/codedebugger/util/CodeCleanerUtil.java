package com.codedebugger.util;

public class CodeCleanerUtil {

    public static String cleanCode(String code) {
        if (code == null) return null;
        // Remove comments implementation
        // normalize whitespace
        return code.trim();
    }
}
