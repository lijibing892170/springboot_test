package com.ljb.test.handler;

import com.ljb.test.constant.ErrorCode;
import com.ljb.test.model.BaseResponce;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理器
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public BaseResponce exceptionHandler(Exception e) {
        return new BaseResponce(false, ErrorCode.SERVER_FAIL, e.getMessage());
    }
}
