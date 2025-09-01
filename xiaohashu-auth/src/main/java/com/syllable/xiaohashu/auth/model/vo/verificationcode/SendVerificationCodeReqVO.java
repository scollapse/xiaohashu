package com.syllable.xiaohashu.auth.model.vo.verificationcode;


import com.syllable.framework.common.validator.PhoneNumber;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 发送验证码请求参数对象
 * @author: syl
 * @create: 2025-08-26 16:12
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SendVerificationCodeReqVO {

    @NotBlank(message = "手机号不能为空")
    @PhoneNumber(message = "手机号格式不正确")
    private String phone;
}
