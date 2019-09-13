package com.shengchanshixi.gongxiangyigui.dao;

import com.shengchanshixi.gongxiangyigui.entity.Cloth;
import com.shengchanshixi.gongxiangyigui.entity.ClothPic;
import com.shengchanshixi.gongxiangyigui.entity.ComPic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ClothPicDao extends JpaRepository<ClothPic,Long> {

    @Transactional
    @Query(value = "delete from cloth_pic where id=?1 ", nativeQuery = true)
    @Modifying
    void deleteById(int id);

    @Transactional
    @Query(value = "delete from cloth_pic where cloth_id=?1 ", nativeQuery = true)
    @Modifying
    void deleteByClothId(int clothid);

    List<ClothPic> findByClothId(int clothid);

    ClothPic findById(int id);

}
