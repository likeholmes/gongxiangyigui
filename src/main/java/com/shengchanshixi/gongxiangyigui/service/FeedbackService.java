package com.shengchanshixi.gongxiangyigui.service;

import com.shengchanshixi.gongxiangyigui.entity.Feedback;
import com.shengchanshixi.gongxiangyigui.entity.Msg;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface FeedbackService {

    void delete(int id);

    void deleteByUserid(String userid);

    List<Feedback> findAllList();

    List<Feedback> findByUserId(String userid);

    List<Feedback> findBySort(String sort);

    List<Feedback> findAllBySort(Sort sort);

    Page<Feedback> findAllPage(Pageable pageable);

    Page<Feedback> findByUserId(String userid,Pageable pageable);

    Page<Feedback> findBySort(String sort,Pageable pageable);

    Feedback add(Feedback feedback);

    Msg addMsg(Msg msg);

    Feedback update(Feedback feedback);

    List<Msg> findByUseridList(String userid);

    List<Msg> findMsgs(int id);

    Page<Msg> findByUseridPage(String userid,Pageable pageable);

    Feedback findById(int id);

    List<Feedback> findByKey(String key);

}
