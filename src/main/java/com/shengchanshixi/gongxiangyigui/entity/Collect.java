package com.shengchanshixi.gongxiangyigui.entity;

import javax.persistence.*;

@Entity
@Table(name = "cloth_collect", schema = "gongxiangyigui", catalog = "")
@IdClass(CollectPK.class)
public class Collect {
    private String userid;
    private int clothid;
    private String shelfsta;
    private String clothsta;
    private int clothcub;
    private double value;

    @Id
    @Column(name = "userid")
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Id
    @Column(name = "clothid")
    public int getClothid() {
        return clothid;
    }

    public void setClothid(int clothid) {
        this.clothid = clothid;
    }

    @Basic
    @Column(name = "shelfsta")
    public String getShelfsta() {
        return shelfsta;
    }

    public void setShelfsta(String shelfsta) {
        this.shelfsta = shelfsta;
    }

    @Basic
    @Column(name = "clothsta")
    public String getClothsta() {
        return clothsta;
    }

    public void setClothsta(String clothsta) {
        this.clothsta = clothsta;
    }

    @Basic
    @Column(name = "clothcub")
    public int getClothcub() {
        return clothcub;
    }

    public void setClothcub(int clothcub) {
        this.clothcub = clothcub;
    }

    @Basic
    @Column(name = "value")
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Collect collect = (Collect) o;

        if (clothid != collect.clothid) return false;
        if (clothcub != collect.clothcub) return false;
        if (Double.compare(collect.value, value) != 0) return false;
        if (userid != null ? !userid.equals(collect.userid) : collect.userid != null) return false;
        if (shelfsta != null ? !shelfsta.equals(collect.shelfsta) : collect.shelfsta != null) return false;
        if (clothsta != null ? !clothsta.equals(collect.clothsta) : collect.clothsta != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = userid != null ? userid.hashCode() : 0;
        result = 31 * result + clothid;
        result = 31 * result + (shelfsta != null ? shelfsta.hashCode() : 0);
        result = 31 * result + (clothsta != null ? clothsta.hashCode() : 0);
        result = 31 * result + clothcub;
        temp = Double.doubleToLongBits(value);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
