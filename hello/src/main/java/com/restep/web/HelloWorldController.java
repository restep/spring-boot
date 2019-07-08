package com.restep.web;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author restep
 * @date 2019/4/9
 * @RestController 的意思是 Controller 里面的方法都以JSON格式输出 不需要有其他额外的配置
 */
@RestController
public class HelloWorldController {
    @RequestMapping("/hello")
    public String hello(String name) {
        if (StringUtils.isEmpty(name)) {
            name = "";
        }

        return "Hello World " + name;
    }
}
