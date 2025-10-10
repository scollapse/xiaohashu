package com.syllable.framework.contextholder.holder;


import com.syllable.framework.common.constant.GlobalConstants;

import java.util.Objects;


/**
 * @author: 犬小哈
 * @date: 2024/4/9 18:19
 * @version: v1.0.0
 * @description: 登录用户上下文
 **/
public class LoginUserContextHolder {

    /**
     * 设置用户 ID
     *
     * @param value
     */
    public static void setUserId(Object value) {
        HashMapContextHolder.set(GlobalConstants.USER_ID, value);
    }

    /**
     * 获取用户 ID
     *
     * @return
     */
    public static Long getUserId() {
        Object value = HashMapContextHolder.get(GlobalConstants.USER_ID);
        if (Objects.isNull(value)) {
            return null;
        }
        return Long.valueOf(value.toString());
    }

    /**
     * 删除 ThreadLocal 
     */
    public static void remove() {
        HashMapContextHolder.remove();
    }

}
