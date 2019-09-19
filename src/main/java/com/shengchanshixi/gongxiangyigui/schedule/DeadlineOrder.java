package com.shengchanshixi.gongxiangyigui.schedule;

import com.shengchanshixi.gongxiangyigui.dao.OrderDao;
import com.shengchanshixi.gongxiangyigui.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeadlineOrder {
    @Autowired
    private OrderDao orderDao;

    //三分钟检查一次订单是否有逾期
    @Scheduled(fixedRate = 1000*60*3)
    public void updateOrder(){
        System.out.println("检查订单是否逾期");
        List<Order> orders=orderDao.findAll();
        for (Order order:orders
             ) {
            if (null==order.getBacktrack()&&null!=order.getTrackid())
            {
                long backTimeMillis=order.getBacktime()*24*3600*1000;
                if(order.getOrdertime().getTime()+backTimeMillis>System.currentTimeMillis()){
                    order.setStatus("异常");
                    order.setBugsta("逾期");
                }
            }

        }

    }
}
