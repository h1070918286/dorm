package com.dorm.service;

import com.dorm.mapper.UserMapper;
import com.dorm.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
//
//    public User getUserById(Long id) {
//        return userMapper.findById(id);
//    }
//
//    public void saveUser(User user) {
//        userMapper.save(user);
//    }
    
    // 其他服务方法
    public User login(String name, String password){
        return userMapper.login(name,password);
    }


    public void change(Integer id, String password){
        userMapper.change(id, password);
    }

    public User getById(Integer id){
        return userMapper.getById(id);
    }

    public void changeInfo(Integer id, User user){
        userMapper.changeInfo(id,user);
    }

    public List<User> getAllStu(){
        return userMapper.getAllStu();
    }

    public List<User> getStu(String class_room,String dorm_room){
        return userMapper.getStu(class_room,dorm_room);
    }

    public List<User> getStuByClass(String class_room){
        return userMapper.getStuByClass(class_room);
    }

    public List<User> getStuByDorm(String dorm_room){
        return userMapper.getStuByDorm(dorm_room);
    }

    public void updateInfo(User user){
        userMapper.updateInfo(user);
    }

}