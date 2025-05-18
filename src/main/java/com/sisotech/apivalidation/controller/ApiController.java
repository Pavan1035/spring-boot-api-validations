package com.sisotech.apivalidation.controller;

import com.sisotech.apivalidation.validator.FunctionalValidation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

@RestController
@RequestMapping("/api")
@Validated
public class ApiController {

    @GetMapping("/alpha/{code}")
    public ResponseEntity<String> validateAlpha(
            @PathVariable @FunctionalValidation(beanName = "uppercase3LettersValidator") String code) {
        return ResponseEntity.ok("Valid Alpha Code");
    }

    @GetMapping("/zip/{zip}")
    public ResponseEntity<String> validateZip(
            @PathVariable @FunctionalValidation(beanName = "numeric5DigitsValidator") String zip) {
        return ResponseEntity.ok("Valid Zip Code");
    }
}
