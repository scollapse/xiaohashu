package com.syllable.framework.contextholder.holder;


import com.alibaba.ttl.TransmittableThreadLocal;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @description:  HashMapContextHolder
 * @author: syl
 * @create: 2025-09-08 17:08
 **/
public class HashMapContextHolder {

    // 初始化一个 ThreadLocal 变量
    private static final ThreadLocal<Map<String, Object>> HASH_MAP_CONTEXT_THREAD_LOCAL
            = TransmittableThreadLocal.withInitial(HashMap::new);


    /**
     * 设置用户 ID
     *
     * @param value
     */
    public static void set(String key,Object value) {
        HASH_MAP_CONTEXT_THREAD_LOCAL.get().put(key, value);
    }

    /**
     * 获取用户 ID
     *
     * @return
     */
    public static Long get(String key) {
        Object value = HASH_MAP_CONTEXT_THREAD_LOCAL.get().get(key);
        if (Objects.isNull(value)) {
            return null;
        }
        return Long.valueOf(value.toString());
    }

    /**
     * 删除 ThreadLocal
     */
    public static void remove() {
        HASH_MAP_CONTEXT_THREAD_LOCAL.remove();
    }

}
