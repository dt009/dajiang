package com.dajiang.app.business.service;

import com.dajiang.app.business.po.dmo.Comment;

public interface CommentService {
    Comment selectByPrimaryKey(Integer commentId);

    int deleteByPrimaryKey(Integer commentId);

    int updateByPrimaryKeySelective(Comment record);

    int insertSelective(Comment record);
}