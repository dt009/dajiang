package com.dajiang.app.business.service;

import com.dajiang.app.business.po.dmo.Cko;
import com.dajiang.app.business.po.req.CKOQueryReqDTO;
import com.dajiang.app.business.po.req.CkoUpdateReqDTO;
import com.dajiang.app.business.po.resp.CkoBaseInfoRespDTO;
import com.dajiang.app.business.po.resp.CkoRespDTO;
import com.dajiang.app.business.po.resp.CkoUpdateInitRespDTO;
import com.dajiang.app.common.context.UserSession;
import com.dajiang.app.common.page.PageReqBean;
import com.dajiang.app.common.page.PageRespBean;

public interface CkoService {
    Cko selectByPrimaryKey(Integer ckoKey);

    CkoBaseInfoRespDTO selectBaseInfoByPrimaryKey(Integer ckoId);

    PageRespBean<CkoRespDTO> selectForMore(PageReqBean<CKOQueryReqDTO> reqDTO);

    CkoUpdateInitRespDTO selectByUserId(UserSession userSession);

    int deleteByPrimaryKey(Integer ckoKey);

    int updateByPrimaryKeySelective(Cko record);

    int insertSelective(Cko record);

    int updateByUserId(UserSession userSession, CkoUpdateReqDTO reqDTO);

}