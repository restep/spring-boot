package com.restep.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController 的意思是 Controller 里面的方法都以 JSON 格式输出 不需要有其他额外的配置
 * @author restep
 * @date 2019/9/1
 */
@RestController
public class HelloController {
    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        if (StringUtils.isEmpty(name)) {
            return "hello";
        }

        return "hello " + name;
    }
}
