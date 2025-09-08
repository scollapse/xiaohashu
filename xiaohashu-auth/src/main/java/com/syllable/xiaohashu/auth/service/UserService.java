package com.syllable.xiaohashu.auth.service;


import com.syllable.framework.common.response.Response;
import com.syllable.xiaohashu.auth.model.vo.user.UserLoginReqVO;

/**
 * @author: 犬小哈
 * @date: 2024/4/7 15:41
 * @version: v1.0.0
 * @description: TODO
 **/
public interface UserService {

    /**
     * 登录与注册
     * @param userLoginReqVO
     * @return
     */
    Response<String> loginAndRegister(UserLoginReqVO userLoginReqVO);


    /**
     * 退出登录
     * @return
     */
    Response<?> logout(Long userId);
}

