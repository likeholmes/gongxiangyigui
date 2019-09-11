package com.shengchanshixi.gongxiangyigui.service.impl;

import com.shengchanshixi.gongxiangyigui.dao.ComPicDao;
import com.shengchanshixi.gongxiangyigui.service.ComPicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComPicServiceImpl implements ComPicService {

    @Autowired
    private ComPicDao comPicDao;

    @Override
    public void delete(int id) {
        comPicDao.deleteById(id);
    }
}
