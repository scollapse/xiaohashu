package com.syllable.framework.common.validator;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * @description: 手机号码验证器
 * @author: syl
 * @create: 2025-08-29 14:49
 **/
public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {
    @Override
    public void initialize(PhoneNumber constraintAnnotation) {
        // 初始化操作
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
        // 校验逻辑
        return phoneNumber != null && phoneNumber.matches("\\d{11}");
    }
}
