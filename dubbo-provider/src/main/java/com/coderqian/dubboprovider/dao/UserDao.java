package com.coderqian.dubboprovider.dao;

import com.coderqian.dubbocore.model.entity.UserEntity;

/**
 * @author qianliqing
 * @date 2019/4/22 8:33 PM
 * email: qianlq0824@gmail.com
 */

public interface UserDao {

    /**
     * 插入用户
     *
     * @param user 用户实体
     * @return UserEntity
     */
    UserEntity insertUser(UserEntity user);

    /**
     * 更新
     *
     * @param user 用户实体
     * @return UserEntity
     */
    UserEntity updateUser(UserEntity user);
}
