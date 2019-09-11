package com.shengchanshixi.gongxiangyigui.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "feedback_list", schema = "gongxiangyigui", catalog = "")
public class Feedback {
    private int id;
    private String userid;
    private String detail;
    private String sort;
    private Timestamp time;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "userid")
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "detail")
    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Basic
    @Column(name = "sort")
    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    @Basic
    @Column(name = "time")
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Feedback feedback = (Feedback) o;

        if (id != feedback.id) return false;
        if (userid != null ? !userid.equals(feedback.userid) : feedback.userid != null) return false;
        if (detail != null ? !detail.equals(feedback.detail) : feedback.detail != null) return false;
        if (sort != null ? !sort.equals(feedback.sort) : feedback.sort != null) return false;
        if (time != null ? !time.equals(feedback.time) : feedback.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        result = 31 * result + (detail != null ? detail.hashCode() : 0);
        result = 31 * result + (sort != null ? sort.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}
