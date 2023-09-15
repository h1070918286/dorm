package com.dorm.mapper;

import com.dorm.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user WHERE name = #{name} and password = #{password}")
    User login(String name, String password);
//
//    @Insert("INSERT INTO users (username, password) VALUES (#{username}, #{password})")
//    void save(User user);
    @Update("update user set password = #{password} where id = #{id}")
    void change(Integer id, String password);

    @Select("SELECT * FROM user WHERE id = #{id}")
    User getById(Integer id);

    @Update("update user set sex = #{user.sex},age = #{user.age},class_room = #{user.class_room} where id = #{id}")
    void changeInfo(Integer id, User user);

    @Select("SELECT * FROM user WHERE role = 0")
    List<User> getAllStu();

    @Select("SELECT * FROM user WHERE role = 0 and class_room = #{class_room}")
    List<User> getStuByClass(String class_room);

    @Select("SELECT * FROM user WHERE role = 0 and dorm_room = #{dorm_room}")
    List<User> getStuByDorm(String dorm_room);

    @Select("SELECT * FROM user WHERE role = 0 and class_room = #{class_room} and dorm_room = #{dorm_room}")
    List<User> getStu(String class_room,String dorm_room);

    @Update("update user set sex = #{user.sex},age = #{user.age},class_room = #{user.class_room},name = #{user.name},password = #{user.password},dorm_room = #{user.dorm_room} where id = #{user.id}")
    void updateInfo(@Param("user") User user);
    // 其他数据库操作方法
}