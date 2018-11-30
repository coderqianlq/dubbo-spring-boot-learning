package com.coderqian.dubboconsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.coderqian.dubboapi.service.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qianliqing
 * @date 2018/11/29 1:52 PM
 * email: qianliqing@hyperchain.com
 */

@RestController
@RequestMapping("/customer")
public class TestController {

    @Reference
    private TestService testService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String test(String text) {
        return testService.test(text);
    }
}
