package com.shengchanshixi.gongxiangyigui.service.impl;

import com.shengchanshixi.gongxiangyigui.dao.BrandDao;
import com.shengchanshixi.gongxiangyigui.dao.ClothDao;
import com.shengchanshixi.gongxiangyigui.entity.Brand;
import com.shengchanshixi.gongxiangyigui.entity.Cloth;
import com.shengchanshixi.gongxiangyigui.service.BrandService;
import com.shengchanshixi.gongxiangyigui.util.logUtil.Log;
import com.sun.xml.internal.bind.v2.TODO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandDao brandDao;

    @Autowired
    private ClothDao clothDao;

    private Logger logger= LoggerFactory.getLogger(this.getClass());


    //将所有商品的品牌栏改为无
    //删除该品牌
    @Override
    public void delete(int id) {
        List<Cloth> cloths=clothDao.findByBrand(brandDao.findById(id).getName());
        for (Cloth cloth:cloths
             ) {
                cloth.setBrand("无");
                clothDao.save(cloth);
        }
        brandDao.deleteById(id);
    }

    //新建品牌
    @Override
    public Brand add(Brand brand) {
        if(brandDao.findByName(brand.getName()).size()>0){
            logger.warn("发现有重复品牌");
            return null;
        }
        return brandDao.save(brand);
    }

    //获取所有品牌列表
    @Override
    public List<Brand> findAllList() {
        return brandDao.findAll();
    }

    //获取所有品牌页
    @Override
    public Page<Brand> findAllPage(Pageable pageable) {
        return brandDao.findAll(pageable);
    }
}
