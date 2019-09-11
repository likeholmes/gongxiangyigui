package com.shengchanshixi.gongxiangyigui.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user_msg", schema = "gongxiangyigui", catalog = "")
public class Msg {
    private int id;
    private int feedbackid;
    private Timestamp time;
    private String userid;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "feedbackid")
    public int getFeedbackid() {
        return feedbackid;
    }

    public void setFeedbackid(int feedbackid) {
        this.feedbackid = feedbackid;
    }

    @Basic
    @Column(name = "time")
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Basic
    @Column(name = "userid")
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Msg msg = (Msg) o;

        if (id != msg.id) return false;
        if (feedbackid != msg.feedbackid) return false;
        if (time != null ? !time.equals(msg.time) : msg.time != null) return false;
        if (userid != null ? !userid.equals(msg.userid) : msg.userid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + feedbackid;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        return result;
    }
}
