package com.shengchanshixi.gongxiangyigui.service.impl;

import com.shengchanshixi.gongxiangyigui.dao.OrderDao;
import com.shengchanshixi.gongxiangyigui.entity.Order;
import com.shengchanshixi.gongxiangyigui.service.OrderManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderManageServiceImpl implements OrderManageService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Order> findAllList() {
        return orderDao.findAll();
    }

    @Override
    public Page<Order> findAllPage(Pageable pageable) {
        return orderDao.findAll(pageable);
    }

    @Override
    public Page<Order> findByUserid(String userid,Pageable pageable) {
        return orderDao.findByUserid(userid,pageable);
    }

    @Override
    public Page<Order> findForBugOrder(Pageable pageable) {
        return  orderDao.findByStatusAndBugdeal("异常","未处理",pageable);
    }

    @Override
    public Page<Order> findForSendOrder(Pageable pageable) {
        return orderDao.findByDelivtimeIsNull(pageable);
    }

    @Override
    public Page<Order> findForCheckOrder(Pageable pageable) {
        return orderDao.findByBacktrackIsNotNullAndBugstaIsNull(pageable);
    }

    @Override
    public Page<Order> findForBackOrder(Pageable pageable) {
        return orderDao.findByDelivtimeIsNotNullAndRecevtimeIsNullAndBugstaIsNull(pageable);
    }

    @Override
    public List<Order> findByUserid(String userid) {
        return orderDao.findByUserid(userid);
    }

    @Override
    public List<Order> findForBugOrder() {
        return orderDao.findByStatusAndBugdeal("异常","未处理");
    }

    @Override
    public List<Order> findForSendOrder() {
        return orderDao.findByDelivtimeIsNull();
    }

    @Override
    public List<Order> findForCheckOrder() {
        return orderDao.findByBacktrackIsNotNullAndBugstaIsNull();
    }

    @Override
    public List<Order> findForBackOrder() {
        return orderDao.findByDelivtimeIsNotNullAndRecevtimeIsNullAndBugstaIsNull();
    }

    //传递的参数类型待定
    @Override
    public Order ProcessBugOrder(Order bugorder) {
        Order old=orderDao.findById(bugorder.getId());
        old.setBugdeal("已处理");
        return orderDao.save(old);
    }

    @Override
    public Order ProcessSendOrder(Order sendorder) {
        Order old=orderDao.findById(sendorder.getId());
        java.sql.Timestamp now=new java.sql.Timestamp(System.currentTimeMillis());
        old.setDelivtime(now);
        old.setTrackid(sendorder.getTrackid());
        return orderDao.save(old);
    }

    @Override
    public Order ProcessCheckOrder(Order checkorder) {
        //页面中三个按钮，通过设置BugSta正常,异常状态设为通过；损坏设置BugSta异常，异常状态设为损坏；丢失设置BugSta异常，异常状态设为丢失
        Order old=orderDao.findById(checkorder.getId());
        old.setBugsta(checkorder.getBugsta());
        old.setStatus(checkorder.getStatus());
        return orderDao.save(old);
    }


    @Override
    public Order ProcessBackOrder(Order backorder) {
        //若有已逾期按钮，则有下面步骤；否则在findForBackOrder()中自动判断已逾期订单
        Order old=orderDao.findById(backorder.getId());
        long backTimeMillis=backorder.getBacktime()*24*3600*1000;
        if(backorder.getOrdertime().getTime()+backTimeMillis>System.currentTimeMillis()){
            old.setStatus("异常");
            old.setBugsta("已逾期");
        }else {
            java.sql.Timestamp now = new java.sql.Timestamp(System.currentTimeMillis());
            old.setBacktrack(backorder.getBacktrack());
            old.setRecevtime(now);
        }
        return orderDao.save(old);
    }

    @Override
    public Order add(Order order) {
        //没有安全保障
        return orderDao.save(order);
    }
}
