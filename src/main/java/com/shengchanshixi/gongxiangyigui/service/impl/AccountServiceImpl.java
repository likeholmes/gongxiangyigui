package com.shengchanshixi.gongxiangyigui.service.impl;

import com.shengchanshixi.gongxiangyigui.dao.CollectDao;
import com.shengchanshixi.gongxiangyigui.dao.UserDao;
import com.shengchanshixi.gongxiangyigui.entity.Collect;
import com.shengchanshixi.gongxiangyigui.entity.Comment;
import com.shengchanshixi.gongxiangyigui.entity.Feedback;
import com.shengchanshixi.gongxiangyigui.entity.User;
import com.shengchanshixi.gongxiangyigui.service.AccountService;
import com.shengchanshixi.gongxiangyigui.service.CollectService;
import com.shengchanshixi.gongxiangyigui.service.CommentService;
import com.shengchanshixi.gongxiangyigui.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private CommentService commentService;

    @Autowired
    private FeedbackService feedbackService;

    @Autowired
    private CollectDao collectDao;

    @Override
    public List<User> findAllList() {
        return userDao.findAll();
    }

    @Override
    public User findById(String id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> findByStatusList(String status) {
        return userDao.findByStatus(status);
    }

    @Override
    public Page<User> findAllPage(Pageable pageable) {
        return userDao.findAll(pageable);
    }

    @Override
    public Page<User> findByStatusPage(String status, Pageable pageable) {
        return userDao.findByStatus(status,pageable);
    }

    @Override
    public User ProcessAccount(User user) {
        //管理员点击冻结或解锁按钮更改用户状态
        User old=userDao.findById(user.getId());
        old.setStatus(user.getStatus());
        return userDao.save(old);
    }

    @Override
    public User add(User user) {
        java.sql.Timestamp now=new java.sql.Timestamp(System.currentTimeMillis());
        user.setRegtime(now);
        return userDao.save(user);
    }

    //不确定是否有效的方法
    @Override
    public User update(User user) {
        return userDao.save(user);
    }

    @Override
    public List<User> findAllSortList(Sort sort) {
        return userDao.findAll(sort);
    }

    @Override
    public Page<User> findAllSortPage(Pageable pageable) {
        return userDao.findAll(pageable);
    }

    //删除该账户所有的评论和反馈和收藏
    @Override
    public void delete(String id) {

        //删除该账户所有的评论
        commentService.deleteByUserid(id);
        //删除该账户所有反馈
        feedbackService.deleteByUserid(id);
        //删除该账户所有收藏
        collectDao.deleteByUserid(id);

        userDao.deleteById(id);
    }
}
