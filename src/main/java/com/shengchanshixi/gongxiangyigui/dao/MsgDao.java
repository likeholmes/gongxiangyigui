package com.shengchanshixi.gongxiangyigui.dao;

import com.shengchanshixi.gongxiangyigui.entity.Msg;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MsgDao extends JpaRepository<Msg,Long>{

    Page<Msg> findByUserid(String userid, Pageable pageable);

    List<Msg> findByUseridOrderByTimeAsc(String userid);

    List<Msg> findByFeedbackid(int feedbackid);

    @Transactional
    @Query(value = "delete from user_msg where userid=?1 ", nativeQuery = true)
    @Modifying
    void deleteByUserid(String userid);

    @Transactional
    @Query(value = "delete from user_msg where feedbackid=?1 ", nativeQuery = true)
    @Modifying
    void deleteByFeedbackid(int id);

}
