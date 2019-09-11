package com.shengchanshixi.gongxiangyigui.dao;

import com.shengchanshixi.gongxiangyigui.entity.Operate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface OperateDao extends JpaRepository<Operate,Long> {

    @Transactional
    @Query(value = "delete from ope_mod where operate=?1 ", nativeQuery = true)
    @Modifying
    void deleteByOperate(String operate);

}
