package com.shengchanshixi.gongxiangyigui.service.impl;

import com.shengchanshixi.gongxiangyigui.dao.ClothDao;
import com.shengchanshixi.gongxiangyigui.entity.Cloth;
import com.shengchanshixi.gongxiangyigui.service.ClothManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClothManageServiceImpl implements ClothManageService {

    @Autowired
    ClothDao clothDao;

    //返回所有服装数据的分页
    @Override
    public Page<Cloth> findAllPage(Pageable pageable)
    {
        return clothDao.findAll(pageable);
    }

    @Override
    //返回所有服装数据的列表
    public List<Cloth> findAllList(){
        return clothDao.findAll();
    }

    @Override
    //根据服装名搜索
    public List<Cloth> findByNameList(String name){
        //关键词后面还有其他内容的
        List<Cloth> cloths=clothDao.findByNameLike("%"+name+"%");
        //关键词前面还有其他内容的
        //cloths.addAll(clothDao.findByNameLike("%"+name));
        //关键词前后都有其他内容的
        //cloths.addAll(clothDao.findByNameLike("%"+name+"%"));
        //完全符合关键词的
        //cloths.addAll(clothDao.findByNameLike(name));
        return cloths;
    }

    @Override
    public Page<Cloth> findByNamePage(String name,Pageable pageable){
        return clothDao.findByNameLike("%"+name+"%",pageable);
    }

    @Override
    public List<Cloth> findByBrandList(String brand){
        return clothDao.findByBrand(brand);
    }

    @Override
    public Page<Cloth> findByBrandPage(String brand, Pageable pageable) {
        return clothDao.findByBrand(brand,pageable);
    }

    @Override
    public List<Cloth> findByClothstaList(String clothsta) {
        return null;
    }

    @Override
    public Page<Cloth> findByClothstaPage(String clothsta, Pageable pageable) {
        return clothDao.findByClothsta(clothsta, pageable);
    }

    @Override
    public List<Cloth> findByShelfstaList(String shelfsta) {
        return null;
    }

    @Override
    public Page<Cloth> findByShelfstaPage(String shelfsta, Pageable pageable) {
        return clothDao.findByShelfsta(shelfsta, pageable);
    }

    @Override
    public List<Cloth> findBySizeList(String size) {
        return null;
    }

    @Override
    public Page<Cloth> findBySizePage(String size, Pageable pageable) {
        return clothDao.findBySize(size, pageable);
    }

    @Override
    public List<Cloth> findByPartList(String part) {
        return null;
    }

    @Override
    public Page<Cloth> findByPartPage(String part, Pageable pageable) {
        return clothDao.findByPart(part, pageable);
    }

    @Override
    public List<Cloth> findByClothcubList(String clothcub) {
        return null;
    }

    @Override
    public Page<Cloth> findByClothcubPage(String clothcub, Pageable pageable) {
        return clothDao.findByClothcub(clothcub, pageable);
    }

    @Override
    public List<Cloth> findByScenesList(String scenes) {
        return null;
    }

    @Override
    public Page<Cloth> findByScenesPage(String scenes, Pageable pageable) {
        return clothDao.findByScenes(scenes, pageable);
    }

    @Override
    public List<Cloth> findBySeasonList(String season) {
        return null;
    }

    @Override
    public Page<Cloth> findBySeasonPage(String season, Pageable pageable) {
        return clothDao.findBySeason(season, pageable);
    }

    @Override
    public List<Cloth> findByColorList(String color) {
        return null;
    }

    @Override
    public Page<Cloth> findByColorPage(String color, Pageable pageable) {
        return clothDao.findByColor(color, pageable);
    }

    @Override
    public List<Cloth> findByStyleList(String style) {
        return null;
    }

    @Override
    public Page<Cloth> findByStylePage(String style, Pageable pageable) {
        return clothDao.findByStyle(style, pageable);
    }

    @Override
    public List<Cloth> findBySortList(String sort) {
        return null;
    }

    @Override
    public Page<Cloth> findBySortPage(String sort, Pageable pageable) {
        return clothDao.findBySort(sort, pageable);
    }

    @Override
    public void delete(int id) {
        clothDao.deleteById(id);
    }

    @Override
    public Cloth update(Cloth cloth) {
        Cloth old=clothDao.findById(cloth.getId());
        //暂时只改了名字
        if(cloth.getName()!=null&&!cloth.getName().equals(old.getName()))
        {
            old.setName(cloth.getName());
        }
        return clothDao.save(old);
    }

    @Override
    public Cloth add(Cloth cloth) {
        //时间获取的不准确
        java.sql.Timestamp now=new java.sql.Timestamp(System.currentTimeMillis());
        cloth.setTime(now);
        return clothDao.save(cloth);
    }
}
