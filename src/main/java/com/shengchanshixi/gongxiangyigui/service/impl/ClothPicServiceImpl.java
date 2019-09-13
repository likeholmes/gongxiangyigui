package com.shengchanshixi.gongxiangyigui.service.impl;

import com.shengchanshixi.gongxiangyigui.dao.ClothPicDao;
import com.shengchanshixi.gongxiangyigui.entity.ClothPic;
import com.shengchanshixi.gongxiangyigui.service.ClothPicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothPicServiceImpl implements ClothPicService {
    @Autowired
    private ClothPicDao clothPicDao;
    @Override
    public ClothPic add(ClothPic clothPic) {
        return clothPicDao.save(clothPic);
    }

    @Override
    public void deleteByid(int id) {
        clothPicDao.deleteById(id);
    }

    @Override
    public void deleteByClothid(int clothid) {
        clothPicDao.deleteByClothId(clothid);
    }

    @Override
    public List<ClothPic> findByClothid(int clothid) {
        return clothPicDao.findByClothId(clothid);
    }

    @Override
    public ClothPic findByid(int id) {
        return clothPicDao.findById(id);
    }
}
