package com.shengchanshixi.gongxiangyigui.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "cloth_info", schema = "gongxiangyigui", catalog = "")
public class Cloth {
    private int id;
    private String name;
    private String brand;
    private double value;
    private String clothsta;
    private String shelfsta;
    private Timestamp time;
    private String size;
    private String part;
    private int clothcub;
    private String scenes;
    private String season;
    private String color;
    private String style;
    private int colcnt;
    private String sort;

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
    @Column(name = "brand")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Basic
    @Column(name = "value")
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
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
    @Column(name = "shelfsta")
    public String getShelfsta() {
        return shelfsta;
    }

    public void setShelfsta(String shelfsta) {
        this.shelfsta = shelfsta;
    }

    @Basic
    @Column(name = "time")
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Basic
    @Column(name = "size")
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Basic
    @Column(name = "part")
    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
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
    @Column(name = "scenes")
    public String getScenes() {
        return scenes;
    }

    public void setScenes(String scenes) {
        this.scenes = scenes;
    }

    @Basic
    @Column(name = "season")
    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    @Basic
    @Column(name = "color")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Basic
    @Column(name = "style")
    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    @Basic
    @Column(name = "colcnt")
    public int getColcnt() {
        return colcnt;
    }

    public void setColcnt(int colcnt) {
        this.colcnt = colcnt;
    }

    @Basic
    @Column(name = "sort")
    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cloth cloth = (Cloth) o;

        if (id != cloth.id) return false;
        if (Double.compare(cloth.value, value) != 0) return false;
        if (clothcub != cloth.clothcub) return false;
        if (colcnt != cloth.colcnt) return false;
        if (name != null ? !name.equals(cloth.name) : cloth.name != null) return false;
        if (brand != null ? !brand.equals(cloth.brand) : cloth.brand != null) return false;
        if (clothsta != null ? !clothsta.equals(cloth.clothsta) : cloth.clothsta != null) return false;
        if (shelfsta != null ? !shelfsta.equals(cloth.shelfsta) : cloth.shelfsta != null) return false;
        if (time != null ? !time.equals(cloth.time) : cloth.time != null) return false;
        if (size != null ? !size.equals(cloth.size) : cloth.size != null) return false;
        if (part != null ? !part.equals(cloth.part) : cloth.part != null) return false;
        if (scenes != null ? !scenes.equals(cloth.scenes) : cloth.scenes != null) return false;
        if (season != null ? !season.equals(cloth.season) : cloth.season != null) return false;
        if (color != null ? !color.equals(cloth.color) : cloth.color != null) return false;
        if (style != null ? !style.equals(cloth.style) : cloth.style != null) return false;
        if (sort != null ? !sort.equals(cloth.sort) : cloth.sort != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        temp = Double.doubleToLongBits(value);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (clothsta != null ? clothsta.hashCode() : 0);
        result = 31 * result + (shelfsta != null ? shelfsta.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (part != null ? part.hashCode() : 0);
        result = 31 * result + clothcub;
        result = 31 * result + (scenes != null ? scenes.hashCode() : 0);
        result = 31 * result + (season != null ? season.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (style != null ? style.hashCode() : 0);
        result = 31 * result + colcnt;
        result = 31 * result + (sort != null ? sort.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"name\":\"")
                .append(name).append('\"');
        sb.append(",\"brand\":\"")
                .append(brand).append('\"');
        sb.append(",\"value\":")
                .append(value);
        sb.append(",\"clothsta\":\"")
                .append(clothsta).append('\"');
        sb.append(",\"shelfsta\":\"")
                .append(shelfsta).append('\"');
        sb.append(",\"time\":\"")
                .append(time).append('\"');
        sb.append(",\"size\":\"")
                .append(size).append('\"');
        sb.append(",\"part\":\"")
                .append(part).append('\"');
        sb.append(",\"clothcub\":")
                .append(clothcub);
        sb.append(",\"scenes\":\"")
                .append(scenes).append('\"');
        sb.append(",\"season\":\"")
                .append(season).append('\"');
        sb.append(",\"color\":\"")
                .append(color).append('\"');
        sb.append(",\"style\":\"")
                .append(style).append('\"');
        sb.append(",\"colcnt\":")
                .append(colcnt);
        sb.append(",\"sort\":\"")
                .append(sort).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
