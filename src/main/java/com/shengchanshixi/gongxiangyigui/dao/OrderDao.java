package com.shengchanshixi.gongxiangyigui.dao;

import com.shengchanshixi.gongxiangyigui.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDao extends JpaRepository<Order,Long> {

    Order findById(String id);

    List<Order> findByUserid(String userid);

    Page<Order> findByUserid(String userid, Pageable pageable);

    Page<Order> findByStatusAndBugdeal(String status,String bugdeal,Pageable pageable);

    Page<Order> findByDelivtimeIsNull(Pageable pageable);

    Page<Order> findByDelivtimeIsNotNullAndRecevtimeIsNullAndBugstaIsNull(Pageable pageable);

    Page<Order> findByBacktrackIsNotNullAndBugstaIsNull(Pageable pageable);

    List<Order> findByStatusAndBugdeal(String status,String bugdeal);

    List<Order> findByDelivtimeIsNull();

    List<Order> findByDelivtimeIsNotNullAndRecevtimeIsNullAndBugstaIsNull();

    List<Order> findByBacktrackIsNotNullAndBugstaIsNull();

}
