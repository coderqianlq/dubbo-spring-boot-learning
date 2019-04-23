package com.coderqian.dubboprovider.dao.impl;

import com.coderqian.dubbocore.model.entity.UserEntity;
import com.coderqian.dubboprovider.dao.UserDao;
import com.coderqian.dubboprovider.mapper.UserMapper;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author qianliqing
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
        user.setId(user.getId());
        return user;
    }

    @Override
    @CachePut(cacheNames = "user", key = "#user.id")
    public UserEntity updateUser(UserEntity user) {
        userMapper.updateUser(user);
        return user;
    }
}
