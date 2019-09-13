package com.shengchanshixi.gongxiangyigui.service;

import com.shengchanshixi.gongxiangyigui.entity.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BrandService {

    void delete(int id);

    Brand add(Brand brand);

    List<Brand> findAllList();

    Page<Brand> findAllPage(Pageable pageable);

}
