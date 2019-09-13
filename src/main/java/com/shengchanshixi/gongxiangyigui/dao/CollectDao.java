package com.shengchanshixi.gongxiangyigui.dao;

import com.shengchanshixi.gongxiangyigui.entity.Collect;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CollectDao extends JpaRepository<Collect,Long> {

    @Transactional
    @Query(value = "delete from cloth_collect where userid=?1 ", nativeQuery = true)
    @Modifying
    void deleteByUserid(String userid);

    @Transactional
    @Query(value = "delete from cloth_collect where clothid=?1 ", nativeQuery = true)
    @Modifying
    void deleteByClothid(int clothid);

    @Transactional
    @Query(value = "delete from cloth_collect where userid=?1 AND clothid=?2", nativeQuery = true)
    @Modifying
    void deleteByUseridAndClothid(String userid,int clothid);

    List<Collect> findByUserid(String userid);

    Page<Collect> findByUserid(String userid, Pageable pageable);

    List<Collect> findByClothid(int clothid);

    Collect findByUseridAndClothid(String userid,int clothid);
}
