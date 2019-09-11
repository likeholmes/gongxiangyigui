package com.shengchanshixi.gongxiangyigui.service;

import com.shengchanshixi.gongxiangyigui.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface AccountService {

    List<User> findAllList();

    User findById(String id);

    List<User> findByStatusList(String status);

    List<User> findAllSortList(Sort sort);

    Page<User> findAllPage(Pageable pageable);

    Page<User> findByStatusPage(String status,Pageable pageable);

    Page<User> findAllSortPage(Pageable pageable);

    User ProcessAccount(User user);

    User add(User user);

    User update(User user);

    void delete(String id);
}
