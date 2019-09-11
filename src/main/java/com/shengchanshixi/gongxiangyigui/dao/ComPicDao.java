package com.shengchanshixi.gongxiangyigui.dao;

import com.shengchanshixi.gongxiangyigui.entity.ComPic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ComPicDao extends JpaRepository<ComPic,Long> {

    @Transactional
    @Query(value = "delete from com_pic where id=?1 ", nativeQuery = true)
    @Modifying
    void deleteById(int id);

    @Transactional
    @Query(value = "delete from com_pic where comid=?1 ", nativeQuery = true)
    @Modifying
    void deleteByComid(int comid);

}
