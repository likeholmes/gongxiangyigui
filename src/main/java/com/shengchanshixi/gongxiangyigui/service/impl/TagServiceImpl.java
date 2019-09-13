package com.shengchanshixi.gongxiangyigui.service.impl;

import com.shengchanshixi.gongxiangyigui.dao.ClothDao;
import com.shengchanshixi.gongxiangyigui.dao.TagDao;
import com.shengchanshixi.gongxiangyigui.entity.Cloth;
import com.shengchanshixi.gongxiangyigui.entity.Tag;
import com.shengchanshixi.gongxiangyigui.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDao tagDao;

    @Autowired
    private ClothDao clothDao;

    @Override
    public List<Tag> findAllList() {
        return tagDao.findAll();
    }

    @Override
    public List<Tag> findBySort(String sort) {
        return tagDao.findBySort(sort);
    }


    //未考虑安全性
    @Override
    public void delete(String tag) {
        List<Cloth> cloths=clothDao.findByScenesOrSizeOrStyleOrColorOrPartOrSeason(tag);
        for (Cloth cloth:cloths
                ) {
            switch (tagDao.findByTag(tag).getSort()){
                case "尺寸":
                    cloth.setSize("无");
                    break;
                case "场景":
                    cloth.setScenes("无");
                    break;
                case "季节":
                    cloth.setSeason("无");
                    break;
                case "部位":
                    cloth.setPart("无");
                    break;
                case "颜色":
                    cloth.setColor("无");
                    break;
                case "风格":
                    cloth.setStyle("无");
                    break;
            }
            clothDao.save(cloth);
        }
        tagDao.deleteByTag(tag);
    }

    @Override
    public Tag add(Tag tag) {
        return tagDao.save(tag);
    }

    @Override
    public List<Tag> findAllAscByCnt() {
        Sort sort = new Sort(Sort.Direction.ASC, "cnt");
        return tagDao.findAll(sort);
    }

    //被访问数增加
    @Override
    public Tag collectOrSearchTag(String tag) {
        Tag ntag=tagDao.findByTag(tag);
        if(null==ntag)
            return null;
        ntag.setCnt(ntag.getCnt()+1);
        return tagDao.save(ntag);
    }

    //被收藏数减少
    @Override
    public Tag uncollectTag(String tag) {
        Tag ntag=tagDao.findByTag(tag);
        if (null==ntag)
            return null;
        ntag.setCnt(ntag.getCnt()-1);
        return tagDao.save(ntag);
    }
}
