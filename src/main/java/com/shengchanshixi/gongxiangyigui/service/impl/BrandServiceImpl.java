package com.shengchanshixi.gongxiangyigui.service.impl;

import com.shengchanshixi.gongxiangyigui.dao.BrandDao;
import com.shengchanshixi.gongxiangyigui.entity.Brand;
import com.shengchanshixi.gongxiangyigui.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandDao brandDao;

    @Override
    public void delete(int id) {
        brandDao.deleteById(id);
    }

    @Override
    public Brand add(Brand brand) {
        if(brandDao.findByName(brand.getName())!=null){
            System.out.println("已添加过该品牌");
            return null;
        }
        return brandDao.save(brand);
    }
}
