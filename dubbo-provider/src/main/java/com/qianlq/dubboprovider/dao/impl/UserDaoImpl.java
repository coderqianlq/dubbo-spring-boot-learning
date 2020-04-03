package com.qianlq.dubboprovider.dao.impl;

import com.qianlq.dubbocore.model.entity.UserEntity;
import com.qianlq.dubboprovider.dao.UserDao;
import com.qianlq.dubboprovider.mapper.UserMapper;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author CoderQian
 * @date 2019/4/22 8:34 PM
 * email: qianlq0824@gmail.com
 */

@Repository
public class UserDaoImpl implements UserDao {

    @Resource
    private UserMapper userMapper;

    @Override
    @CachePut(cacheNames = "user", key = "#user.id")
    public UserEntity insertUser(UserEntity user) {
        userMapper.insertUser(user);
        return user;
    }

    @Override
    @CachePut(cacheNames = "user", key = "#user.id")
    public UserEntity updateUser(UserEntity user) {
        userMapper.updateUser(user);
        return user;
    }
}
