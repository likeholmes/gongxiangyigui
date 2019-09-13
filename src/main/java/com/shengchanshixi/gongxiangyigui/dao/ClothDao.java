package com.shengchanshixi.gongxiangyigui.dao;

import com.shengchanshixi.gongxiangyigui.entity.Cloth;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ClothDao extends JpaRepository<Cloth,Long> {

    Cloth findById(int id);

    List<Cloth> findByNameLike(String namelike);

    Page<Cloth> findByNameLike(String namelike,Pageable pageable);

    List<Cloth> findByBrand(String brand);

    Page<Cloth> findByBrand(String brand,Pageable pageable);

    List<Cloth> findByClothsta(String clothsta);

    Page<Cloth> findByClothsta(String clothsta,Pageable pageable);

    List<Cloth> findByShelfsta(String shelfsta);

    Page<Cloth> findByShelfsta(String shelfsta,Pageable pageable);

    List<Cloth> findBySize(String size);

    Page<Cloth> findBySize(String size,Pageable pageable);

    List<Cloth> findByPart(String part);

    Page<Cloth> findByPart(String part,Pageable pageable);

    List<Cloth> findByClothcub(String clothcub);

    Page<Cloth> findByClothcub(String clothcub,Pageable pageable);

    List<Cloth> findByScenes(String scenes);

    Page<Cloth> findByScenes(String scenes,Pageable pageable);

    List<Cloth> findBySeason(String season);

    Page<Cloth> findBySeason(String Season,Pageable pageable);

    List<Cloth> findByColor(String color);

    Page<Cloth> findByColor(String color,Pageable pageable);

    List<Cloth> findByStyle(String style);

    Page<Cloth> findByStyle(String style,Pageable pageable);

    List<Cloth> findBySort(String sort);

    Page<Cloth> findBySort(String sort,Pageable pageable);

    List<Cloth> findByTimeAfterOrderByTimeDesc(java.sql.Timestamp time);

    List<Cloth> findByNameLikeOrBrandLikeOrColorLikeOrScenesLikeOrPartLikeOrStyleLike(String key);

    Page<Cloth> findByNameLikeOrBrandLikeOrColorLikeOrScenesLikeOrPartLikeOrStyleLike(String key,Pageable pageable);

    List<Cloth> findByColcntIsGreaterThanEqualOrderByColcntDesc(int cnt);

    List<Cloth> findByScenesOrSizeOrStyleOrColorOrPartOrSeason(String tag);

    List<Cloth> findByTimeAfter(java.sql.Timestamp time);

    @Transactional
    @Query(value = "delete from cloth_info where id=?1 ", nativeQuery = true)
    @Modifying
    void deleteById(int id);
}
