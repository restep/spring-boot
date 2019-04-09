package com.restep.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author restep
 * @date 2019/4/9
 * @RestController 的意思是 Controller 里面的方法都以 JSON 格式输出 不需要有其他额外的配置
 */
@RestController
public class HelloWorldController {
    @RequestMapping("/hello")
    public String index(String name) {
        return "Hello World " + name;
    }
}
