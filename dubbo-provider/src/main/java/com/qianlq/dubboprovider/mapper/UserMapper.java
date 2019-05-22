package com.qianlq.dubboprovider.mapper;

import com.qianlq.dubbocore.model.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author qianliqing
 * @date 2019/1/18 7:58 PM
 * email: qianlq0824@gmail.com
 */

@Mapper
public interface UserMapper {

    /**
     * 查询所有用户
     *
     * @return List<UserEntity>
     */
    List<UserEntity> findAll();

    /**
     * 插入用户，返回用户id
     *
     * @param user 用户实体
     * @return Long
     */
    Long insertUser(UserEntity user);

    /**
     * 更新用户
     *
     * @param user 用户实体
     * @return Long
     */
    Long updateUser(UserEntity user);
}
