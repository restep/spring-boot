package com.restep.mapper;

import com.restep.enums.UserSexEnum;
import com.restep.model.User;
import com.restep.param.UserParam;
import com.restep.result.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author restep
 * @date 2019/4/11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert() throws Exception {
        userMapper.insert(new User("aa", "a123456", UserSexEnum.MAN));
        userMapper.insert(new User("bb", "b123456", UserSexEnum.WOMAN));
        userMapper.insert(new User("cc", "b123456", UserSexEnum.WOMAN));
    }

    @Test
    public void testQuery() throws Exception {
        Map param = new HashMap();
        param.put("username", "aa");
        param.put("user_sex", "MAN");
        List<User> users = userMapper.getListByNameAndSex(param);

        System.out.println("testQuery:" + users.toString());
    }

    @Test
    public void testUpdate() throws Exception {
        User user = userMapper.getOne(28L);
        System.out.println("user :" + user.toString());
        user.setNickName("it");
        user.setUserName("youknow");

        userMapper.updateUser(user);
    }

    @Test
    public void testPage() {
        UserParam userParam = new UserParam();
        userParam.setUserSex("WOMAN");
        userParam.setCurrentPage(0);
        List<User> users = userMapper.getList(userParam);

        long count = userMapper.getCount(userParam);
        Page page = new Page(userParam, count, users);
        System.out.println("page === " + page);
    }
}
