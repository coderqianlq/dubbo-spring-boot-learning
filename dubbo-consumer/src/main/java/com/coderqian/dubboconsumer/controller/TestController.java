package com.coderqian.dubboconsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.coderqian.dubboapi.service.TestService;
import com.coderqian.dubbocore.model.entity.UserEntity;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author qianliqing
 * @date 2018/11/29 1:52 PM
 * email: qianlq0824@gmail.com
 */

@RestController
@RequestMapping("/test")
public class TestController {

    @Reference(version = "1.0.0", timeout = 5000, interfaceClass = TestService.class, check = false)
    private TestService testService;

    @HystrixCommand(fallbackMethod = "testError")
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String test(String text) {
        return testService.test(text);
    }

    private String testError(String text) {
        return "失败" + text;
    }

    @RequestMapping(value = "/mybatis", method = RequestMethod.GET)
    public List<UserEntity> testMybatis(String text) {
        return testService.testMybatis(text);
    }
}
