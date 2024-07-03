package com.pp.boot.demos.test;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * 测试接口 TestApiController
 * @author supanpan
 * @date 2024/05/15
 */
@RestController
public class TestApiController {

    /**
     * 测试uri- 获取当前请求URI
     * 返回结果：Schema，Host，Port，上下文
     * @param builder
     * @return
     */
    @RequestMapping(value = "/test_uri", method = {RequestMethod.GET})
    public String test(UriComponentsBuilder builder) {
        return builder.toUriString();
    }
}
