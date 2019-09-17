package com.shengchanshixi.gongxiangyigui.service.impl;

import com.shengchanshixi.gongxiangyigui.dao.ClothDao;
import com.shengchanshixi.gongxiangyigui.dao.CollectDao;
import com.shengchanshixi.gongxiangyigui.dao.TagDao;
import com.shengchanshixi.gongxiangyigui.entity.Cloth;
import com.shengchanshixi.gongxiangyigui.entity.Collect;
import com.shengchanshixi.gongxiangyigui.entity.Tag;
import com.shengchanshixi.gongxiangyigui.service.ClothManageService;
import com.shengchanshixi.gongxiangyigui.service.CollectService;
import com.shengchanshixi.gongxiangyigui.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectServiceImpl implements CollectService {

    @Autowired
    private CollectDao collectDao;

    @Autowired
    private ClothDao clothDao;

    @Autowired
    private TagDao tagDao;

    @Autowired
    private ClothManageService clothManageService;

    @Autowired
    private TagService tagService;

    private void uncollect(int clothid){
        Cloth cloth=clothDao.findById(clothid);
        clothManageService.uncollect(cloth.getId());
        tagService.uncollectTag(cloth.getPart());
        tagService.uncollectTag(cloth.getColor());
        tagService.uncollectTag(cloth.getScenes());
        tagService.uncollectTag(cloth.getSeason());
        tagService.uncollectTag(cloth.getStyle());
        tagService.uncollectTag(cloth.getSize());
    };

    private void collect(int clothid){
        Cloth cloth=clothDao.findById(clothid);
        clothManageService.collect(cloth.getId());
        tagService.collectOrSearchTag(cloth.getPart());
        tagService.collectOrSearchTag(cloth.getColor());
        tagService.collectOrSearchTag(cloth.getScenes());
        tagService.collectOrSearchTag(cloth.getSeason());
        tagService.collectOrSearchTag(cloth.getStyle());
        tagService.collectOrSearchTag(cloth.getSize());
    };

    @Override
    public void delete(String userid) {
        //该商品的被收藏数-1
        //该商品的标签被收藏数-1
        List<Collect> collects=collectDao.findByUserid(userid);
        for (Collect collect:collects
             ) {
            uncollect(collect.getClothid());
        }
        collectDao.deleteByUserid(userid);
    }

    @Override
    public void delete(int clothid) {
        uncollect(clothid);
        collectDao.deleteByClothid(clothid);
    }

    @Override
    public void delete(String userid, int clothid) {
        uncollect(clothid);
        collectDao.deleteByUseridAndClothid(userid, clothid);
    }

    @Override
    public Collect add(String userid, int clothid) {
        Collect collect=new Collect();
        collect.setUserid(userid);
        collect.setClothid(clothid);
        Cloth cloth=clothDao.findById(clothid);
        collect.setClothcub(cloth.getClothcub());
        collect.setClothsta(cloth.getClothsta());
        collect.setShelfsta(cloth.getShelfsta());
        collect.setValue(cloth.getValue());
        //该商品被收藏数+1
        //该商品的标签被收藏数+1
        collect(clothid);

        return collectDao.save(collect);
    }

    @Override
    public List<Collect> findCollects(String userid) {
        return collectDao.findByUserid(userid);
    }

    @Override
    public Page<Collect> findCollects(String userid, Pageable pageable) {
        return collectDao.findByUserid(userid,pageable);
    }

}
