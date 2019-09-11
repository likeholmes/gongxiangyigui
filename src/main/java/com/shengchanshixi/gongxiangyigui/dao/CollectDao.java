package com.shengchanshixi.gongxiangyigui.dao;

import com.shengchanshixi.gongxiangyigui.entity.Collect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface CollectDao extends JpaRepository<Collect,Long> {

    @Transactional
    @Query(value = "delete from cloth_collect where userid=?1 ", nativeQuery = true)
    @Modifying
    void deleteByUserid(String userid);

    @Transactional
    @Query(value = "delete from cloth_collect where clothid=?1 ", nativeQuery = true)
    @Modifying
    void deleteByClothid(int clothid);
}
