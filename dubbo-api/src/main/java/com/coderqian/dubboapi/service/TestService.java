package com.coderqian.dubboapi.service;

import com.coderqian.dubbocore.common.BaseResult;
import com.coderqian.dubbocore.model.dto.UserDto;

import java.util.List;

/**
 * @author qianliqing
 * @date 2018/11/29 1:55 PM
 * email: qianlq0824@gmail.com
 */

public interface TestService {

    /**
     * 测试接口
     *
     * @param text 测试数据
     * @return String
     */
    String test(String text);

    /**
     * 测试接口
     *
     * @param text 测试数据
     * @return String
     */
    List<UserDto> testMybatis(String text);

    /**
     * 异常测试接口
     *
     * @return BaseResult
     */
    BaseResult testException();
}
