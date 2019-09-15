package com.shengchanshixi.gongxiangyigui.service;

import com.shengchanshixi.gongxiangyigui.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderManageService{

    List<Order> findAll();

    Page<Order> findAll(Pageable pageable);

    Order findById(String id);

    Page<Order> findByUserid(String userid,Pageable pageable);

    Page<Order> findForBugOrder(Pageable pageable);

    Page<Order> findForSendOrder(Pageable pageable);

    Page<Order> findForCheckOrder(Pageable pageable);

    Page<Order> findForBackOrder(Pageable pageable);

    List<Order> findByUserid(String userid);

    List<Order> findForBugOrder();

    List<Order> findForSendOrder();

    List<Order> findForCheckOrder();

    List<Order> findForBackOrder();

    Order dealBugOrder(String id);
    
    Order dealSendOrder(String id,String trackid);
    
    Order checkClothOk(String id);

    Order checkClothBad(String id);

    Order checkClothGone(String id);
    
    Order dealBackOrder(String id);

    Order add(Order order);

    List<Order> searchByKey(String key,List<Order> orders);

    //退款

}
