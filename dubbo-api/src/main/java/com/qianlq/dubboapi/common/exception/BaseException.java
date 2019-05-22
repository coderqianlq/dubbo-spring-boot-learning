package com.qianlq.dubboapi.common.exception;

import com.qianlq.dubbocore.common.BaseResult;
import lombok.Data;

import java.io.Serializable;

/**
 * @author qianliqing
 * @date 2019-04-04 9:14 AM
 * mail: qianlq0824@gmail.com
 * <p>
 * 基本异常类
 */

@Data
public abstract class BaseException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 6626955017515697809L;

    private int code;
    private String msg;
    private BaseResult baseResult;

    BaseException() {
        super();
    }

    BaseException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
        this.baseResult = new BaseResult(code, msg);
    }
}
