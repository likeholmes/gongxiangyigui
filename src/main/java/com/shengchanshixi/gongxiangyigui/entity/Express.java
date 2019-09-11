package com.shengchanshixi.gongxiangyigui.entity;

import javax.persistence.*;

@Entity
@Table(name = "express_info", schema = "gongxiangyigui", catalog = "")
public class Express {
    private int id;
    private String name;
    private String contact;
    private String tele;
    private double price;

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
    @Column(name = "contact")
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Basic
    @Column(name = "tele")
    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    @Basic
    @Column(name = "price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Express express = (Express) o;

        if (id != express.id) return false;
        if (Double.compare(express.price, price) != 0) return false;
        if (name != null ? !name.equals(express.name) : express.name != null) return false;
        if (contact != null ? !contact.equals(express.contact) : express.contact != null) return false;
        if (tele != null ? !tele.equals(express.tele) : express.tele != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (contact != null ? contact.hashCode() : 0);
        result = 31 * result + (tele != null ? tele.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
