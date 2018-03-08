package com.dajiang.app.base.service;

import com.dajiang.app.base.po.dmo.RegionDTO;

import java.util.List;

/**
 * Created by Joe on 2017/9/23.
 */
public interface RegionService {

    List<RegionDTO> selectByPid(Integer i);
}
