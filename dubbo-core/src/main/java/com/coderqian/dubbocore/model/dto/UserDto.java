package com.coderqian.dubbocore.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author qianliqing
 * @date 2019-01-28 10:56 AM
 * mail: qianlq0824@gmail.com
 */

@Data
public class UserDto implements Serializable {

    private static final long serialVersionUID = -7268430585753956377L;

    private String id;

    private String name;

    private String birth;
}
