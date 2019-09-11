package com.shengchanshixi.gongxiangyigui.entity;

import javax.persistence.*;

@Entity
@Table(name = "sort_tag", schema = "gongxiangyigui", catalog = "")
public class Tag {
    private String tag;
    private String sort;
    private int cnt;

    @Id
    @Column(name = "tag")
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
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
    @Column(name = "cnt")
    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tag tag1 = (Tag) o;

        if (cnt != tag1.cnt) return false;
        if (tag != null ? !tag.equals(tag1.tag) : tag1.tag != null) return false;
        if (sort != null ? !sort.equals(tag1.sort) : tag1.sort != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tag != null ? tag.hashCode() : 0;
        result = 31 * result + (sort != null ? sort.hashCode() : 0);
        result = 31 * result + cnt;
        return result;
    }
}
