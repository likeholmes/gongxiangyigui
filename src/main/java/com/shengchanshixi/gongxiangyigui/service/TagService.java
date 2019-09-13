package com.shengchanshixi.gongxiangyigui.service;

import com.shengchanshixi.gongxiangyigui.entity.Tag;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface TagService {

    List<Tag> findAllList();

    List<Tag> findBySort(String sort);

    void delete(String tag);

    Tag add(Tag tag);

    List<Tag> findAllAscByCnt();

    Tag collectOrSearchTag(String tag);

    Tag uncollectTag(String tag);

}
