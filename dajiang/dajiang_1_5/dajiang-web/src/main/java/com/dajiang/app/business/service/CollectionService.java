package com.dajiang.app.business.service;

import com.dajiang.app.business.po.dmo.Collection;
import com.dajiang.app.business.po.resp.CollectionRespDTO;
import com.dajiang.app.business.po.resp.ProfessionalRespDTO;
import com.dajiang.app.common.context.UserSession;

import java.util.List;

public interface CollectionService {

    ProfessionalRespDTO selectByPrimaryKey(UserSession userSession, Integer collectionId);

    /**
     * 根据用户ID查询用户的收藏
     *
     * @param reqDTO
     * @return
     */
    List<CollectionRespDTO> selectByUserId(UserSession reqDTO);

    int deleteByPrimaryKey(UserSession userSession, Integer collectionId);

    int updateByPrimaryKeySelective(Collection record);

    int insertSelective(UserSession userSession, Integer professionalId);
}