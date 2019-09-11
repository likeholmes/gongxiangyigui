package com.shengchanshixi.gongxiangyigui.dao;

import com.shengchanshixi.gongxiangyigui.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface LogDao extends JpaRepository<Log,Long>{

    @Transactional
    @Query(value = "delete from log_list where id=?1 ", nativeQuery = true)
    @Modifying
    void deleteById(int id);
}
