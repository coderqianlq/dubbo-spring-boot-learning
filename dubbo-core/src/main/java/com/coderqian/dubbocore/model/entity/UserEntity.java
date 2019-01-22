package com.coderqian.dubbocore.model.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author qianliqing
 * @date 2019/1/18 6:59 PM
 * email: qianlq0824@gmail.com
 */

@Data
public class UserEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 3797543733143111985L;

    private String id;

    private String name;

    private String birth;
}
