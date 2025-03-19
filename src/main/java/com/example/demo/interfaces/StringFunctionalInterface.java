package com.example.demo.interfaces;

@FunctionalInterface
public interface StringFunctionalInterface {
    String upperCase(String s);

    static String lowerCase(String s) {
        return s.toLowerCase();
    }
}
