package com.qianlq.dubbocore.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author CoderQian
 * @date 2019/1/18 6:59 PM
 * email: qianlq0824@gmail.com
 */

@Data
@NoArgsConstructor
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = -2892487135997367620L;
}
