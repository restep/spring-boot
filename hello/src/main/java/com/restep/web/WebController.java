package com.restep.web;

import com.restep.model.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author restep
 * @date 2019/4/9
 * @RestController 注解相当于 @ResponseBody ＋ @Controller 合在一起的作用
 * 如果 Web 层的类上使用了 @RestController 注解
 * 就代表这个类中所有的方法都会以 JSON 的形式返回结果，也相当于 JSON 的一种快捷使用方式
 */
@RestController
public class WebController {
    @RequestMapping(name = "/getUser", method = RequestMethod.POST)
    public User getUser() {
        User user = new User();
        user.setName("小明");
        user.setAge(12);
        user.setPass("123456");

        return user;
    }

    @RequestMapping("/getUserList")
    public List<User> getUserList() {
        List<User> userList = new ArrayList<>();

        User user1 = new User();
        user1.setName("neo");
        user1.setAge(30);
        user1.setPass("neo123");
        userList.add(user1);

        User user2 = new User();
        user2.setName("小明");
        user2.setAge(12);
        user2.setPass("123456");
        userList.add(user2);

        return userList;
    }

    @RequestMapping("/saveUser")
    public void saveUser(@Valid User user, BindingResult result) {
        System.out.println("user:" + user);

        if (result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError error : list) {
                System.out.println(error.getCode() + "-" + error.getDefaultMessage());
            }
        }
    }
}
