package com.pp.boot.demos.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * 测试接口 TestApiController
 * @author supanpan
 * @date 2024/05/15
 */
@Controller
public class TestApiController {

    /**
     * 测试uri- 获取当前请求URI
     * 返回结果：Schema，Host，Port，上下文
     * @param builder
     * @return
     */
    @RequestMapping(value = "/test_uri", method = {RequestMethod.GET})
    @ResponseBody
    public String test(UriComponentsBuilder builder) {
        return builder.toUriString();
    }
}
