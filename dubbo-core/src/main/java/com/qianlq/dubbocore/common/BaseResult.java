package com.qianlq.dubbocore.common;

import com.qianlq.dubbocore.common.constant.Code;
import lombok.Data;

import java.io.Serializable;

/**
 * @author qianliqing
 * @date 2018-09-28 下午9:05
 * mail: qianlq0824@gmail.com
 * <p>
 * 统一的返回类型
 */

@Data
@SuppressWarnings("unchecked")
public final class BaseResult<T> implements Serializable {

    private static final long serialVersionUID = 1083278621411096793L;

    private int code;
    private String message;
    private T data = (T) new Object();

    public BaseResult() {
        this.data = (T) new Object();
    }

    public BaseResult(String msg) {
        this();
        this.code = 200;
        this.message = msg;
    }

    public BaseResult(Code code) {
        this.code = code.getCode();
        this.message = code.getMsg();
    }

    public BaseResult(Code code, T data) {
        this.code = code.getCode();
        this.message = code.getMsg();
        this.data = data;
    }

    public BaseResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return "BaseResult{"
                + "code=" + code
                + ", message='" + message
                + ", data=" + data
                + '}';
    }
}
