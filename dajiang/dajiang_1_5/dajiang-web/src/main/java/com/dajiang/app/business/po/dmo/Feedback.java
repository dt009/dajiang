/* github.com/zhouwd */
package com.dajiang.app.business.po.dmo;

import com.dajiang.app.base.po.dmo.BaseDTO;

import java.util.Date;

/**
 * 用户反馈 t_feedback
 *
 * @author zhouwd code generator
 */
public class Feedback extends BaseDTO {

    private Integer feedbackId;

    private String feedbackContent;

    /**
     * 反馈用户id
     */
    private Long userId;

    /**
     * 反馈种类：1、系统问题；2：上架产品；3、其他问题；
     */
    private Integer feedbackType;

    /**
     * 发生时间
     */
    private Date feedbackInsertdt;

    /**
     * 回复
     */
    private String feedbackReply;

    /**
     * 回复时间
     */
    private Date feedbackReplyInsertdt;

    /**
     * 获取 t_feedback.feedback_id
     *
     * @return t_feedback.feedback_id
     */
    public Integer getFeedbackId() {
        return feedbackId;
    }

    /**
     * 设置 t_feedback.feedback_id
     *
     * @param feedbackId t_feedback.feedback_id
     */
    public void setFeedbackId(Integer feedbackId) {
        this.feedbackId = feedbackId;
    }

    /**
     * 获取 t_feedback.feedback_content
     *
     * @return t_feedback.feedback_content
     */
    public String getFeedbackContent() {
        return feedbackContent;
    }

    /**
     * 设置 t_feedback.feedback_content
     *
     * @param feedbackContent t_feedback.feedback_content
     */
    public void setFeedbackContent(String feedbackContent) {
        this.feedbackContent = feedbackContent == null ? null : feedbackContent.trim();
    }

    /**
     * 获取 反馈用户id t_feedback.user_id
     *
     * @return 反馈用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置 反馈用户id t_feedback.user_id
     *
     * @param userId 反馈用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取 反馈种类：1、系统问题；2：上架产品；3、其他问题； t_feedback.feedback_type
     *
     * @return 反馈种类：1、系统问题；2：上架产品；3、其他问题；
     */
    public Integer getFeedbackType() {
        return feedbackType;
    }

    /**
     * 设置 反馈种类：1、系统问题；2：上架产品；3、其他问题； t_feedback.feedback_type
     *
     * @param feedbackType 反馈种类：1、系统问题；2：上架产品；3、其他问题；
     */
    public void setFeedbackType(Integer feedbackType) {
        this.feedbackType = feedbackType;
    }

    /**
     * 获取 发生时间 t_feedback.feedback_insertDT
     *
     * @return 发生时间
     */
    public Date getFeedbackInsertdt() {
        return feedbackInsertdt;
    }

    /**
     * 设置 发生时间 t_feedback.feedback_insertDT
     *
     * @param feedbackInsertdt 发生时间
     */
    public void setFeedbackInsertdt(Date feedbackInsertdt) {
        this.feedbackInsertdt = feedbackInsertdt;
    }

    /**
     * 获取 回复 t_feedback.feedback_reply
     *
     * @return 回复
     */
    public String getFeedbackReply() {
        return feedbackReply;
    }

    /**
     * 设置 回复 t_feedback.feedback_reply
     *
     * @param feedbackReply 回复
     */
    public void setFeedbackReply(String feedbackReply) {
        this.feedbackReply = feedbackReply == null ? null : feedbackReply.trim();
    }

    /**
     * 获取 回复时间 t_feedback.feedback_reply_insertDT
     *
     * @return 回复时间
     */
    public Date getFeedbackReplyInsertdt() {
        return feedbackReplyInsertdt;
    }

    /**
     * 设置 回复时间 t_feedback.feedback_reply_insertDT
     *
     * @param feedbackReplyInsertdt 回复时间
     */
    public void setFeedbackReplyInsertdt(Date feedbackReplyInsertdt) {
        this.feedbackReplyInsertdt = feedbackReplyInsertdt;
    }
}