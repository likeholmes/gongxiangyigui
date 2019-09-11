package com.shengchanshixi.gongxiangyigui.service;

import com.shengchanshixi.gongxiangyigui.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderManageService{

    List<Order> findAllList();

    Page<Order> findAllPage(Pageable pageable);

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

    Order ProcessBugOrder(Order bugorder);
    
    Order ProcessSendOrder(Order sendorder);
    
    Order ProcessCheckOrder(Order checkorder);
    
    Order ProcessBackOrder(Order backorder);

    Order add(Order order);

    //退款

}
