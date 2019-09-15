package com.shengchanshixi.gongxiangyigui.service;

import com.shengchanshixi.gongxiangyigui.entity.Brand;
import com.shengchanshixi.gongxiangyigui.entity.Cloth;
import com.shengchanshixi.gongxiangyigui.entity.ClothPic;
import com.shengchanshixi.gongxiangyigui.entity.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClothPicService {

    ClothPic add(ClothPic clothPic);

    void deleteByid(int id);

    void deleteByClothid(int clothid);

    List<ClothPic> findByClothid(int clothid);

    ClothPic findByid(int id);

    List<ClothPic> findAll();

    List<ClothPic> findByList(List<Cloth> cloths);

}
