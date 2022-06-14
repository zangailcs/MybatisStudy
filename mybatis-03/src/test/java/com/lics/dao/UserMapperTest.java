package com.lics.dao;

import com.lics.pojo.User;
import com.lics.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class UserMapperTest {
    @Test
    public void test01() {
        // 获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 执行SQL
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();

        System.out.println(userList);

        sqlSession.close();

    }



}
