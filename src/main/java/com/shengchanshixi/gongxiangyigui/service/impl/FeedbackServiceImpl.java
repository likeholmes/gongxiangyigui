package com.shengchanshixi.gongxiangyigui.service.impl;

import com.shengchanshixi.gongxiangyigui.dao.FeedbackDao;
import com.shengchanshixi.gongxiangyigui.dao.MsgDao;
import com.shengchanshixi.gongxiangyigui.entity.Feedback;
import com.shengchanshixi.gongxiangyigui.entity.Msg;
import com.shengchanshixi.gongxiangyigui.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    FeedbackDao feedbackDao;

    @Autowired
    MsgDao msgDao;

    @Override
    public void delete(int id) {
        //删除反馈内部的消息
        msgDao.deleteByFeedbackid(id);
        feedbackDao.deleteById(id);
    }

    @Override
    public List<Feedback> findAllList() {
        Sort sort=new Sort(Sort.Direction.DESC,"time");
        return feedbackDao.findAll(sort);
    }

    @Override
    public List<Feedback> findByUserId(String userid) {
        return feedbackDao.findByUserid(userid);
    }

    @Override
    public List<Feedback> findBySort(String sort) {
        return feedbackDao.findBySort(sort);
    }

    @Override
    public List<Feedback> findAllBySort(Sort sort) {
        return feedbackDao.findAll(sort);
    }

    @Override
    public Page<Feedback> findAllPage(Pageable pageable) {
        return feedbackDao.findAll(pageable);
    }

    @Override
    public Page<Feedback> findByUserId(String userid, Pageable pageable) {
        return feedbackDao.findByUserid(userid,pageable);
    }

    @Override
    public Page<Feedback> findBySort(String sort, Pageable pageable) {
        return feedbackDao.findBySort(sort,pageable);
    }

    //重复性检查放在前端页面
    @Override
    public Feedback add(Feedback feedback) {
        return add(feedback);
    }

    //待定
    @Override
    public Feedback update(Feedback feedback) {
        return null;
    }

    //从上到下显示从旧到新
    @Override
    public List<Msg> findByUseridList(String userid, Sort sort) {
        return msgDao.findByUseridOrderByTimeAsc(userid);
    }

    @Override
    public Page<Msg> findByUseridPage(String userid, Pageable pageable) {
        return msgDao.findByUserid(userid,pageable);
    }

    @Override
    public void deleteByUserid(String userid) {
        List<Feedback>feedbacks=feedbackDao.findByUserid(userid);
        for (Feedback feedback:feedbacks
             ) {
            delete(feedback.getId());
        }
    }
}
