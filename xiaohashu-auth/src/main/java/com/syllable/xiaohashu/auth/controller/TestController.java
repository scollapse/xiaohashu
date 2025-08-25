package com.syllable.xiaohashu.auth.controller;


import com.syllable.framework.common.response.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 测试控制器
 * @author: syl
 * @create: 2025-08-25 11:17
 **/
@RestController
public class TestController {


    @GetMapping("/test")
    public Response<String> test() {
        return Response.success("success");
    }
}
