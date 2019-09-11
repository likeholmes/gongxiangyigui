package com.shengchanshixi.gongxiangyigui.dao;

import com.shengchanshixi.gongxiangyigui.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TagDao extends JpaRepository<Tag,Long> {

    @Transactional
    @Query(value = "delete from sort_tag where id=?1 ", nativeQuery = true)
    @Modifying
    void deleteByTag(String tag);

    List<Tag> findBySort(String sort);

}
