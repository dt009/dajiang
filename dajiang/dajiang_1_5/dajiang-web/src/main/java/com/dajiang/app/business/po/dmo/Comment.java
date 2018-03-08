/* github.com/zhouwd */
package com.dajiang.app.business.po.dmo;

import com.dajiang.app.base.po.dmo.BaseDTO;

import java.util.Date;

/**
 * 评论 t_comment
 *
 * @author zhouwd code generator
 */
public class Comment extends BaseDTO {
    private Integer commentId;

    private Integer productId;

    private Long userId;

    /**
     * 打分
     */
    private Integer commentRank;

    private String commentContent;

    private Date commentInsertdt;

    /**
     * 获取 t_comment.comment_id
     *
     * @return t_comment.comment_id
     */
    public Integer getCommentId() {
        return commentId;
    }

    /**
     * 设置 t_comment.comment_id
     *
     * @param commentId t_comment.comment_id
     */
    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    /**
     * 获取 t_comment.product_id
     *
     * @return t_comment.product_id
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 设置 t_comment.product_id
     *
     * @param productId t_comment.product_id
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * 获取 t_comment.user_id
     *
     * @return t_comment.user_id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置 t_comment.user_id
     *
     * @param userId t_comment.user_id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取 打分 t_comment.comment_rank
     *
     * @return 打分
     */
    public Integer getCommentRank() {
        return commentRank;
    }

    /**
     * 设置 打分 t_comment.comment_rank
     *
     * @param commentRank 打分
     */
    public void setCommentRank(Integer commentRank) {
        this.commentRank = commentRank;
    }

    /**
     * 获取 t_comment.comment_content
     *
     * @return t_comment.comment_content
     */
    public String getCommentContent() {
        return commentContent;
    }

    /**
     * 设置 t_comment.comment_content
     *
     * @param commentContent t_comment.comment_content
     */
    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }

    /**
     * 获取 t_comment.comment_insertDT
     *
     * @return t_comment.comment_insertDT
     */
    public Date getCommentInsertdt() {
        return commentInsertdt;
    }

    /**
     * 设置 t_comment.comment_insertDT
     *
     * @param commentInsertdt t_comment.comment_insertDT
     */
    public void setCommentInsertdt(Date commentInsertdt) {
        this.commentInsertdt = commentInsertdt;
    }
}