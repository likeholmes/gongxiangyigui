package com.shengchanshixi.gongxiangyigui.service;

import com.shengchanshixi.gongxiangyigui.dao.ClothDao;
import com.shengchanshixi.gongxiangyigui.entity.Brand;
import com.shengchanshixi.gongxiangyigui.entity.Cloth;
import com.shengchanshixi.gongxiangyigui.entity.Tag;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClothManageService {

    Page<Cloth> findAll(Pageable pageable);

    List<Cloth> findAll();

    List<Cloth> findByName(String name);

    Cloth findById(int id);

    Page<Cloth> findByName(String name,Pageable pageable);

    List<Cloth> findByConditon(List<Tag> tags);

    Page<Cloth> findByCondition(List<Tag> tags,Pageable pageable);

    List<Cloth> findByCondition(List<Tag> tags, Brand brand);

    Page<Cloth> findByCondition(List<Tag> tags, Brand brand,Pageable pageable);

    List<Cloth> findBySearch(String key);

    Page<Cloth> findBySearch(String key,Pageable pageable);

    List<Cloth> findByTime();

    List<Cloth> findByRandom();

    List<Cloth> findBySpecial();

    Cloth findAfterTime(Long time);

    void delete(int id);

    Cloth update(Cloth cloth);

    Cloth add(Cloth cloth);

    Cloth collect(int id);

    Cloth uncollect(int id);

}
