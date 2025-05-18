package com.sisotech.apivalidation.validator;

import org.springframework.stereotype.Component;

@Component("uppercase3LettersValidator")
public class Uppercase3LettersValidator implements StringValidator {
    public boolean isValid(String input) {
        return input != null && input.matches("^[A-Z]{3}$");
    }
}
