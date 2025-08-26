package com.syllable.xiaohashu.auth.constant;


/**
 * @description: redis常量
 * @author: syl
 * @create: 2025-08-26 16:15
 **/
public class RedisKeyConstants {

    /**
     * 验证码 KEY 前缀
     */
    public static final String VERIFICATION_CODE_KEY_PREFIX = "verification_code:";

    /**
     * 构建验证码 KEY
     * @param mobile
     * @return
     */
    public static String buildVerificationCodeKey(String mobile) {
        return VERIFICATION_CODE_KEY_PREFIX + mobile;
    }
}
