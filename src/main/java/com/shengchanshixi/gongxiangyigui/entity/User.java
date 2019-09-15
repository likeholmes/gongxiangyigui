package com.shengchanshixi.gongxiangyigui.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user_info", schema = "gongxiangyigui", catalog = "")
public class User {
    private String id;
    private String pwd;
    private String status;
    private String name;
    private String idnum;
    private String phone;
    private String sex;
    private Timestamp regtime;
    private Timestamp viptime;
    private int level;
    private int clothcub;
    private int follwer;
    private String province;
    private String city;
    private String district;
    private String postcode;
    private String address;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "pwd")
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "idnum")
    public String getIdnum() {
        return idnum;
    }

    public void setIdnum(String idnum) {
        this.idnum = idnum;
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
    @Column(name = "sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "regtime")
    public Timestamp getRegtime() {
        return regtime;
    }

    public void setRegtime(Timestamp regtime) {
        this.regtime = regtime;
    }

    @Basic
    @Column(name = "viptime")
    public Timestamp getViptime() {
        return viptime;
    }

    public void setViptime(Timestamp viptime) {
        this.viptime = viptime;
    }

    @Basic
    @Column(name = "level")
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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
    @Column(name = "follwer")
    public int getFollwer() {
        return follwer;
    }

    public void setFollwer(int follwer) {
        this.follwer = follwer;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (level != user.level) return false;
        if (clothcub != user.clothcub) return false;
        if (follwer != user.follwer) return false;
        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (pwd != null ? !pwd.equals(user.pwd) : user.pwd != null) return false;
        if (status != null ? !status.equals(user.status) : user.status != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (idnum != null ? !idnum.equals(user.idnum) : user.idnum != null) return false;
        if (phone != null ? !phone.equals(user.phone) : user.phone != null) return false;
        if (sex != null ? !sex.equals(user.sex) : user.sex != null) return false;
        if (regtime != null ? !regtime.equals(user.regtime) : user.regtime != null) return false;
        if (viptime != null ? !viptime.equals(user.viptime) : user.viptime != null) return false;
        if (province != null ? !province.equals(user.province) : user.province != null) return false;
        if (city != null ? !city.equals(user.city) : user.city != null) return false;
        if (district != null ? !district.equals(user.district) : user.district != null) return false;
        if (postcode != null ? !postcode.equals(user.postcode) : user.postcode != null) return false;
        if (address != null ? !address.equals(user.address) : user.address != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (pwd != null ? pwd.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (idnum != null ? idnum.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (regtime != null ? regtime.hashCode() : 0);
        result = 31 * result + (viptime != null ? viptime.hashCode() : 0);
        result = 31 * result + level;
        result = 31 * result + clothcub;
        result = 31 * result + follwer;
        result = 31 * result + (province != null ? province.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (district != null ? district.hashCode() : 0);
        result = 31 * result + (postcode != null ? postcode.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":\"")
                .append(id).append('\"');
        sb.append(",\"pwd\":\"")
                .append(pwd).append('\"');
        sb.append(",\"status\":\"")
                .append(status).append('\"');
        sb.append(",\"name\":\"")
                .append(name).append('\"');
        sb.append(",\"idnum\":\"")
                .append(idnum).append('\"');
        sb.append(",\"phone\":\"")
                .append(phone).append('\"');
        sb.append(",\"sex\":\"")
                .append(sex).append('\"');
        sb.append(",\"regtime\":\"")
                .append(regtime).append('\"');
        sb.append(",\"viptime\":\"")
                .append(viptime).append('\"');
        sb.append(",\"level\":")
                .append(level);
        sb.append(",\"clothcub\":")
                .append(clothcub);
        sb.append(",\"follwer\":")
                .append(follwer);
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
        sb.append('}');
        return sb.toString();
    }
}
