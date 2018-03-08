package com.dajiang.app.base.service;

import com.dajiang.app.base.po.dmo.FuncDTO;

import java.util.List;

public interface FuncService {
    int insertFunc(FuncDTO var1);

    FuncDTO selectById(Integer var1);

    List<String> selectUserRoleFuncListByUserId(String userId);

    List<FuncDTO> selectSupserAdminAllMenu();

    List<FuncDTO> selectAllMenuByUserId(String var1);

    List<String> selectAllFuncList();
}