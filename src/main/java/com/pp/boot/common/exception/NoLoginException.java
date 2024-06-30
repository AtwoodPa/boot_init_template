package com.pp.boot.common.exception;

/**
 * 自定义异常 - 未登录
 * 用于表示用户未登录的异常情况
 *
 * @author supan
 * @date 2024/06/30
 */
public class NoLoginException extends Exception {
    private static final long serialVersionUID = 1L;

    private final int errorCode;

    public NoLoginException() {
        super("User not logged in");
        // 默认的错误码，可根据需要调整
        this.errorCode = 401;
    }

    public NoLoginException(String message) {
        super(message);
        this.errorCode = 401;
    }

    public NoLoginException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public NoLoginException(String message, Throwable cause, int errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public NoLoginException(Throwable cause, int errorCode) {
        super(cause);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
