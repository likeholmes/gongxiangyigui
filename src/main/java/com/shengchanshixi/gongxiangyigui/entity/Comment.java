package com.shengchanshixi.gongxiangyigui.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "cloth_comment", schema = "gongxiangyigui", catalog = "")
public class Comment {
    private int id;
    private int clothid;
    private String orderid;
    private String userid;
    private String title;
    private String content;
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
    @Column(name = "clothid")
    public int getClothid() {
        return clothid;
    }

    public void setClothid(int clothid) {
        this.clothid = clothid;
    }

    @Basic
    @Column(name = "orderid")
    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
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
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

        Comment comment = (Comment) o;

        if (id != comment.id) return false;
        if (clothid != comment.clothid) return false;
        if (orderid != null ? !orderid.equals(comment.orderid) : comment.orderid != null) return false;
        if (userid != null ? !userid.equals(comment.userid) : comment.userid != null) return false;
        if (title != null ? !title.equals(comment.title) : comment.title != null) return false;
        if (content != null ? !content.equals(comment.content) : comment.content != null) return false;
        if (time != null ? !time.equals(comment.time) : comment.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + clothid;
        result = 31 * result + (orderid != null ? orderid.hashCode() : 0);
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}
