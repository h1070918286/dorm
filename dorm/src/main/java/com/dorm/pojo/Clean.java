package com.dorm.pojo;

public class Clean {
    private Integer id;
    private String dorm_room;
    private String record_time;
    private String score;
    private String reason;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDorm_room() {
        return dorm_room;
    }

    public void setDorm_room(String dorm_room) {
        this.dorm_room = dorm_room;
    }

    public String getRecord_time() {
        return record_time;
    }

    public void setRecord_time(String record_time) {
        this.record_time = record_time;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Clean() {
    }

    public Clean(Integer id, String dorm_room, String record_time, String score, String reason) {
        this.id = id;
        this.dorm_room = dorm_room;
        this.record_time = record_time;
        this.score = score;
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Clean{" +
                "id=" + id +
                ", dorm_room='" + dorm_room + '\'' +
                ", record_time='" + record_time + '\'' +
                ", score='" + score + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }

}
