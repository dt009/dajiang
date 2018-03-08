package com.dajiang.app.base.service.impl;

import com.dajiang.app.base.dao.FuncDAO;
import com.dajiang.app.base.po.dmo.FuncDTO;
import com.dajiang.app.base.service.FuncService;
import com.dajiang.app.common.exception.BaseException;
import com.dajiang.app.common.util.ExceptionType;
import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.*;

@Scope("singleton")
@Service("funcServiceImpl")
public class FuncServiceImpl implements FuncService {
    private static final Logger logger = LoggerFactory.getLogger(FuncServiceImpl.class);
    @Autowired
    private FuncDAO funcDAO;

    public FuncServiceImpl() {
    }

    @Override
    public int insertFunc(FuncDTO record) {
        if (logger.isDebugEnabled()) {
            logger.debug("insertFunc(FuncDTO) - start");
        }

        if (null != record) {
            this.funcDAO.insertFuncDTO(record);
            if (logger.isDebugEnabled()) {
                logger.debug("insertFunc(FuncDTO) - end");
            }

            return record.getId().intValue();
        } else {
            throw new BaseException(ExceptionType.Business_Insert, "insertFunc插入的对象不能为空");
        }
    }

    @Override
    public FuncDTO selectById(Integer id) {
        if (logger.isDebugEnabled()) {
            logger.debug("selectById(Integer) - start");
        }

        if (null != id) {
            FuncDTO func = this.funcDAO.selectById(id);
            if (logger.isDebugEnabled()) {
                logger.debug("selectById(Integer) - end");
            }

            return func;
        } else {
            throw new BaseException(ExceptionType.Business_Query, "selectById查询的id不能为空");
        }
    }


    private boolean isAllSelected(List<FuncDTO> funcList, List<FuncDTO> validList) {
        for (int i = 0; i < validList.size(); ++i) {
            boolean isHave = false;

            for (int j = 0; j < funcList.size(); ++j) {
                if (((FuncDTO) validList.get(i)).getId().equals(((FuncDTO) funcList.get(j)).getId())) {
                    isHave = true;
                    break;
                }
            }

            if (!isHave) {
                return false;
            }
        }

        return true;
    }

    @Override
    public List<FuncDTO> selectAllMenuByUserId(String userId) {
        if (StringUtils.isEmpty(userId)) {
            throw new BaseException(ExceptionType.Business_Query, "selectAllMenuByUserId查询的用户登录账号不能为空");
        } else {
            List firstFuncList = this.funcDAO.selectAllFunByUserIdFunType(userId, "FIRST_FUNC");
            List secondFuncList = this.funcDAO.selectAllFunByUserIdFunType(userId, "SECOND_FUNC");
            List thirdFuncList = this.funcDAO.selectAllFunByUserIdFunType(userId, "THIRD_FUNC");
            this.funcInfo(firstFuncList, secondFuncList, thirdFuncList);
            return firstFuncList;
        }
    }

    @Override
    public List<String> selectAllFuncList() {
        List strList = this.funcDAO.selectAllFunName();
        return strList;
    }

    @Override
    public List<String> selectUserRoleFuncListByUserId(String userId) {
        return null;
    }

    @Override
    public List<FuncDTO> selectSupserAdminAllMenu() {
        return null;
    }

    private void createButtonInfo(Map<Integer, List<FuncDTO>> buttonParentMap, List<FuncDTO> firstFuncList, List<FuncDTO> secondFuncList, List<FuncDTO> thirdFuncList) {
        try {
            Iterator e = firstFuncList.iterator();

            FuncDTO next;
            label82:
            while (e.hasNext()) {
                next = (FuncDTO) e.next();
                HashSet secondSet = new HashSet();
                Iterator secondList = secondFuncList.iterator();

                while (true) {
                    FuncDTO secondFunc;
                    do {
                        do {
                            if (!secondList.hasNext()) {
                                ArrayList secondList1 = new ArrayList();
                                secondList1.addAll(secondSet);
                                Collections.sort(secondList1, new BeanComparator("displaySequence"));
                                next.setSubFuncEntrys(secondList1);
                                next.setChildren(secondList1);
                                next.setButtonList((List) buttonParentMap.get(next.getId()));
                                continue label82;
                            }

                            secondFunc = (FuncDTO) secondList.next();
                        } while (!secondFunc.getParentId().equals(next.getId()));

                        HashSet thirdSet = new HashSet();
                        Iterator thirdList = thirdFuncList.iterator();

                        while (thirdList.hasNext()) {
                            FuncDTO thirdFunc = (FuncDTO) thirdList.next();
                            if (thirdFunc.getParentId().equals(secondFunc.getId())) {
                                thirdFunc.setButtonList((List) buttonParentMap.get(thirdFunc.getId()));
                                if (thirdFunc.getButtonList() != null && thirdFunc.getButtonList().size() > 0) {
                                    thirdSet.add(thirdFunc);
                                }
                            }
                        }

                        ArrayList thirdList1 = new ArrayList();
                        thirdList1.addAll(thirdSet);
                        Collections.sort(thirdList1, new BeanComparator("displaySequence"));
                        secondFunc.setSubFuncEntrys(thirdList1);
                        secondFunc.setChildren(thirdList1);
                        secondFunc.setButtonList((List) buttonParentMap.get(secondFunc.getId()));
                    }
                    while ((secondFunc.getChildren() == null || secondFunc.getChildren().size() <= 0) && (secondFunc.getButtonList() == null || secondFunc.getButtonList().size() <= 0));

                    secondSet.add(secondFunc);
                }
            }

            e = firstFuncList.iterator();

            while (true) {
                do {
                    do {
                        if (!e.hasNext()) {
                            return;
                        }

                        next = (FuncDTO) e.next();
                    } while (next.getChildren() != null && next.getChildren().size() != 0);
                } while (next.getButtonList() != null && next.getButtonList().size() != 0);

                e.remove();
            }
        } catch (Exception var13) {
            logger.error("create button fail.", var13);
            throw var13;
        }
    }

    private void funcInfo(List<FuncDTO> firstFuncList, List<FuncDTO> secondFuncList, List<FuncDTO> thirdFuncList) {
        Iterator var4 = firstFuncList.iterator();

        while (var4.hasNext()) {
            FuncDTO firstFunc = (FuncDTO) var4.next();
            HashSet secondSet = new HashSet();
            Iterator secondList = secondFuncList.iterator();

            while (secondList.hasNext()) {
                FuncDTO secondFunc = (FuncDTO) secondList.next();
                if (secondFunc.getParentId().equals(firstFunc.getId())) {
                    secondSet.add(secondFunc);
                }

                HashSet thirdSet = new HashSet();
                Iterator thirdList = thirdFuncList.iterator();

                while (thirdList.hasNext()) {
                    FuncDTO thirdFunc = (FuncDTO) thirdList.next();
                    if (thirdFunc.getParentId().equals(secondFunc.getId())) {
                        thirdSet.add(thirdFunc);
                    }
                }

                ArrayList thirdList1 = new ArrayList();
                thirdList1.addAll(thirdSet);
                Collections.sort(thirdList1, new BeanComparator("displaySequence"));
                secondFunc.setSubFuncEntrys(thirdList1);
                secondFunc.setChildren(thirdList1);
            }

            ArrayList secondList1 = new ArrayList();
            secondList1.addAll(secondSet);
            Collections.sort(secondList1, new BeanComparator("displaySequence"));
            firstFunc.setSubFuncEntrys(secondList1);
            firstFunc.setChildren(secondList1);
        }

    }
}