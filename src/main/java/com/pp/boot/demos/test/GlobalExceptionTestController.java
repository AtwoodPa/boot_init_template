package com.pp.boot.demos.test;

import com.pp.boot.common.base.Result;
import com.pp.boot.common.exception.CustomException;
import com.pp.boot.common.exception.NoLoginException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 全局异常处理测试接口
 *
 * @author supanpan
 * @date 2024/06/30
 */
@RequestMapping("/exception")
@RestController
public class GlobalExceptionTestController {

    /**
     * 测试自定义异常
     * @param error
     * @return
     */
    @GetMapping("/testCustom")
    public Result<String> test(@RequestParam(value = "error", defaultValue = "false") boolean error) {
        if (error) {
            throw new CustomException("This is a custom exception", 1001);
        }
        return Result.ok("No Error");
    }

    /**
     * 测试登录异常
     * @param loggedIn
     * @return
     * @throws NoLoginException
     */
    @GetMapping("/loginxxx")
    public Result<String> login(@RequestParam(value = "loggedIn", defaultValue = "false") boolean loggedIn) throws NoLoginException {
        if (!loggedIn) {
            throw new NoLoginException();
        }
        return Result.ok("Login successful: 用户登录成功");
    }
}
