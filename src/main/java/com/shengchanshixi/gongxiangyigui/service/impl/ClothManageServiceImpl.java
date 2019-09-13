package com.shengchanshixi.gongxiangyigui.service.impl;

import com.shengchanshixi.gongxiangyigui.dao.ClothDao;
import com.shengchanshixi.gongxiangyigui.dao.ClothPicDao;
import com.shengchanshixi.gongxiangyigui.dao.CollectDao;
import com.shengchanshixi.gongxiangyigui.entity.*;
import com.shengchanshixi.gongxiangyigui.service.ClothManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class ClothManageServiceImpl implements ClothManageService {

    @Autowired
    private ClothDao clothDao;

    @Autowired
    private ClothPicDao clothPicDao;

    @Autowired
    private CollectDao collectDao;

    //返回所有服装数据的分页
    @Override
    public Page<Cloth> findAll(Pageable pageable)
    {
        return clothDao.findAll(pageable);
    }

    @Override
    //返回所有服装数据的列表
    public List<Cloth> findAll(){
        return clothDao.findAll();
    }

    //删除服装图片
    //删除服装信息
    //删除服装收藏
    @Override
    public void delete(int id) {
        clothPicDao.deleteByClothId(id);
        collectDao.deleteByClothid(id);
        clothDao.deleteById(id);
    }

    //更改服装信息
    //TODO：可能需要更改
    @Override
    public Cloth update(Cloth cloth) {
        /*Cloth old=clothDao.findById(cloth.getId());
        //暂时只改了名字
        if(cloth.getName()!=null&&!cloth.getName().equals(old.getName()))
        {
            old.setName(cloth.getName());
        }
        return clothDao.save(old);*/
        return clothDao.save(cloth);
    }

    //添加服装信息
    @Override
    public Cloth add(Cloth cloth) {
        //时间获取的不准确
        java.sql.Timestamp now=new java.sql.Timestamp(System.currentTimeMillis());
        cloth.setTime(now);
        return clothDao.save(cloth);
    }

    //通过ID查找服装
    @Override
    public Cloth findById(int id) {
        return clothDao.findById(id);
    }

    //通过名称查找服装列表
    @Override
    public List<Cloth> findByName(String name) {
        return clothDao.findByNameLike("%"+name+"%");
    }

    //通过名称查找服装分页
    @Override
    public Page<Cloth> findByName(String name, Pageable pageable) {
        return clothDao.findByNameLike("%"+name+"%",pageable);
    }

    //通过条件筛选服装
    @Override
    public List<Cloth> findByConditon(List<Tag> tags) {
        Set<Cloth> clothSet=new HashSet<>();
        for (Tag tag:tags
             ) {
            switch (tag.getSort()){
                case "尺寸":
                    clothSet.addAll(clothDao.findBySize(tag.getTag()));
                    break;
                case "场景":
                    clothSet.addAll(clothDao.findByScenes(tag.getTag()));
                    break;
                case "季节":
                    clothSet.addAll(clothDao.findBySeason(tag.getTag()));
                    break;
                case "部位":
                    clothSet.addAll(clothDao.findByPart(tag.getTag()));
                    break;
                case "颜色":
                    clothSet.addAll(clothDao.findByColor(tag.getTag()));
                    break;
                case "风格":
                    clothSet.addAll(clothDao.findByStyle(tag.getTag()));
                    break;
                case "品牌":
                    clothSet.addAll(clothDao.findByBrand(tag.getTag()));
                    break;
                case "衣位数":
                    clothSet.addAll(clothDao.findByClothcub(tag.getTag()));
                    break;
            }
        }
        List<Cloth> cloths=new ArrayList<>();
        cloths.addAll(clothSet);
        return cloths;
    }

    @Override
    public Page<Cloth> findByCondition(List<Tag> tags, Pageable pageable) {
        return null;
    }

    @Override
    public List<Cloth> findByCondition(List<Tag> tags, Brand brand) {
        return null;
    }

    @Override
    public Page<Cloth> findByCondition(List<Tag> tags, Brand brand, Pageable pageable) {
        return null;
    }

    //搜索筛选
    @Override
    public List<Cloth> findBySearch(String key) {
        return clothDao.findByNameLikeOrBrandLikeOrColorLikeOrScenesLikeOrPartLikeOrStyleLike("%"+key+"%");
    }

    @Override
    public Page<Cloth> findBySearch(String key, Pageable pageable) {
        return clothDao.findByNameLikeOrBrandLikeOrColorLikeOrScenesLikeOrPartLikeOrStyleLike("%"+key+"%",pageable);
    }

    //上新推荐，一天更新一次，一次推荐十个
    //通过定时任务调用
    @Override
    public List<Cloth> findByTime() {
        long detime=24*3600*1000;
        if (clothDao.findAll().size()<10)
            detime=100*detime;
        java.sql.Timestamp time=new java.sql.Timestamp(System.currentTimeMillis()-detime);
        List<Cloth> cloths=clothDao.findByTimeAfterOrderByTimeDesc(time);
        if (cloths.size()<10)
            return cloths;
        return cloths.subList(0,9);
    }

    //随机推荐，一次推荐十个
    //通过定时任务调用
    @Override
    public List<Cloth> findByRandom() {
        Random random=new Random();
        Set<Cloth> clothSet=new HashSet<>();
        List<Cloth> oldlist=clothDao.findAll();
        if (oldlist.size()<=10)
            return oldlist;
        while (clothSet.size()<10) {
            clothSet.add(oldlist.get(random.nextInt(oldlist.size())));
        }
        List<Cloth> cloths=new ArrayList<>();
        cloths.addAll(clothSet);
        return cloths;
    }

    //个性推荐
    //推荐收藏数最多的十件
    //TODO:修订方法，需要推荐算法
    @Override
    public List<Cloth> findBySpecial() {
        return clothDao.findByColcntIsGreaterThanEqualOrderByColcntDesc(0);
    }

    //被收藏数增加
    @Override
    public Cloth collect(int id) {
        Cloth cloth=clothDao.findById(id);
        if (null==cloth)
            return null;
        cloth.setColcnt(cloth.getColcnt()+1);
        return clothDao.save(cloth);
    }

    //被收藏数减少
    @Override
    public Cloth uncollect(int id) {
        Cloth cloth=clothDao.findById(id);
        if (null==cloth)
            return null;
        cloth.setColcnt(cloth.getColcnt()-1);
        return clothDao.save(cloth);
    }
}
