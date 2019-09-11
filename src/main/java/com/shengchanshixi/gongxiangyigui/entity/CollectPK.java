package com.shengchanshixi.gongxiangyigui.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class CollectPK implements Serializable {
    private String userid;
    private int clothid;

    @Column(name = "userid")
    @Id
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Column(name = "clothid")
    @Id
    public int getClothid() {
        return clothid;
    }

    public void setClothid(int clothid) {
        this.clothid = clothid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CollectPK collectPK = (CollectPK) o;

        if (clothid != collectPK.clothid) return false;
        if (userid != null ? !userid.equals(collectPK.userid) : collectPK.userid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userid != null ? userid.hashCode() : 0;
        result = 31 * result + clothid;
        return result;
    }
}
