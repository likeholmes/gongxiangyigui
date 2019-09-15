package com.shengchanshixi.gongxiangyigui.service.impl;

import com.shengchanshixi.gongxiangyigui.dao.ClothPicDao;
import com.shengchanshixi.gongxiangyigui.entity.*;
import com.shengchanshixi.gongxiangyigui.service.ClothPicService;
import com.shengchanshixi.gongxiangyigui.util.Const;
import com.shengchanshixi.gongxiangyigui.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.UUID;


@Service
public class ClothPicServiceImpl implements ClothPicService {
    @Autowired
    private ClothPicDao clothPicDao;

    protected Logger logger =  LoggerFactory.getLogger(this.getClass());
    @Value("${static.url}")
    private String staticUrl;
    @Value("${file.file.clothpictures.url}")
    private String fileClothpicturesUrl;

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

    @Override
    //效率低
    public List<ClothPic> findAll() {
        List<ClothPic> clothPics=clothPicDao.findAll();
        List<ClothPic> nclothPics=new ArrayList<>();
        boolean[] clothids=new boolean[10000];
        for (ClothPic clothPic:clothPics
             ) {
            if (!clothids[clothPic.getClothId()]){
                nclothPics.add(clothPic);
                clothids[clothPic.getClothId()]=true;
            }
        }
        return nclothPics;
    }

    @Override
    public List<ClothPic> findByList(List<Cloth> cloths) {
        List<ClothPic> clothPics=new ArrayList<>();
        for (Cloth cloth:cloths
             ) {
            List<ClothPic> nclothPic=clothPicDao.findByClothId(cloth.getId());
            if (nclothPic!=null&&nclothPic.size()>0){
                clothPics.add(nclothPic.get(0));
            }
        }
        return clothPics;
    }
}
