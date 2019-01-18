package com.coderqian.dubboprovider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.coderqian.dubboapi.service.TestService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.swagger.annotations.ApiParam;

/**
 * @author qianliqing
 * @date 2018/11/29 12:53 PM
 * email: qianlq0824@gmail.com
 */

@Service
public class TestServiceImpl implements TestService {

    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "3"),
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    })
    @Override
    public String test(@ApiParam(value = "测试数据", required = true) String text) {
        return text;
    }
}
