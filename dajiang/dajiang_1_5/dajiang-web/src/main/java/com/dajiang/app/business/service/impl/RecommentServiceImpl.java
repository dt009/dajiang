package com.dajiang.app.business.service.impl;

import com.dajiang.app.business.dao.RecommentDAO;
import com.dajiang.app.business.po.dmo.Recomment;
import com.dajiang.app.business.po.resp.RecommentRespDTO;
import com.dajiang.app.business.service.RecommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("recommentServiceImpl")
@Scope("singleton")
public class RecommentServiceImpl implements RecommentService {
    private static final Logger logger = LoggerFactory.getLogger(RecommentServiceImpl.class);

    @Autowired
    private RecommentDAO recommentDAO;

    @Override
    public Recomment selectByPrimaryKey(Integer recommentId) {
        return this.recommentDAO.selectByPrimaryKey(recommentId);
    }


    @Override
    public List<RecommentRespDTO> selectShowList() {
        return this.recommentDAO.selectShowList();
    }

    @Override
    public int deleteByPrimaryKey(Integer recommentId) {
        return this.recommentDAO.deleteByPrimaryKey(recommentId);
    }

    @Override
    public int updateByPrimaryKeySelective(Recomment record) {
        return this.recommentDAO.updateByPrimaryKeySelective(record);
    }

    @Override
    public int insertSelective(Recomment record) {
        return this.recommentDAO.insertSelective(record);
    }
}