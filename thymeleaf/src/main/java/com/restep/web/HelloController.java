package com.restep.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author restep
 * @date 2019/4/10
 */
@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("message", "http://www.ityouknow.com");

        return "hello";
    }
}
