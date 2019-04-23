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
     * @param name  姓名
     * @param birth 出生日期
     * @return UserEntity
     */
    UserEntity insertUser(String name, String birth);

    /**
     * 更新
     *
     * @param id    id
     * @param name  姓名
     * @param birth 出生日期
     * @return UserEntity
     */
    UserEntity updateUser(String id, String name, String birth);
}
