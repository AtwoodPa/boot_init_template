package com.pp.boot.common.exception;

import com.pp.boot.common.base.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

/**
 * 全局异常处理
 * @author supanpan
 * @date 2024/06/30
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 自定义异常 - 测试
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Result<?>> handleCustomException(CustomException ex, WebRequest request) {
        Result<?> result = Result.fail(ex.getErrorCode(), ex.getMessage());
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    /**
     * 未登录异常
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(NoLoginException.class)
    public ResponseEntity<Result<?>> handleNoLoginException(NoLoginException ex, WebRequest request) {
        Result<?> result = Result.fail(ex.getErrorCode(), ex.getMessage());
        return new ResponseEntity<>(result, HttpStatus.UNAUTHORIZED);
    }


    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Result<?>> handleAllExceptions(Exception ex, WebRequest request) {
        Result<?> result = Result.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Server Error");
        return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
