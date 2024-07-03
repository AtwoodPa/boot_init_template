package com.pp.boot.model.domain.vo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 管理后台 - 账号密码登录 Request VO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthLoginReqVO {


    @NotEmpty(message = "登录账号不能为空")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "账号格式为数字以及字母")
    @Size(min = 6, max = 128, message = "账号长度为6-128位")
    private String username;

    @NotEmpty(message = "密码不能为空")
    @Size(min = 6, max = 128, message = "密码长度为6-128位")
    private String password;

}