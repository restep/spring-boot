package com.restep.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author restep
 * @date 2019/9/14
 */
@RestController
public class SessionController {
    @RequestMapping(value = "/setSession")
    public Map<String, Object> setSession(HttpServletRequest request) {
        request.getSession().setAttribute("message", request.getRequestURL());

        Map<String, Object> map = new HashMap<>(1);
        map.put("requestUrl", request.getRequestURL());
        return map;
    }

    @RequestMapping(value = "/getSession")
    public Object getSession(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>(2);
        map.put("sessionId", request.getSession().getId());
        map.put("message", request.getSession().getAttribute("message"));
        return map;
    }
}
