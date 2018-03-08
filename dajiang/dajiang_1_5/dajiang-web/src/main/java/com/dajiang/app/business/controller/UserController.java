package com.dajiang.app.business.controller;

import com.dajiang.app.base.controller.BaseController;
import com.dajiang.app.base.po.dmo.ResponseBaseDTO;
import com.dajiang.app.base.po.dmo.User;
import com.dajiang.app.business.po.dmo.CkoApply;
import com.dajiang.app.business.po.dmo.Feedback;
import com.dajiang.app.business.po.dmo.VerificationLog;
import com.dajiang.app.business.po.req.*;
import com.dajiang.app.business.po.resp.CollectionRespDTO;
import com.dajiang.app.business.service.*;
import com.dajiang.app.common.exception.BaseException;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Joe on 2017/9/11.
 */
@RestController
public class UserController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    @Autowired
    @Qualifier("verificationLogServiceImpl")
    private VerificationLogService verificationLogService;

    @Autowired
    @Qualifier("ckoServiceImpl")
    private CkoService ckoService;

    @Autowired
    @Qualifier("ckoApplyServiceImpl")
    private CkoApplyService ckoApplyService;

    @Autowired
    @Qualifier("professionalApplyServiceImpl")
    private ProfessionalApplyService professionalApplyService;

    @Autowired
    @Qualifier("feedbackServiceImpl")
    private FeedbackService feedbackService;


    @Autowired
    @Qualifier("collectionServiceImpl")
    private CollectionService collectionService;

    @Autowired
    @Qualifier("messageServiceImpl")
    private MessageService messageService;

    /**
     * 用户注册
     */
    @RequestMapping("/public/user/register")
    @ResponseBody
    public ResponseBaseDTO<Object> register(@RequestBody RegisterReqDTO reqDTO) {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, userService.register(reqDTO));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

    /**
     * 发送验证码
     */
    @RequestMapping("/public/user/sendVerificationCode")
    @ResponseBody
    public ResponseBaseDTO<Integer> sendVerificationCode(@RequestBody VerificationReqDTO reqDTO) {
        try {
            String random = RandomStringUtils.random(6, "0123456789");
            VerificationLog record = new VerificationLog();
            record.setUserPhone(reqDTO.getUserPhone());
            record.setVerificationCode(random);
            record.setUseType(reqDTO.getUseType());
            verificationLogService.insertLog(record);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, "短信发送成功,请查看手机。");
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

    /**
     * 忘记密码--重置密码
     */
    @RequestMapping("/public/user/resetPassword")
    @ResponseBody
    public ResponseBaseDTO<Integer> resetPassword(@RequestBody PasswordResetReqDTO reqDTO) {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, "密码更新成功。", userService.resetPassword(reqDTO));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }


    /**
     * 修改密码
     */
    @RequestMapping("/private/user/editPassword")
    @ResponseBody
    public ResponseBaseDTO<Integer> editPassword(@RequestBody PasswordEditReqDTO reqDTO) {
        try {

            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, "密码更新成功。", userService.editPassword(getUserSession(), reqDTO));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }


    /**
     * 用户反馈
     */
    @RequestMapping("/private/user/feedback")
    @ResponseBody
    public ResponseBaseDTO<Object> feedback(@RequestBody Feedback reqDTO) {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, "提交成功。", feedbackService.insertSelective(getUserSession(), reqDTO));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }


    /**
     * 初始化用户信息
     */
    @RequestMapping("/private/user/initUserInfo")
    @ResponseBody
    public ResponseBaseDTO<User> initUserInfo() {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, "查询成功。", userService.selectBaseInfo(getUserSession()));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

    /**
     * 更新用户信息
     */
    @PostMapping("/private/user/updateUserInfo")
    @ResponseBody
    public ResponseBaseDTO<Object> updateUserInfo(@RequestBody User user) {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, userService.updateByPrimaryKey(getUserSession(), user));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

    /**
     * 更新用户的银行账户信息
     *
     * @return
     */
    @PostMapping("/private/user/updateUserBank")
    @ResponseBody
    public ResponseBaseDTO<Object> updateUserBank(@RequestBody UserBankReqDTO userBankReqDTO) {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, userService.updateUserBank(getUserSession(), userBankReqDTO));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

    /**
     * 查看是否已经提交CKO申请
     */
    @PostMapping("/private/user/initBeCKO")
    @ResponseBody
    public ResponseBaseDTO<Object> initBeCKO() {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, ckoApplyService.selectByUserId(getUserSession()));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

    /**
     * 知识经纪人验证提交
     */
    @PostMapping("/private/user/sendBeCKOVertif")
    @ResponseBody
    public ResponseBaseDTO<Object> sendBeCKOVertif(@RequestBody CkoApply reqDTO) {
        try {

            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, "提交成功。", ckoApplyService.insertSelective(getUserSession(), reqDTO));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, "提交失败。");
        }
    }

    /**
     * 初始化cko的基本信息
     */
    @PostMapping("/private/user/initCKO")
    @ResponseBody
    public ResponseBaseDTO<Object> initCKO() {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, ckoService.selectByUserId(getUserSession()));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

    /**
     * 更新cko基本信息
     */
    @PostMapping("/private/user/updateCKO")
    @ResponseBody
    public ResponseBaseDTO<Object> updateCKO(@RequestBody CkoUpdateReqDTO reqDTO) {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, ckoService.updateByUserId(getUserSession(), reqDTO));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }


    /**
     * 判断大匠验证申请是否提交
     */
    @PostMapping("/private/user/initBeProfess")
    @ResponseBody
    public ResponseBaseDTO<Object> initBeProfess() {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, professionalApplyService.selectByUserId(getUserSession()));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

    /**
     * 大匠验证请求提交
     */
    @PostMapping("/private/user/sendBeProfVerif")
    @ResponseBody
    public ResponseBaseDTO<Object> sendBeProfVerif(@RequestBody ProfessionalApplyReqDTO reqDTO) {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, professionalApplyService.insertSelective(getUserSession(), reqDTO));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

    /**
     * 查看用户的收藏
     */
    @PostMapping("/private/user/initCollection")
    @ResponseBody
    public ResponseBaseDTO<List<CollectionRespDTO>> initCollection() {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, collectionService.selectByUserId(getUserSession()));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

    /**
     * 查看用户未读消息总数
     */
    @PostMapping("/private/user/waitMessageTotal")
    @ResponseBody
    public ResponseBaseDTO<Integer> waitMessageTotal() {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, messageService.selectMessageTotal(getUserSession()));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }


    /**
     * 根据收藏ID查看大匠详情
     */
    @PostMapping("/private/user/queryDetail/{collectionId}")
    @ResponseBody
    public ResponseBaseDTO<Object> queryDetail(@PathVariable("collectionId") Integer collectionId) {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, collectionService.selectByPrimaryKey(getUserSession(), collectionId));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

    /**
     * 收藏大匠
     */
    @PostMapping("/private/user/saveCollection/{professionalId}")
    @ResponseBody
    public ResponseBaseDTO<Object> saveCollection(@PathVariable("professionalId") Integer professionalId) {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, collectionService.insertSelective(getUserSession(), professionalId));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

    /**
     * 根据收藏ID进行删除操作
     */
    @PostMapping("/private/user/deleteCollection/{professionalId}")
    @ResponseBody
    public ResponseBaseDTO<Object> deleteCollection(@PathVariable("professionalId") Integer professionalId) {
        if (logger.isDebugEnabled()) {
            logger.debug("deleteCollection(collectionId = [" + professionalId + "]) -start");
        }
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, collectionService.deleteByPrimaryKey(getUserSession(), professionalId));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

}
