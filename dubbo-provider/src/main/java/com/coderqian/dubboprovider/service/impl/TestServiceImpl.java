package com.coderqian.dubboprovider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.coderqian.dubboapi.service.TestService;

/**
 * @author qianliqing
 * @date 2018/11/29 12:53 PM
 * email: qianliqing@hyperchain.com
 */

@Service
public class TestServiceImpl implements TestService {

    @Override
    public String test(String text) {
        return text;
    }
}
