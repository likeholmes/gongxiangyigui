package com.shengchanshixi.gongxiangyigui.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "log_list", schema = "gongxiangyigui", catalog = "")
public class Log {
    private int id;
    private String adminid;
    private String ip;
    private String module;
    private String operate;
    private String detail;
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
    @Column(name = "adminid")
    public String getAdminid() {
        return adminid;
    }

    public void setAdminid(String adminid) {
        this.adminid = adminid;
    }

    @Basic
    @Column(name = "ip")
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Basic
    @Column(name = "module")
    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    @Basic
    @Column(name = "operate")
    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
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

        Log log = (Log) o;

        if (id != log.id) return false;
        if (adminid != null ? !adminid.equals(log.adminid) : log.adminid != null) return false;
        if (ip != null ? !ip.equals(log.ip) : log.ip != null) return false;
        if (module != null ? !module.equals(log.module) : log.module != null) return false;
        if (operate != null ? !operate.equals(log.operate) : log.operate != null) return false;
        if (detail != null ? !detail.equals(log.detail) : log.detail != null) return false;
        if (time != null ? !time.equals(log.time) : log.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (adminid != null ? adminid.hashCode() : 0);
        result = 31 * result + (ip != null ? ip.hashCode() : 0);
        result = 31 * result + (module != null ? module.hashCode() : 0);
        result = 31 * result + (operate != null ? operate.hashCode() : 0);
        result = 31 * result + (detail != null ? detail.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}
