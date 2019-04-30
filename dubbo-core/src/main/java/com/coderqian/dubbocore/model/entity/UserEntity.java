package com.coderqian.dubbocore.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author qianliqing
 * @date 2019/1/18 6:59 PM
 * email: qianlq0824@gmail.com
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 3797543733143111985L;

    private String id;

    private String name;

    private String birth;
}
