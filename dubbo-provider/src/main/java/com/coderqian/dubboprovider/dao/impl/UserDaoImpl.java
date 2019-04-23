package com.coderqian.dubboprovider.dao.impl;

import com.coderqian.dubbocore.model.entity.UserEntity;
import com.coderqian.dubboprovider.dao.UserDao;
import com.coderqian.dubboprovider.mapper.UserMapper;
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
    public UserEntity insertUser(String name, String birth) {
        UserEntity user = new UserEntity();
        user.setName(name);
        user.setBirth(birth);
        userMapper.insertUser(user);
        user.setId(user.getId());
        return user;
    }

    @Override
    public UserEntity updateUser(String id, String name, String birth) {
        UserEntity user = new UserEntity();
        user.setId(id);
        user.setName(name);
        user.setBirth(birth);
        userMapper.updateUser(user);
        return user;
    }
}
