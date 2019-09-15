package com.shengchanshixi.gongxiangyigui.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "order_list", schema = "gongxiangyigui", catalog = "")
public class Order {
    private String id;
    private Integer expressid;
    private int clothid;
    private String userid;
    private String name;
    private String trackid;
    private String phone;
    private String province;
    private String city;
    private String district;
    private String postcode;
    private String address;
    private Timestamp ordertime;
    private Timestamp delivtime;
    private Timestamp recevtime;
    private String status;
    private int backtime;
    private String backtrack;
    private String bugsta;
    private String bugdeal;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "expressid")
    public Integer getExpressid() {
        return expressid;
    }

    public void setExpressid(Integer expressid) {
        this.expressid = expressid;
    }

    @Basic
    @Column(name = "clothid")
    public int getClothid() {
        return clothid;
    }

    public void setClothid(int clothid) {
        this.clothid = clothid;
    }

    @Basic
    @Column(name = "userid")
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
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
    @Column(name = "trackid")
    public String getTrackid() {
        return trackid;
    }

    public void setTrackid(String trackid) {
        this.trackid = trackid;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "province")
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "district")
    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Basic
    @Column(name = "postcode")
    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "ordertime")
    public Timestamp getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Timestamp ordertime) {
        this.ordertime = ordertime;
    }

    @Basic
    @Column(name = "delivtime")
    public Timestamp getDelivtime() {
        return delivtime;
    }

    public void setDelivtime(Timestamp delivtime) {
        this.delivtime = delivtime;
    }

    @Basic
    @Column(name = "recevtime")
    public Timestamp getRecevtime() {
        return recevtime;
    }

    public void setRecevtime(Timestamp recevtime) {
        this.recevtime = recevtime;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "backtime")
    public int getBacktime() {
        return backtime;
    }

    public void setBacktime(int backtime) {
        this.backtime = backtime;
    }

    @Basic
    @Column(name = "backtrack")
    public String getBacktrack() {
        return backtrack;
    }

    public void setBacktrack(String backtrack) {
        this.backtrack = backtrack;
    }

    @Basic
    @Column(name = "bugsta")
    public String getBugsta() {
        return bugsta;
    }

    public void setBugsta(String bugsta) {
        this.bugsta = bugsta;
    }

    @Basic
    @Column(name = "bugdeal")
    public String getBugdeal() {
        return bugdeal;
    }

    public void setBugdeal(String bugdeal) {
        this.bugdeal = bugdeal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (clothid != order.clothid) return false;
        if (backtime != order.backtime) return false;
        if (id != null ? !id.equals(order.id) : order.id != null) return false;
        if (expressid != null ? !expressid.equals(order.expressid) : order.expressid != null) return false;
        if (userid != null ? !userid.equals(order.userid) : order.userid != null) return false;
        if (name != null ? !name.equals(order.name) : order.name != null) return false;
        if (trackid != null ? !trackid.equals(order.trackid) : order.trackid != null) return false;
        if (phone != null ? !phone.equals(order.phone) : order.phone != null) return false;
        if (province != null ? !province.equals(order.province) : order.province != null) return false;
        if (city != null ? !city.equals(order.city) : order.city != null) return false;
        if (district != null ? !district.equals(order.district) : order.district != null) return false;
        if (postcode != null ? !postcode.equals(order.postcode) : order.postcode != null) return false;
        if (address != null ? !address.equals(order.address) : order.address != null) return false;
        if (ordertime != null ? !ordertime.equals(order.ordertime) : order.ordertime != null) return false;
        if (delivtime != null ? !delivtime.equals(order.delivtime) : order.delivtime != null) return false;
        if (recevtime != null ? !recevtime.equals(order.recevtime) : order.recevtime != null) return false;
        if (status != null ? !status.equals(order.status) : order.status != null) return false;
        if (backtrack != null ? !backtrack.equals(order.backtrack) : order.backtrack != null) return false;
        if (bugsta != null ? !bugsta.equals(order.bugsta) : order.bugsta != null) return false;
        if (bugdeal != null ? !bugdeal.equals(order.bugdeal) : order.bugdeal != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (expressid != null ? expressid.hashCode() : 0);
        result = 31 * result + clothid;
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (trackid != null ? trackid.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (province != null ? province.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (district != null ? district.hashCode() : 0);
        result = 31 * result + (postcode != null ? postcode.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (ordertime != null ? ordertime.hashCode() : 0);
        result = 31 * result + (delivtime != null ? delivtime.hashCode() : 0);
        result = 31 * result + (recevtime != null ? recevtime.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + backtime;
        result = 31 * result + (backtrack != null ? backtrack.hashCode() : 0);
        result = 31 * result + (bugsta != null ? bugsta.hashCode() : 0);
        result = 31 * result + (bugdeal != null ? bugdeal.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":\"")
                .append(id).append('\"');
        sb.append(",\"expressid\":")
                .append(expressid);
        sb.append(",\"clothid\":")
                .append(clothid);
        sb.append(",\"userid\":\"")
                .append(userid).append('\"');
        sb.append(",\"name\":\"")
                .append(name).append('\"');
        sb.append(",\"trackid\":\"")
                .append(trackid).append('\"');
        sb.append(",\"phone\":\"")
                .append(phone).append('\"');
        sb.append(",\"province\":\"")
                .append(province).append('\"');
        sb.append(",\"city\":\"")
                .append(city).append('\"');
        sb.append(",\"district\":\"")
                .append(district).append('\"');
        sb.append(",\"postcode\":\"")
                .append(postcode).append('\"');
        sb.append(",\"address\":\"")
                .append(address).append('\"');
        sb.append(",\"ordertime\":\"")
                .append(ordertime).append('\"');
        sb.append(",\"delivtime\":\"")
                .append(delivtime).append('\"');
        sb.append(",\"recevtime\":\"")
                .append(recevtime).append('\"');
        sb.append(",\"status\":\"")
                .append(status).append('\"');
        sb.append(",\"backtime\":")
                .append(backtime);
        sb.append(",\"backtrack\":\"")
                .append(backtrack).append('\"');
        sb.append(",\"bugsta\":\"")
                .append(bugsta).append('\"');
        sb.append(",\"bugdeal\":\"")
                .append(bugdeal).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
