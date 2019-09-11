package com.shengchanshixi.gongxiangyigui.service.impl;

import com.shengchanshixi.gongxiangyigui.dao.ComPicDao;
import com.shengchanshixi.gongxiangyigui.dao.CommentDao;
import com.shengchanshixi.gongxiangyigui.entity.ComPic;
import com.shengchanshixi.gongxiangyigui.entity.Comment;
import com.shengchanshixi.gongxiangyigui.service.ComPicService;
import com.shengchanshixi.gongxiangyigui.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private ComPicDao comPicDao;

    @Override
    public void delete(int id) {
        /**
         * 先删除评论所有的图片
         */
        comPicDao.deleteByComid(id);
        /**
         * 删除评论
         */
        commentDao.deleteById(id);
    }

    @Override
    public void deleteByUserid(String userid) {
        List<Comment> comments=commentDao.findByUserid(userid);
        for (Comment comment:comments
             ) {
            delete(comment.getId());
        }
    }
}
