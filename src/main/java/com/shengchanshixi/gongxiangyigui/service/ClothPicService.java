package com.shengchanshixi.gongxiangyigui.service;

import com.shengchanshixi.gongxiangyigui.entity.ClothPic;

import java.util.List;

public interface ClothPicService {

    ClothPic add(ClothPic clothPic);

    void deleteByid(int id);

    void deleteByClothid(int clothid);

    List<ClothPic> findByClothid(int clothid);

    ClothPic findByid(int id);

}
