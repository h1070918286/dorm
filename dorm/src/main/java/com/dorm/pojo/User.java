package com.dorm.pojo;


public class User{
    private Integer id;
    private String name;
    private String password;
    private Integer role;
    private String sex;
    private Integer age;
    private String class_room;
    private String dorm_room;

    public User(Integer id, String name, String password, Integer role, String sex, Integer age, String class_room, String dorm_room) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.role = role;
        this.sex = sex;
        this.age = age;
        this.class_room = class_room;
        this.dorm_room = dorm_room;
    }



    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getClass_room() {
        return class_room;
    }

    public void setClass_room(String class_room) {
        this.class_room = class_room;
    }

    public String getDorm_room() {
        return dorm_room;
    }

    public void setDorm_room(String dorm_room) {
        this.dorm_room = dorm_room;
    }

    

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", class_room='" + class_room + '\'' +
                ", dorm_room='" + dorm_room + '\'' +
                '}';
    }
}
