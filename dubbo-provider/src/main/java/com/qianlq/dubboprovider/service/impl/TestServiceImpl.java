package com.qianlq.dubboprovider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.qianlq.dubboapi.service.TestService;
import com.qianlq.dubbocore.common.BaseResult;
import com.qianlq.dubbocore.common.constant.Code;
import com.qianlq.dubbocore.model.dto.UserDto;
import com.qianlq.dubbocore.model.entity.UserEntity;
import com.qianlq.dubboprovider.converter.User2UserDtoMapper;
import com.qianlq.dubboprovider.dao.UserDao;
import com.qianlq.dubboprovider.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author CoderQian
 * @date 2019-01-19 12:55 AM
 * mail: qianlq0824@gmail.com
 */

@Slf4j
@Service(version = "1.0.0", timeout = 5000, interfaceClass = TestService.class)
public class TestServiceImpl implements TestService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserDao userDao;


    //    @HystrixCommand(commandProperties = {
//            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "3"),
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
//    })
    @Override
    public String test(String text) {
        return text;
    }

    @Override
    public List<UserDto> testMybatis(String text) {
        log.info("测试数据：{}", text);
        List<UserEntity> users = userMapper.findAll();
        return User2UserDtoMapper.INSTANCE.users2UserDtos(users);
    }

    @Override
    public BaseResult testException() {
        return new BaseResult();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BaseResult addUser(String name, String birth) {
        UserEntity user = new UserEntity();
        user.setName(name);
        user.setBirth(birth);
        return new BaseResult<>(Code.SUCCESS, userDao.insertUser(user));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BaseResult updateUser(String id, String name, String birth) {
        UserEntity user = new UserEntity();
        user.setId(id);
        user.setName(name);
        user.setBirth(birth);
        return new BaseResult<>(Code.SUCCESS, userDao.updateUser(user));
    }
}
