package com.shengchanshixi.gongxiangyigui.service.impl;

import com.shengchanshixi.gongxiangyigui.dao.TagDao;
import com.shengchanshixi.gongxiangyigui.entity.Tag;
import com.shengchanshixi.gongxiangyigui.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagDao tagDao;

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
}
