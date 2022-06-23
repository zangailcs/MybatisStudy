package com.lics.dao;

import com.lics.pojo.User;
import com.lics.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class UserMapperTest {
    static Logger logger = Logger.getLogger(UserMapperTest.class);

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

    @Test
    public void test02() {
        logger.info("info:进入了test02方法");
        logger.debug("debug:进入了test02方法");
        logger.error("error:进入了test02方法");

    }

    @Test
    public void testGetUserByLimit() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        HashMap<String, Integer> map = new HashMap<>();

        map.put("startIndex", 2);
        map.put("pageSize", 2);

        List<User> userByLimit = mapper.getUserByLimit(map);

        System.out.println(userByLimit);

        sqlSession.close();
    }

    @Test
    public void testyAnnotations() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> userListByAnnotations = mapper.getUserListByAnnotations();
        System.out.println(userListByAnnotations);

        User user = new User(10, "1010", "1111111");
        mapper.addUserByAnnotations(user);

        mapper.updateUserByAnnotations(new User(3, "333update", "3333"));

        mapper.deleteUserByIdByAnnotations(9);

        sqlSession.close();
    }

}
