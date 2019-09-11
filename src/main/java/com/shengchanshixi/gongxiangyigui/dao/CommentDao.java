package com.shengchanshixi.gongxiangyigui.dao;

import com.shengchanshixi.gongxiangyigui.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CommentDao extends JpaRepository<Comment,Long> {

    @Transactional
    @Query(value = "delete from cloth_comment where id=?1 ", nativeQuery = true)
    @Modifying
    void deleteById(int id);

    @Transactional
    @Query(value = "delete from cloth_comment where clothid=?1", nativeQuery = true)
    @Modifying
    void deleteByClothid(int clothid);

    @Transactional
    @Query(value = "delete from cloth_comment where userid=?1 ", nativeQuery = true)
    @Modifying
    void deleteByUserid(String userid);

    List<Comment> findByUserid(String userid);

}
