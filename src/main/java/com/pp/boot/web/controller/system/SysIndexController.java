package com.pp.boot.web.controller.system;

import com.pp.boot.common.utils.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 首页
 *
 * @author supanpan
 * @date 2024/07/08
 */
@RestController
public class SysIndexController {
    /**
     * 访问首页，提示语
     */
    @RequestMapping("/")
    public String index() {
        return StringUtils.format("欢迎使用后台管理框架，请通过前端地址访问。");
    }
}
