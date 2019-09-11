package com.shengchanshixi.gongxiangyigui.entity;

import javax.persistence.*;

@Entity
@Table(name = "ope_mod", schema = "gongxiangyigui", catalog = "")
@IdClass(OperatePK.class)
public class Operate {
    private String operate;
    private String module;
    private String detail;

    @Id
    @Column(name = "operate")
    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

    @Id
    @Column(name = "module")
    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    @Basic
    @Column(name = "detail")
    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Operate operate1 = (Operate) o;

        if (operate != null ? !operate.equals(operate1.operate) : operate1.operate != null) return false;
        if (module != null ? !module.equals(operate1.module) : operate1.module != null) return false;
        if (detail != null ? !detail.equals(operate1.detail) : operate1.detail != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = operate != null ? operate.hashCode() : 0;
        result = 31 * result + (module != null ? module.hashCode() : 0);
        result = 31 * result + (detail != null ? detail.hashCode() : 0);
        return result;
    }
}
