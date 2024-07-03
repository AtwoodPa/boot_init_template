package com.pp.boot.model.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * @author supanpan
 * @date 2024/07/03
 */
@Data
public class UserDto {

    @NotBlank(message = "用户名不能为空")
    @Size(min = 3, max = 20, message = "用户名长度在3-20之间")
    private String username;

    @NotBlank(message = "邮箱不能为空")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "密码不能为空")
    @Size(min = 6, message = "密码长度不能小于6")
    private String password;

}
