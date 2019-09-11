package com.shengchanshixi.gongxiangyigui.dao;

import com.shengchanshixi.gongxiangyigui.entity.Express;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ExpressDao extends JpaRepository<Express,Long> {

    @Transactional
    @Query(value = "delete from express_info where id=?1 ", nativeQuery = true)
    @Modifying
    void deleteById(int id);
}
