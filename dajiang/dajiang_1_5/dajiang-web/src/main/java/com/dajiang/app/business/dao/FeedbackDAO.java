/* github.com/zhouwd */
package com.dajiang.app.business.dao;

import com.dajiang.app.business.po.dmo.Feedback;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.type.JdbcType;

/**
 * 本文件由 github.com/zhouwd/mybatis-generator-core 自动生成
 *
 * @author zhouwd code generator
 */
public interface FeedbackDAO {
    /**
     * 根据主键删除数据库的记录
     *
     * @param feedbackId
     */
    @Delete({
            "delete from t_feedback",
            "where feedback_id = #{feedbackId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer feedbackId);

    /**
     * 动态字段,写入数据库记录
     *
     * @param record
     */
    @InsertProvider(type = FeedbackSqlProvider.class, method = "insertSelective")
    int insertSelective(Feedback record);

    /**
     * 根据指定主键获取一条数据库记录
     *
     * @param feedbackId
     */
    @Select({
            "select",
            "feedback_id, feedback_content, user_id, feedback_type, feedback_insertDT, feedback_reply, ",
            "feedback_reply_insertDT",
            "from t_feedback",
            "where feedback_id = #{feedbackId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "feedback_id", property = "feedbackId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "feedback_content", property = "feedbackContent", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.BIGINT),
            @Result(column = "feedback_type", property = "feedbackType", jdbcType = JdbcType.INTEGER),
            @Result(column = "feedback_insertDT", property = "feedbackInsertdt", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "feedback_reply", property = "feedbackReply", jdbcType = JdbcType.VARCHAR),
            @Result(column = "feedback_reply_insertDT", property = "feedbackReplyInsertdt", jdbcType = JdbcType.TIMESTAMP)
    })
    Feedback selectByPrimaryKey(Integer feedbackId);

    /**
     * 动态字段,根据主键来更新符合条件的数据库记录
     *
     * @param record
     */
    @UpdateProvider(type = FeedbackSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Feedback record);

    /**
     * 根据主键来更新符合条件的数据库记录
     *
     * @param record
     */
    @Update({
            "update t_feedback",
            "set feedback_content = #{feedbackContent,jdbcType=VARCHAR},",
            "user_id = #{userId,jdbcType=BIGINT},",
            "feedback_type = #{feedbackType,jdbcType=INTEGER},",
            "feedback_insertDT = #{feedbackInsertdt,jdbcType=TIMESTAMP},",
            "feedback_reply = #{feedbackReply,jdbcType=VARCHAR},",
            "feedback_reply_insertDT = #{feedbackReplyInsertdt,jdbcType=TIMESTAMP}",
            "where feedback_id = #{feedbackId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Feedback record);

    class FeedbackSqlProvider {

        /**
         * 动态字段,写入数据库记录
         *
         * @param record
         */
        public String insertSelective(Feedback record) {
            SQL sql = new SQL();
            sql.INSERT_INTO("t_feedback");

            if (record.getFeedbackId() != null) {
                sql.VALUES("feedback_id", "#{feedbackId,jdbcType=INTEGER}");
            }

            if (record.getFeedbackContent() != null) {
                sql.VALUES("feedback_content", "#{feedbackContent,jdbcType=VARCHAR}");
            }

            if (record.getUserId() != null) {
                sql.VALUES("user_id", "#{userId,jdbcType=BIGINT}");
            }

            if (record.getFeedbackType() != null) {
                sql.VALUES("feedback_type", "#{feedbackType,jdbcType=INTEGER}");
            }

            if (record.getFeedbackInsertdt() != null) {
                sql.VALUES("feedback_insertDT", "#{feedbackInsertdt,jdbcType=TIMESTAMP}");
            }

            if (record.getFeedbackReply() != null) {
                sql.VALUES("feedback_reply", "#{feedbackReply,jdbcType=VARCHAR}");
            }

            if (record.getFeedbackReplyInsertdt() != null) {
                sql.VALUES("feedback_reply_insertDT", "#{feedbackReplyInsertdt,jdbcType=TIMESTAMP}");
            }

            return sql.toString();
        }

        /**
         * 动态字段,根据主键来更新符合条件的数据库记录
         *
         * @param record
         */
        public String updateByPrimaryKeySelective(Feedback record) {
            SQL sql = new SQL();
            sql.UPDATE("t_feedback");

            if (record.getFeedbackContent() != null) {
                sql.SET("feedback_content = #{feedbackContent,jdbcType=VARCHAR}");
            }

            if (record.getUserId() != null) {
                sql.SET("user_id = #{userId,jdbcType=BIGINT}");
            }

            if (record.getFeedbackType() != null) {
                sql.SET("feedback_type = #{feedbackType,jdbcType=INTEGER}");
            }

            if (record.getFeedbackInsertdt() != null) {
                sql.SET("feedback_insertDT = #{feedbackInsertdt,jdbcType=TIMESTAMP}");
            }

            if (record.getFeedbackReply() != null) {
                sql.SET("feedback_reply = #{feedbackReply,jdbcType=VARCHAR}");
            }

            if (record.getFeedbackReplyInsertdt() != null) {
                sql.SET("feedback_reply_insertDT = #{feedbackReplyInsertdt,jdbcType=TIMESTAMP}");
            }

            sql.WHERE("feedback_id = #{feedbackId,jdbcType=INTEGER}");

            return sql.toString();
        }
    }
}