/* github.com/zhouwd */
package com.dajiang.app.business.dao;

import com.dajiang.app.business.po.dmo.Comment;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.type.JdbcType;

/**
 * 本文件由 github.com/zhouwd/mybatis-generator-core 自动生成
 *
 * @author zhouwd code generator
 */
public interface CommentDAO {
    /**
     * 根据主键删除数据库的记录
     *
     * @param commentId
     */
    @Delete({
            "delete from t_comment",
            "where comment_id = #{commentId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer commentId);

    /**
     * 动态字段,写入数据库记录
     *
     * @param record
     */
    @InsertProvider(type = CommentSqlProvider.class, method = "insertSelective")
    int insertSelective(Comment record);

    /**
     * 根据指定主键获取一条数据库记录
     *
     * @param commentId
     */
    @Select({
            "select",
            "comment_id, product_id, user_id, comment_rank, comment_content, comment_insertDT",
            "from t_comment",
            "where comment_id = #{commentId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "comment_id", property = "commentId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "product_id", property = "productId", jdbcType = JdbcType.INTEGER),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.BIGINT),
            @Result(column = "comment_rank", property = "commentRank", jdbcType = JdbcType.INTEGER),
            @Result(column = "comment_content", property = "commentContent", jdbcType = JdbcType.VARCHAR),
            @Result(column = "comment_insertDT", property = "commentInsertdt", jdbcType = JdbcType.TIMESTAMP)
    })
    Comment selectByPrimaryKey(Integer commentId);

    /**
     * 动态字段,根据主键来更新符合条件的数据库记录
     *
     * @param record
     */
    @UpdateProvider(type = CommentSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Comment record);

    /**
     * 根据主键来更新符合条件的数据库记录
     *
     * @param record
     */
    @Update({
            "update t_comment",
            "set product_id = #{productId,jdbcType=INTEGER},",
            "user_id = #{userId,jdbcType=BIGINT},",
            "comment_rank = #{commentRank,jdbcType=INTEGER},",
            "comment_content = #{commentContent,jdbcType=VARCHAR},",
            "comment_insertDT = #{commentInsertdt,jdbcType=TIMESTAMP}",
            "where comment_id = #{commentId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Comment record);

    class CommentSqlProvider {

        /**
         * 动态字段,写入数据库记录
         *
         * @param record
         */
        public String insertSelective(Comment record) {
            SQL sql = new SQL();
            sql.INSERT_INTO("t_comment");

            if (record.getCommentId() != null) {
                sql.VALUES("comment_id", "#{commentId,jdbcType=INTEGER}");
            }

            if (record.getProductId() != null) {
                sql.VALUES("product_id", "#{productId,jdbcType=INTEGER}");
            }

            if (record.getUserId() != null) {
                sql.VALUES("user_id", "#{userId,jdbcType=BIGINT}");
            }

            if (record.getCommentRank() != null) {
                sql.VALUES("comment_rank", "#{commentRank,jdbcType=INTEGER}");
            }

            if (record.getCommentContent() != null) {
                sql.VALUES("comment_content", "#{commentContent,jdbcType=VARCHAR}");
            }

            if (record.getCommentInsertdt() != null) {
                sql.VALUES("comment_insertDT", "#{commentInsertdt,jdbcType=TIMESTAMP}");
            }

            return sql.toString();
        }

        /**
         * 动态字段,根据主键来更新符合条件的数据库记录
         *
         * @param record
         */
        public String updateByPrimaryKeySelective(Comment record) {
            SQL sql = new SQL();
            sql.UPDATE("t_comment");

            if (record.getProductId() != null) {
                sql.SET("product_id = #{productId,jdbcType=INTEGER}");
            }

            if (record.getUserId() != null) {
                sql.SET("user_id = #{userId,jdbcType=BIGINT}");
            }

            if (record.getCommentRank() != null) {
                sql.SET("comment_rank = #{commentRank,jdbcType=INTEGER}");
            }

            if (record.getCommentContent() != null) {
                sql.SET("comment_content = #{commentContent,jdbcType=VARCHAR}");
            }

            if (record.getCommentInsertdt() != null) {
                sql.SET("comment_insertDT = #{commentInsertdt,jdbcType=TIMESTAMP}");
            }

            sql.WHERE("comment_id = #{commentId,jdbcType=INTEGER}");

            return sql.toString();
        }
    }
}