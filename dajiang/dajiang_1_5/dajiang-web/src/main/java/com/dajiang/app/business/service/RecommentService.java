package com.dajiang.app.business.service;

import com.dajiang.app.business.po.dmo.Recomment;
import com.dajiang.app.business.po.resp.RecommentRespDTO;

import java.util.List;

public interface RecommentService {
    Recomment selectByPrimaryKey(Integer recommentId);

    List<RecommentRespDTO> selectShowList();

    int deleteByPrimaryKey(Integer recommentId);

    int updateByPrimaryKeySelective(Recomment record);

    int insertSelective(Recomment record);
}