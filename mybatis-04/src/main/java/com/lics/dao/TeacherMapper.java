package com.lics.dao;

import com.lics.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {
    @Select("select * from teacher where id = #{tid}")
    Teacher getTeacherById(@Param("tid") int id);

    List<Teacher> getTeachers();

    // 获取指定老师下的所有学生及老师的信息
    Teacher getTeacher(@Param("tid") int id);

    Teacher getTeacher2(@Param("tid") int id);

}
