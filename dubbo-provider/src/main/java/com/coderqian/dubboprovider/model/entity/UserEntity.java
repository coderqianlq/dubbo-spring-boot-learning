package com.coderqian.dubboprovider.model.entity;

import lombok.Data;

/**
 * @author qianliqing
 * @date 2019/1/18 6:59 PM
 * email: qianlq0824@gmail.com
 */

@Data
public class UserEntity extends BaseEntity {

    private String id;

    private String name;

    private String birth;
}
