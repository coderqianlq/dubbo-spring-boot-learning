package com.coderqian.dubboservice.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.coderqian.dubboapi.service.TestService;
import com.coderqian.dubbocore.mapper.UserMapper;
import com.coderqian.dubbocore.model.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author qianliqing
 * @date 2019-01-19 12:55 AM
 * mail: qianlq0824@gmail.com
 */

@Service
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
        return userMapper.findAll();
    }
}
