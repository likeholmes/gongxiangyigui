package com.shengchanshixi.gongxiangyigui.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class OperatePK implements Serializable {
    private String operate;
    private String module;

    @Column(name = "operate")
    @Id
    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

    @Column(name = "module")
    @Id
    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OperatePK operatePK = (OperatePK) o;

        if (operate != null ? !operate.equals(operatePK.operate) : operatePK.operate != null) return false;
        if (module != null ? !module.equals(operatePK.module) : operatePK.module != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = operate != null ? operate.hashCode() : 0;
        result = 31 * result + (module != null ? module.hashCode() : 0);
        return result;
    }
}
