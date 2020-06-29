package com.xl.missyou.validators;

import com.xl.missyou.dto.PersionDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator  implements ConstraintValidator<PasswordEqual, PersionDTO> {
    private int min;
    private int max;
    @Override
    public void initialize(PasswordEqual constraintAnnotation) {
        int min = constraintAnnotation.min();
        int max = constraintAnnotation.max();
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean isValid(PersionDTO persionDTO, ConstraintValidatorContext constraintValidatorContext) {
        String password1 = persionDTO.getPassword1();
        String password2 = persionDTO.getPassword2();
        if (password1.length()<min){
            return false;
        }
        return password1.equals(password2);
    }
}
