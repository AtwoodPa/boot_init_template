package com.pp.boot.web.controller.system;

import com.pp.boot.common.base.Constants;
import com.pp.boot.common.base.Result;
import com.pp.boot.common.security.model.LoginBody;
import com.pp.boot.common.security.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 登录验证
 *
 * @author supanpan
 * @date 2024/07/08
 */
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class SysLoginController {
    private final LoginService loginService;


    /**
     * 登录方法
     *
     * @param loginBody 登录信息
     * @return 结果
     */
    @PostMapping("/login")
    public Result login(@RequestBody LoginBody loginBody) {
        Map<String,String> ajax = new HashMap<>();
        // 生成令牌
        String token = loginService.login(loginBody.getUsername(), loginBody.getPassword(), loginBody.getCode(),
                loginBody.getUuid());
        ajax.put(Constants.TOKEN, token);
        return Result.ok(ajax);
    }

}
