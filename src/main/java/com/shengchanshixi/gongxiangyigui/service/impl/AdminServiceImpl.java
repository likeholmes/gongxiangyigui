package com.shengchanshixi.gongxiangyigui.service.impl;

import com.shengchanshixi.gongxiangyigui.dao.AdminDao;
import com.shengchanshixi.gongxiangyigui.entity.Admin;
import com.shengchanshixi.gongxiangyigui.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    @Override
    public boolean checkLogin(String id,String pwd){
        Admin admin=new Admin();
        admin=adminDao.findById(id);
        if(admin.getPwd().equals(pwd))
            return true;
        return false;
    }
}
