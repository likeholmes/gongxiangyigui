package com.shengchanshixi.gongxiangyigui.service;

import com.shengchanshixi.gongxiangyigui.entity.Cloth;
import com.shengchanshixi.gongxiangyigui.entity.Collect;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CollectService {

    void delete(String userid);

    void delete(int clothid);

    void delete(String userid,int clothid);

    Collect add(String userid,int clothid);

    List<Collect> findCollects(String userid);

    Page<Collect> findCollects(String userid, Pageable pageable);

}
