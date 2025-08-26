package com.syllable.xiaohashu.auth.controller;


import com.syllable.framework.biz.operationlog.aspect.ApiOperationLog;
import com.syllable.framework.common.response.Response;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @description: 测试控制器
 * @author: syl
 * @create: 2025-08-25 11:17
 **/
@RestController
public class TestController {


    @GetMapping("/test")
    @ApiOperationLog(description = "测试接口")
    public Response<String> test() {
        return Response.success("success");
    }

    @PostMapping("/test2")
    @ApiOperationLog(description = "测试接口2")
    public Response<User> test2(@RequestBody @Validated User user) {
      return Response.success(user);
    }

}
