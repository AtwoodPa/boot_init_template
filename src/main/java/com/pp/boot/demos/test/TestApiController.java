package com.pp.boot.demos.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 测试接口 TestApiController
 * @author supanpan
 * @date 2024/05/15
 */
@Controller
public class TestApiController {
    @RequestMapping(value = "/test_api", method = {RequestMethod.GET})
    @ResponseBody
    public String test() {
        System.out.println("test");
        return "test_api";
    }
}
