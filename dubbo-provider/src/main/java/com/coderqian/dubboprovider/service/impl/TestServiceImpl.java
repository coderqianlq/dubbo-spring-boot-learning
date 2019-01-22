package com.coderqian.dubboprovider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.coderqian.dubboapi.service.TestService;
import com.coderqian.dubboprovider.mapper.UserMapper;
import com.coderqian.dubbocore.model.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author qianliqing
 * @date 2019-01-19 12:55 AM
 * mail: qianlq0824@gmail.com
 */

@Slf4j
@Service(version = "1.0.0", timeout = 5000, interfaceClass = TestService.class)
public class TestServiceImpl implements TestService {

    @Autowired
    private UserMapper userMapper;


    //    @HystrixCommand(commandProperties = {
//            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "3"),
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
//    })
    @Override
    public String test(String text) {
        return text;
    }

    @Override
    public List<UserEntity> testMybatis(String text) {
        log.info("测试数据：{}", text);
        return userMapper.findAll();
    }
}
