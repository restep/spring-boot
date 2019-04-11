package com.restep.mapper;

import com.restep.enums.UserSexEnum;
import com.restep.model.User;
import com.restep.param.UserParam;
import com.restep.result.Page;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author restep
 * @date 2019/4/10
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Resource
    private UserMapper userMapper;

    @Test
    public void testUser() {
        //增加
        userMapper.insert(new User("aa", "a123456", UserSexEnum.MAN));
        //删除
        userMapper.delete(2l);
        User user = userMapper.getOne(1l);
        user.setNickName("smile");
        //修改
        userMapper.update(user);
        //查询
        List<User> users = userMapper.getAll();
        System.out.println(users);
    }

    @Test
    public void testInsert() {
        userMapper.insert(new User("aa", "a123456", UserSexEnum.MAN));
        userMapper.insert(new User("bb", "b123456", UserSexEnum.WOMAN));
        userMapper.insert(new User("cc", "b123456", UserSexEnum.WOMAN));

        System.out.println(userMapper.getAll().size());
    }

    @Test
    public void testQuery() {
        List<User> users = userMapper.getAll();
        if (users == null || users.size() == 0) {
            System.out.println("is null");
        } else {
            System.out.println("users list is :" + users.toString());
        }
    }


    @Test
    public void testUpdate() {
        long id = 1l;
        User user = userMapper.getOne(id);

        if (user != null) {
            System.out.println(user.toString());
            user.setNickName("neo");
            userMapper.update(user);
            Assert.assertTrue(("neo".equals(userMapper.getOne(id).getNickName())));
        } else {
            System.out.println("not find user id=" + id);
        }
    }

    @Test
    public void testDelete() {
        int count = userMapper.delete(29l);

        if (count > 0) {
            System.out.println("delete is sucess");
        } else {
            System.out.println("delete if failed");
        }
    }

    @Test
    public void testPage() {
        UserParam userParam = new UserParam();
        userParam.setCurrentPage(0);
        List<User> users = userMapper.getList(userParam);

        long count = userMapper.getCount(userParam);
        Page page = new Page(userParam, count, users);

        System.out.println("page == " + page);
    }
}
