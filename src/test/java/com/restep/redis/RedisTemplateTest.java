package com.restep.redis;

import com.restep.dataobject.UserDO;
import com.restep.enums.UserSexEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author restep
 * @date 2019/9/8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RedisTemplateTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void stringTest() {
        redisTemplate.opsForValue().set("aa", "aaa");
        redisTemplate.opsForValue().set("aa", "bbb");
        log.info("a:{}", redisTemplate.opsForValue().get("aa"));
    }

    @Test
    public void objTest() {
        UserDO userDO = new UserDO();
        userDO.setUsername("shifeng");
        userDO.setPassword("shifeng10");
        userDO.setUserSex(UserSexEnum.MAN);
        userDO.setNickname("虫");

        ValueOperations<String, UserDO> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("com.restep", userDO);

        UserDO existUserDO = valueOperations.get("com.restep");
        log.info("existUserDO: {}", existUserDO);
    }

    @Test
    public void expireTest() throws InterruptedException {
        UserDO userDO = new UserDO();
        userDO.setUsername("shifeng");
        userDO.setPassword("shifeng10");
        userDO.setUserSex(UserSexEnum.MAN);
        userDO.setNickname("虫");

        ValueOperations<String, UserDO> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("com.restep.expire", userDO, 2, TimeUnit.SECONDS);

        TimeUnit.SECONDS.sleep(3L);

        boolean exists = redisTemplate.hasKey("com.restep.expire");
        log.info("exists: {}", exists);
    }

    @Test
    public void deleteTest() {
        redisTemplate.opsForValue().set("deleteKey", "abcd");

        boolean exists = redisTemplate.hasKey("deleteKey");
        log.info("exists: {}", exists);

        redisTemplate.delete("deleteKey");

        exists = redisTemplate.hasKey("deleteKey");
        log.info("exists: {}", exists);
    }

    @Test
    public void hashTest() {
        HashOperations<String, Object, Object> hashOperations = redisTemplate.opsForHash();
        hashOperations.put("hashTest", "you", "you");

        String value = hashOperations.get("hashTest", "you").toString();
        log.info("value: {}", value);
    }

    @Test
    public void testList() {
        String key = "list";
        redisTemplate.delete(key);

        ListOperations<String, String> list = redisTemplate.opsForList();
        list.leftPush(key, "a");
        list.leftPush(key, "b");
        list.leftPush(key, "c");

        String value = list.leftPop(key);
        log.info("value: {}", value);

        List<String> valueList = list.range(key, 0, 3);
        for (String v : valueList) {
            log.info("range value: {}", v);
        }
    }

    @Test
    public void testSet() {
        String key = "set";
        redisTemplate.delete(key);

        SetOperations<String, String> set = redisTemplate.opsForSet();
        set.add(key, "aaa");
        set.add(key, "bbb");
        set.add(key, "aaa");
        set.add(key, "ccc");

        Set<String> values = set.members(key);
        for (String v : values) {
            log.info("set value: {}", v);
        }
    }

    @Test
    public void testSetMore() {
        SetOperations<String, String> set = redisTemplate.opsForSet();
        String key1 = "setMore1";
        String key2 = "setMore2";
        set.add(key1, "it");
        set.add(key1, "you");
        set.add(key1, "you");
        set.add(key1, "know");
        set.add(key2, "xx");
        set.add(key2, "know");
        Set<String> diffs = set.difference(key1, key2);
        for (String v : diffs) {
            System.out.println("diffs set value :" + v);
        }

        String key3 = "setMore3";
        String key4 = "setMore4";
        set.add(key3, "it");
        set.add(key3, "you");
        set.add(key3, "xx");
        set.add(key4, "aa");
        set.add(key4, "bb");
        set.add(key4, "know");

        Set<String> unions = set.union(key3, key4);
        for (String v : unions) {
            System.out.println("unions value :" + v);
        }
    }

    @Test
    public void testZset() {
        String key = "zset";
        redisTemplate.delete(key);

        ZSetOperations<String, String> zset = redisTemplate.opsForZSet();
        zset.add(key, "d", 1);
        zset.add(key, "a", 6);
        zset.add(key, "b", 4);
        zset.add(key, "c", 3);

        Set<String> zsets = zset.range(key, 0, 3);
        for (String v : zsets) {
            System.out.println("zset value :" + v);
        }

        Set<String> zsetB = zset.rangeByScore(key, 0, 4);
        for (String v : zsetB) {
            System.out.println("zsetB value :" + v);
        }
    }
}
