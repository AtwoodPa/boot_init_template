package com.pp.boot.common.exception;

import com.pp.boot.common.base.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
    protected Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 自定义异常 - 测试
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(CustomException.class)
    public Result handleCustomException(CustomException ex, WebRequest request) {
        return Result.fail(ex.getErrorCode(), ex.getMessage());
    }

    /**
     * 未登录异常
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(NoLoginException.class)
    public Result handleNoLoginException(NoLoginException ex, WebRequest request) {
        return Result.fail(ex.getErrorCode(), ex.getMessage());
    }



    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handleValidationExceptions(MethodArgumentNotValidException ex) {
        logger.error("[handleValidationExceptions]", ex);
        StringBuilder sb = new StringBuilder();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((org.springframework.validation.FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            sb.append(fieldName).append(":").append(errorMessage).append(";");
        });
        return Result.fail(sb.toString());
    }

    /**
     * 处理系统异常，兜底处理所有的一切
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result handleAllExceptions(Exception ex, WebRequest request) {
        logger.error("[defaultExceptionHandler]", ex);
        return  Result.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Server Error");
    }

}
