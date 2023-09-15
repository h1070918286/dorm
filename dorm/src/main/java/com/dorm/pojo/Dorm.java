package com.dorm.pojo;

public class Dorm {
    private Integer id;
    private Integer user_id;
    private String dorm_old;
    private String dorm_new;
    private String reason;
    private String permit;
    private String name;

    public Dorm() {
    }

    public Dorm(Integer id, Integer user_id, String dorm_old, String dorm_new, String reason, String permit, String name) {
        this.id = id;
        this.user_id = user_id;
        this.dorm_old = dorm_old;
        this.dorm_new = dorm_new;
        this.reason = reason;
        this.permit = permit;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getDorm_old() {
        return dorm_old;
    }

    public void setDorm_old(String dorm_old) {
        this.dorm_old = dorm_old;
    }

    public String getDorm_new() {
        return dorm_new;
    }

    public void setDorm_new(String dorm_new) {
        this.dorm_new = dorm_new;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getPermit() {
        return permit;
    }

    public void setPermit(String permit) {
        this.permit = permit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dorm{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", dorm_old='" + dorm_old + '\'' +
                ", dorm_new='" + dorm_new + '\'' +
                ", reason='" + reason + '\'' +
                ", permit='" + permit + '\'' +
                '}';
    }
}
