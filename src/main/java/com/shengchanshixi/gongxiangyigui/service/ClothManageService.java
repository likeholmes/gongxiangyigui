package com.shengchanshixi.gongxiangyigui.service;

import com.shengchanshixi.gongxiangyigui.dao.ClothDao;
import com.shengchanshixi.gongxiangyigui.entity.Cloth;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClothManageService {

    Page<Cloth> findAllPage(Pageable pageable);

    List<Cloth> findAllList();

    List<Cloth> findByNameList(String name);

    Cloth findById(int id);

    Page<Cloth> findByNamePage(String name,Pageable pageable);

    List<Cloth> findByBrandList(String brand);

    Page<Cloth> findByBrandPage(String brand,Pageable pageable);

    List<Cloth> findByClothstaList(String clothsta);

    Page<Cloth> findByClothstaPage(String clothsta,Pageable pageable);

    List<Cloth> findByShelfstaList(String shelfsta);

    Page<Cloth> findByShelfstaPage(String shelfsta,Pageable pageable);

    List<Cloth> findBySizeList(String size);

    Page<Cloth> findBySizePage(String size,Pageable pageable);

    List<Cloth> findByPartList(String part);

    Page<Cloth> findByPartPage(String part,Pageable pageable);

    List<Cloth> findByClothcubList(String clothcub);

    Page<Cloth> findByClothcubPage(String clothcub,Pageable pageable);

    List<Cloth> findByScenesList(String scenes);

    Page<Cloth> findByScenesPage(String scenes,Pageable pageable);

    List<Cloth> findBySeasonList(String season);

    Page<Cloth> findBySeasonPage(String season,Pageable pageable);

    List<Cloth> findByColorList(String color);

    Page<Cloth> findByColorPage(String color,Pageable pageable);

    List<Cloth> findByStyleList(String style);

    Page<Cloth> findByStylePage(String style,Pageable pageable);

    List<Cloth> findBySortList(String sort);

    Page<Cloth> findBySortPage(String sort,Pageable pageable);

    void delete(int id);

    Cloth update(Cloth cloth);

    Cloth add(Cloth cloth);

}
