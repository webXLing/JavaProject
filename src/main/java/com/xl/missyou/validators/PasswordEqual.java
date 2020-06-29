package com.xl.missyou.validators;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
// 关联校验类
@Constraint(validatedBy = PasswordValidator.class)
public @interface PasswordEqual {
    String message() default "password is wrong";

    int min() default 2;
    int max() default 6;

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};


}
