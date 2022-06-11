package com.lics.dao;

import com.lics.pojo.User;
import com.lics.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

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

    @Test
    public void test02() {
        // 获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 执行SQL
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);
        sqlSession.close();
    }

    // 增删改需要提交事务
    @Test
    public void test03() {
        // 获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 执行SQL
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(4, "ZhaoLiu", "zxczxc");
        int result = mapper.addUser(user);

        if (result > 0) {
            System.out.println("插入成功");
        }

        // 提交事务
        sqlSession.commit();

        List<User> userList = mapper.getUserList();
        System.out.println(userList);

        sqlSession.close();
    }

    @Test
    public void test04() {
        // 获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 执行SQL
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(4, "HeHe", "123123");
        int result = mapper.updateUser(user);

        if (result > 0) {
            System.out.println("修改成功");
        }

        // 提交事务
        sqlSession.commit();

        List<User> userList = mapper.getUserList();
        System.out.println(userList);

        sqlSession.close();
    }

    @Test
    public void test05() {
        // 获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 执行SQL
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int result = mapper.deleteUser(1);

        if (result > 0) {
            System.out.println("删除成功");
        }

        // 提交事务
        sqlSession.commit();

        List<User> userList = mapper.getUserList();
        System.out.println(userList);

        sqlSession.close();
    }

}
