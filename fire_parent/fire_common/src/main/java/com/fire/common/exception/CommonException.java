package com.fire.common.exception;

import com.fire.common.model.StatusCode;
import lombok.Getter;

/**
 * 自定义异常
 */
@Getter
public class CommonException extends Exception  {

    private int statusCode;

    public CommonException(int statusCode,String message) {
        super(message);
        this.statusCode = statusCode;
    }
}
