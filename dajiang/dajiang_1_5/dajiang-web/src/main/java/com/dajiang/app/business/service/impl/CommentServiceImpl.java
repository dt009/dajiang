package com.dajiang.app.business.service.impl;

import com.dajiang.app.business.dao.CommentDAO;
import com.dajiang.app.business.po.dmo.Comment;
import com.dajiang.app.business.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    private static final Logger logger = LoggerFactory.getLogger(CommentServiceImpl.class);

    @Autowired
    private CommentDAO commentDAO;

    @Override
    public Comment selectByPrimaryKey(Integer commentId) {
        return this.commentDAO.selectByPrimaryKey(commentId);
    }

    @Override
    public int deleteByPrimaryKey(Integer commentId) {
        return this.commentDAO.deleteByPrimaryKey(commentId);
    }

    @Override
    public int updateByPrimaryKeySelective(Comment record) {
        return this.commentDAO.updateByPrimaryKeySelective(record);
    }

    @Override
    public int insertSelective(Comment record) {
        return this.commentDAO.insertSelective(record);
    }
}