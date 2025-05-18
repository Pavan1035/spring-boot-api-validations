package com.sisotech.apivalidation.validator;

@FunctionalInterface
public interface StringValidator {
    boolean isValid(String input);
}
