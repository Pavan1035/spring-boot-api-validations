package com.sisotech.apivalidation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class BeanInjectedValidator implements ConstraintValidator<FunctionalValidation, String> {

    @Autowired
    private ApplicationContext context;

    private String beanName;
    private StringValidator stringValidator;

    @Override
    public void initialize(FunctionalValidation annotation) {
        this.beanName = annotation.beanName();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (stringValidator == null) {
            stringValidator = this.context.getBean(beanName, StringValidator.class);
        }
        boolean valid = stringValidator.isValid(value);

        if (!valid) {
            // Disable default violation message
            context.disableDefaultConstraintViolation();

            // Add custom violation message
            context.buildConstraintViolationWithTemplate("Value '" + value + "' failed validation for bean: " + beanName)
                    .addConstraintViolation();
        }

        return valid;
    }
}
