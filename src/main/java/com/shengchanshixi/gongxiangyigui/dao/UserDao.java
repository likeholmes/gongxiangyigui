package com.shengchanshixi.gongxiangyigui.dao;

import com.shengchanshixi.gongxiangyigui.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserDao extends JpaRepository<User,Long> {

    User findById(String id);

    List<User> findByStatus(String status);

    Page<User> findByStatus(String status,Pageable pageable);

    @Transactional
    @Query(value = "delete from user_info where id=?1 ", nativeQuery = true)
    @Modifying
    void deleteById(String id);


}
