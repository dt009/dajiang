package com.dajiang.app.base.service.impl;

import com.dajiang.app.base.dao.RegionDAO;
import com.dajiang.app.base.po.dmo.RegionDTO;
import com.dajiang.app.base.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Joe on 2017/9/23.
 */
@Service("regionServiceImpl")
@Scope("singleton")
public class RegionServiceImpl implements RegionService {


    @Autowired
    private RegionDAO regionDAO;

    @Override
    public List<RegionDTO> selectByPid(Integer i) {
        return regionDAO.selectByPid(i);
    }
}
