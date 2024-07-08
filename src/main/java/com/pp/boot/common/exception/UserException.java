package com.pp.boot.common.exception;

/**
 * 用户信息异常类
 *
 * @author supanpan
 * @date 2024/07/08
 */
public class UserException extends BaseException{
    private static final long serialVersionUID = 1L;

    public UserException(String code, Object[] args)
    {
        super("user", code, args, null);
    }
}
