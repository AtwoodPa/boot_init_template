package com.pp.boot.demos.test;

import com.pp.boot.model.domain.dto.UserDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * 验证器测试
 * @author supanpan
 * @date 2024/07/03
 */
@RestController
@RequestMapping("/validate")
public class ValidateTestController {

    /**
     * 使用@Valid注解，校验请求题
     * @param userDTO
     * @param result
     * @return
     */
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody UserDto userDTO, BindingResult result) {
        if (result.hasErrors()) {
            //如果有校验错误，返回第一个校验信息
            String defaultMessage = result.getFieldErrors().get(0).getDefaultMessage();
            return ResponseEntity.badRequest().body(defaultMessage);
        }
        // 处理注册逻辑
        return ResponseEntity.ok("User registered successfully");
    }

    /**
     * 对于路径变量，可以使用@PathVariable结合@Valid和@Pattern等注解进行校验
     * @param username
     * @return
     */
    @GetMapping("/user/{username}")
    public ResponseEntity<String> getUser(
            @Valid @PathVariable("username")
            @Pattern(regexp = "^[a-zA-Z0-9]{3,20}$", message = "用户名长度必须在3～20字符之间") String username) {
        // 处理获取用户逻辑
        return ResponseEntity.ok("User found: " + username);
    }

    /**
     * 对于请求参数，可以使用@RequestParam结合@Valid和其他验证注解进行校验
     * @param query
     * @return
     */
    @GetMapping("/search")
    public ResponseEntity<String> searchUser(
            @Valid @RequestParam("query") @NotBlank(message = "Query must not be blank") String query) {
        // 处理搜索逻辑
        return ResponseEntity.ok("Search results for: " + query);
    }
}
