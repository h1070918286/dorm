package com.dorm.pojo;

public class Leave {
    private Integer id;
    private Integer user_id;
    private String reason;
    private String leave_time;
    private String permit;
    private String name;

    public Leave() {
    }

    public Leave(Integer id, Integer user_id, String reason, String leave_time, String permit, String name) {
        this.id = id;
        this.user_id = user_id;
        this.reason = reason;
        this.leave_time = leave_time;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getLeave_time() {
        return leave_time;
    }

    public void setLeave_time(String leave_time) {
        this.leave_time = leave_time;
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
        return "Leave{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", reason='" + reason + '\'' +
                ", leave_time='" + leave_time + '\'' +
                ", permit='" + permit + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
