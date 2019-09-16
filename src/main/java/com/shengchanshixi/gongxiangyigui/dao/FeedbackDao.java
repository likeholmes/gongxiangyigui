package com.shengchanshixi.gongxiangyigui.dao;

import com.shengchanshixi.gongxiangyigui.entity.Feedback;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface FeedbackDao extends JpaRepository<Feedback,Long>{

    @Transactional
    @Query(value = "delete from feedback_list where id=?1 ", nativeQuery = true)
    @Modifying
    void deleteById(int id);

    @Transactional
    @Query(value = "delete from feedback_list where userid=?1 ", nativeQuery = true)
    @Modifying
    void deleteByUserid(String userid);

    Page<Feedback> findByUserid(String userid,Pageable pageable);

    Page<Feedback> findBySort(String sort,Pageable pageable);

    List<Feedback> findByUserid(String userid);

    List<Feedback> findBySort(String sort);

    Feedback findById(int id);

    @Transactional
    @Query(value = "select * from feedback_list where userid LIKE ?1 or sort LIKE ?1", nativeQuery = true)
    @Modifying
    List<Feedback> findByUseridLikeOrSortLike(String key);

}
