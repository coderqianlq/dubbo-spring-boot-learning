package com.coderqian.dubboprovider.mapper;

import com.coderqian.dubbocore.model.entity.UserEntity;
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
}
