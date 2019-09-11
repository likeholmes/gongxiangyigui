package com.shengchanshixi.gongxiangyigui.entity;

import javax.persistence.*;

@Entity
@Table(name = "com_pic", schema = "gongxiangyigui", catalog = "")
public class ComPic {
    private int id;
    private String name;
    private String url;
    private int comid;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "comid")
    public int getComid() {
        return comid;
    }

    public void setComid(int comid) {
        this.comid = comid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComPic comPic = (ComPic) o;

        if (id != comPic.id) return false;
        if (comid != comPic.comid) return false;
        if (name != null ? !name.equals(comPic.name) : comPic.name != null) return false;
        if (url != null ? !url.equals(comPic.url) : comPic.url != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + comid;
        return result;
    }
}
