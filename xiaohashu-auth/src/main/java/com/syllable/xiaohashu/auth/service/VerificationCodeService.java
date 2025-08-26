package com.syllable.xiaohashu.auth.service;

import com.syllable.framework.common.response.Response;
import com.syllable.xiaohashu.auth.model.vo.verificationcode.SendVerificationCodeReqVO;

public interface VerificationCodeService {
    /**
     * 发送短信验证码
     *
     * @param sendVerificationCodeReqVO
     * @return
     */
    Response<?> send(SendVerificationCodeReqVO sendVerificationCodeReqVO);
}
