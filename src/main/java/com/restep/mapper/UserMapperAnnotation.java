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
    @Select("select id,username,password,user_sex,nick_name from user")
    @Results({
            @Result(property = "userSex", column = "user_sex", javaType = UserSexEnum.class),
            @Result(property = "nickname", column = "nick_name")
    })
    List<UserDO> getAll();

    @Select("select id,username,password,user_sex,nick_name from user where user_sex = #{user_sex}")
    List<UserDO> getListByUserSex(@Param("user_sex") String userSex);

    @Select("select id,username,password,user_sex,nick_name from user where username=#{username} and user_sex = #{user_sex}")
    List<UserDO> getListByNameAndSex(Map<String, Object> map);

    @Select("select id,username,password,user_sex,nick_name from user where id = #{id}")
    @Results({
            @Result(property = "userSex", column = "user_sex", javaType = UserSexEnum.class),
            @Result(property = "nickname", column = "nick_name")
    })
    UserDO getOne(Integer id);

    @Insert("insert into user(username,password,user_sex,nick_name) values (#{username}, #{password}, #{userSex},#{nickname})")
    void insert(UserDO user);

    @Update({"<script> ",
            "update user ",
            "<set>",
            " <if test='username != null'>username=#{username},</if>",
            " <if test='password != null'>password=#{password},</if>",
            " <if test='nickname != null'>nick_name=#{nickname},</if>",
            " </set> ",
            "where id=#{id} ",
            "</script>"})
    void updateUser(UserDO user);

    @Delete("delete from user where id =#{id}")
    void delete(Integer id);
}
