package com.shengchanshixi.gongxiangyigui.entity;

import javax.persistence.*;

@Entity
@Table(name = "cloth_pic", schema = "gongxiangyigui", catalog = "")
public class ClothPic {
    private int id;
    private int clothId;
    private String detail;
    private String url;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "cloth_id")
    public int getClothId() {
        return clothId;
    }

    public void setClothId(int clothId) {
        this.clothId = clothId;
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
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClothPic clothPic = (ClothPic) o;

        if (id != clothPic.id) return false;
        if (clothId != clothPic.clothId) return false;
        if (detail != null ? !detail.equals(clothPic.detail) : clothPic.detail != null) return false;
        if (url != null ? !url.equals(clothPic.url) : clothPic.url != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + clothId;
        result = 31 * result + (detail != null ? detail.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }
}
