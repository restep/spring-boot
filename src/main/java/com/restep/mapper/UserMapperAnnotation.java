package com.restep.mapper;

import com.restep.dataobject.UserDO;
import com.restep.enums.UserSexEnum;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author restep
 * @date 2019/9/1
 */
public interface UserMapperAnnotation {
    @Select("SELECT * FROM users")
    @Results({
            @Result(property = "userSex", column = "user_sex", javaType = UserSexEnum.class),
            @Result(property = "nickName", column = "nick_name")
    })
    List<UserDO> getAll();

    @Select("SELECT * FROM users WHERE user_sex = #{user_sex}")
    List<UserDO> getListByUserSex(@Param("user_sex") String userSex);

    @Select("SELECT * FROM users WHERE username=#{username} AND user_sex = #{user_sex}")
    List<UserDO> getListByNameAndSex(Map<String, Object> map);

    @Select("SELECT * FROM users WHERE id = #{id}")
    @Results({
            @Result(property = "userSex", column = "user_sex", javaType = UserSexEnum.class),
            @Result(property = "nickName", column = "nick_name")
    })
    UserDO getOne(Long id);

    @Insert("INSERT INTO users(userName,passWord,user_sex) VALUES(#{userName}, #{passWord}, #{userSex})")
    void insert(UserDO user);

    @Update("UPDATE users SET userName=#{userName},nick_name=#{nickName} WHERE id =#{id}")
    void update(UserDO user);

    @Update({"<script> ",
            "update users ",
            "<set>",
            " <if test='userName != null'>userName=#{userName},</if>",
            " <if test='nickName != null'>nick_name=#{nickName},</if>",
            " </set> ",
            "where id=#{id} ",
            "</script>"})
    void updateUser(UserDO user);

    @Delete("DELETE FROM users WHERE id =#{id}")
    void delete(Long id);
}
