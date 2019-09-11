package com.shengchanshixi.gongxiangyigui.service.impl;

import com.shengchanshixi.gongxiangyigui.dao.CollectDao;
import com.shengchanshixi.gongxiangyigui.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollectServiceImpl implements CollectService {

    @Autowired
    CollectDao collectDao;
    @Override
    public void deleteByUserid(String userid) {
        collectDao.deleteByUserid(userid);
    }
}
