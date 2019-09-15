package com.shengchanshixi.gongxiangyigui.service.impl;

import com.shengchanshixi.gongxiangyigui.dao.OrderDao;
import com.shengchanshixi.gongxiangyigui.entity.Order;
import com.shengchanshixi.gongxiangyigui.service.OrderManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class OrderManageServiceImpl implements OrderManageService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Order> findAll() {
        return orderDao.findAll();
    }

    @Override
    public Page<Order> findAll(Pageable pageable) {
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

    //处理异常订单
    @Override
    public Order dealBugOrder(String id) {
        Order old=orderDao.findById(id);
        System.out.println(old.toString());
        if (null==old)
            return null;
        old.setBugdeal("已处理");
        return orderDao.save(old);
    }

    //处理发货订单
    @Override
    public Order dealSendOrder(String id,String trackid) {
        Order old=orderDao.findById(id);
        if (null==old)
            return null;
        java.sql.Timestamp now=new java.sql.Timestamp(System.currentTimeMillis());
        old.setDelivtime(now);
        old.setTrackid(trackid);
        return orderDao.save(old);
    }

    @Override
    public Order dealBackOrder(String id) {
        //若有已逾期按钮，则有下面步骤；否则在findForBackOrder()中自动判断已逾期订单
        Order old=orderDao.findById(id);
        if (null==old)
            return null;
        /*long backTimeMillis=backorder.getBacktime()*24*3600*1000;
        if(backorder.getOrdertime().getTime()+backTimeMillis>System.currentTimeMillis()){
            old.setStatus("异常");
            old.setBugsta("已逾期");
        }*/
        java.sql.Timestamp now = new java.sql.Timestamp(System.currentTimeMillis());
        //TODO:设置返回单号应在客户端设置
        //old.setBacktrack(id);
        old.setRecevtime(now);
        return orderDao.save(old);
    }

    //审核通过
    @Override
    public Order checkClothOk(String id) {
        Order old=orderDao.findById(id);
        if (null==old)
            return null;
        old.setStatus("正常");
        //TODO:退款
        return orderDao.save(old);
    }

    @Override
    public Order checkClothBad(String id) {
        Order old=orderDao.findById(id);
        if (null==old)
            return null;
        old.setStatus("异常");
        old.setBugsta("损坏");
        return orderDao.save(old);
    }

    @Override
    public Order checkClothGone(String id) {
        Order old=orderDao.findById(id);
        if (null==old)
            return null;
        old.setStatus("异常");
        old.setBugsta("丢失");
        return orderDao.save(old);
    }

    @Override
    public Order add(Order order) {
        //没有安全保障
        Random random=new Random();
        String orderid;
        do {
            orderid=""+(random.nextInt(20)%10+1);
            for (int i=1;i<6;i++)
                orderid+=random.nextInt(10);
        }while (orderDao.findById(orderid)!=null);
        order.setId(orderid);
        java.sql.Timestamp now = new java.sql.Timestamp(System.currentTimeMillis());
        order.setOrdertime(now);
        return orderDao.save(order);
    }

    @Override
    public Order findById(String id) {
        return orderDao.findById(id);
    }

    @Override
    public List<Order> searchByKey(String key, List<Order> orders) {
        List<Order> orderList=new ArrayList<>();
        for (Order order:orders
             ) {
            if (null!=order.getTrackid()&&order.getTrackid().contains(key)){
                orderList.add(order);
            }else if (null!=order.getBacktrack()&&order.getBacktrack().contains(key)){
                orderList.add(order);
            }else if (null!=order.getBugsta()&&order.getBugsta().contains(key)){
                orderList.add(order);
            }else if (null!=order.getId()&&order.getId().contains(key)){
                orderList.add(order);
            }else if (null!=order.getStatus()&&order.getStatus().contains(key)){
                orderList.add(order);
            }else if (null!=order.getUserid()&&order.getUserid().contains(key)){
                orderList.add(order);
            }
        }
        return orderList;
    }
}
