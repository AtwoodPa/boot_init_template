package com.pp.boot.common.exception;

/**
 * 自定义异常
 * @author supanpan
 * @date 2024/06/30
 */
public class CustomException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private final int errorCode;

    public CustomException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
