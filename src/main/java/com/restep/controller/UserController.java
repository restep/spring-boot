package com.restep.controller;

import com.restep.dataobject.UserDO;
import com.restep.mapper.UserMapper;
import com.restep.page.Page;
import com.restep.req.UserReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author restep
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    private static String REDIS_CACHE_KEY = "user.list";

    @GetMapping("/list")
    public List<UserDO> list() {
        List<UserDO> userDOList = null;

        if (redisTemplate.hasKey(REDIS_CACHE_KEY)) {
            ValueOperations<String, List<UserDO>> valueOperations = redisTemplate.opsForValue();
            userDOList = valueOperations.get(REDIS_CACHE_KEY);
            return userDOList;
        }

        userDOList = userMapper.getAll();

        ValueOperations<String, List<UserDO>> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(REDIS_CACHE_KEY, userDOList);
        return userDOList;
    }

    @GetMapping("/listPage")
    public Page<UserDO> listPage(UserReq userReq) {
        List<UserDO> users = userMapper.getList(userReq);
        long count = userMapper.getCount(userReq);
        Page page = new Page(userReq, count, users);
        return page;
    }

    @GetMapping("/detail/{id}")
    public UserDO detail(@PathVariable Integer id) {
        return userMapper.getOne(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody UserDO user) {
        userMapper.insert(user);

        redisTemplate.delete(REDIS_CACHE_KEY);
    }

    @PostMapping(value = "update")
    public void update(@RequestBody UserDO user) {
        userMapper.update(user);

        redisTemplate.delete(REDIS_CACHE_KEY);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        userMapper.delete(id);

        redisTemplate.delete(REDIS_CACHE_KEY);
    }
}