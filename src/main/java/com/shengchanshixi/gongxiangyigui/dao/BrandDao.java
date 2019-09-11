package com.shengchanshixi.gongxiangyigui.dao;

import com.shengchanshixi.gongxiangyigui.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface BrandDao extends JpaRepository<Brand,Long> {

    @Transactional
    @Query(value = "delete from brand_list where id=?1 ", nativeQuery = true)
    @Modifying
    void deleteById(int id);

    List<Brand> findByName(String name);

}
