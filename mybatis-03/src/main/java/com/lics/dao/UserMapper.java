package com.lics.dao;

import com.lics.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUserList();

    // 分页
    List<User> getUserByLimit(Map<String, Integer> map);

    @Select("select * from user")
    List<User> getUserListByAnnotations();

    @Update("update user " +
            "set id = #{id}, name = #{name}, pwd = #{password} " +
            "where id = #{id}")
    int updateUserByAnnotations(User user);

    @Insert("insert into user (id, name, pwd) " +
            "values " +
            "(#{id}, #{name}, #{password})")
    int addUserByAnnotations(User user);

    @Delete("delete from user " +
            "where id = #{id}")
    int deleteUserByIdByAnnotations(@Param("id") int id);
}
