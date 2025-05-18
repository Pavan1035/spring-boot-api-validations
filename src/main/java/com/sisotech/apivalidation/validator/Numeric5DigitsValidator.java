package com.sisotech.apivalidation.validator;

import org.springframework.stereotype.Component;

@Component("numeric5DigitsValidator")
public class Numeric5DigitsValidator implements StringValidator {
    public boolean isValid(String input) {
        return input != null && input.matches("^\\d{5}$");
    }
}
