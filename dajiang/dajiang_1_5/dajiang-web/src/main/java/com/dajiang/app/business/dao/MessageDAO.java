/* github.com/zhouwd */
package com.dajiang.app.business.dao;

import com.dajiang.app.business.po.dmo.Message;
import com.dajiang.app.business.po.req.MessageContextReqDTO;
import com.dajiang.app.business.po.resp.MessageContextDTO;
import com.dajiang.app.business.po.resp.MessageContextRespDTO;
import com.dajiang.app.business.po.resp.MessageProductRespDTO;
import com.dajiang.app.business.po.resp.MessageSenderRespDTO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * 本文件由 github.com/zhouwd/mybatis-generator-core 自动生成
 *
 * @author zhouwd code generator
 */
public interface MessageDAO {
    /**
     * 根据主键删除数据库的记录
     *
     * @param messageId
     */
    @Delete({
            "delete from t_message",
            "where message_id = #{messageId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer messageId);

    /**
     * 动态字段,写入数据库记录
     *
     * @param record
     */
    @InsertProvider(type = MessageSqlProvider.class, method = "insertSelective")
    int insertSelective(Message record);

    /**
     * 根据指定主键获取一条数据库记录
     *
     * @param messageId
     */
    @Select({
            "select",
            "message_id, received_user_id, product_id, send_user_id, message_type, message_content, ",
            "message_status, message_sendDT",
            "from t_message",
            "where message_id = #{messageId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "message_id", property = "messageId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "received_user_id", property = "receivedUserId", jdbcType = JdbcType.BIGINT),
            @Result(column = "product_id", property = "productId", jdbcType = JdbcType.INTEGER),
            @Result(column = "send_user_id", property = "sendUserId", jdbcType = JdbcType.BIGINT),
            @Result(column = "message_type", property = "messageType", jdbcType = JdbcType.INTEGER),
            @Result(column = "message_content", property = "messageContent", jdbcType = JdbcType.VARCHAR),
            @Result(column = "message_status", property = "messageStatus", jdbcType = JdbcType.INTEGER),
            @Result(column = "message_sendDT", property = "messageSenddt", jdbcType = JdbcType.TIMESTAMP)
    })
    Message selectByPrimaryKey(Integer messageId);


    @Select({
            "call p_back_message_group(#{userId})"
    })
    @Results({
            @Result(column = "product_id", property = "productId", jdbcType = JdbcType.INTEGER),
            @Result(column = "product_title", property = "productTitle", jdbcType = JdbcType.VARCHAR),
    })
    List<MessageProductRespDTO> selectByReceivedUserId(@Param("userId") Long userId);


    @Select({
            "call p_back_message_product(#{myId}, #{productId})"
    })
    @Results({
            @Result(column = "product_id", property = "productId", jdbcType = JdbcType.INTEGER),
            @Result(column = "send_user_id", property = "otherId", jdbcType = JdbcType.BIGINT),
            @Result(column = "send_user_nickname", property = "otherNickName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "send_user_photo_path", property = "otherPhotoPath", jdbcType = JdbcType.VARCHAR),
            @Result(column = "send_dt", property = "sendDt", jdbcType = JdbcType.TIMESTAMP),
    })
    List<MessageSenderRespDTO> selectByUserId(@Param("myId") Long myId, @Param("productId") Integer productId);


    @Select({
            "call p_back_message_total(#{reqDTO.myId}, #{reqDTO.otherId}, #{reqDTO.productId})"
    })
    @Results({
            @Result(column = "message_wait_count", property = "messageWaitCount", jdbcType = JdbcType.INTEGER),
    })
    MessageContextRespDTO selectMessageTotal(@Param("reqDTO") MessageContextReqDTO reqDTO);

    @Select({
            "call p_back_message_current(#{reqDTO.myId}, #{reqDTO.otherId}, #{reqDTO.productId})"
    })
    @Results({
            @Result(column = "received_user_id", property = "myId", jdbcType = JdbcType.BIGINT),
            @Result(column = "send_user_id", property = "otherId", jdbcType = JdbcType.BIGINT),
            @Result(column = "message_id", property = "messageId", jdbcType = JdbcType.INTEGER),
            @Result(column = "form_flag", property = "fromFlag", jdbcType = JdbcType.INTEGER),
            @Result(column = "message_content", property = "messageContent", jdbcType = JdbcType.VARCHAR),
            @Result(column = "message_sendDT", property = "messageSendDT", jdbcType = JdbcType.TIMESTAMP),
    })
    List<MessageContextDTO> selectCurrentMessages(@Param("reqDTO") MessageContextReqDTO reqDTO);

    @Select({
            "call p_back_message_prev(#{reqDTO.myId}, #{reqDTO.otherId}, #{reqDTO.productId}, #{reqDTO.messageMinId})"
    })
    @Results({
            @Result(column = "received_user_id", property = "myId", jdbcType = JdbcType.BIGINT),
            @Result(column = "send_user_id", property = "otherId", jdbcType = JdbcType.BIGINT),
            @Result(column = "message_id", property = "messageId", jdbcType = JdbcType.INTEGER),
            @Result(column = "form_flag", property = "fromFlag", jdbcType = JdbcType.INTEGER),
            @Result(column = "message_content", property = "messageContent", jdbcType = JdbcType.VARCHAR),
            @Result(column = "message_sendDT", property = "messageSendDT", jdbcType = JdbcType.TIMESTAMP),
    })
    List<MessageContextDTO> selectPrevMessages(@Param("reqDTO") MessageContextReqDTO reqDTO);

    @Select({
            "call p_back_message_next(#{reqDTO.myId}, #{reqDTO.otherId}, #{reqDTO.productId})"
    })
    @Results({
            @Result(column = "received_user_id", property = "myId", jdbcType = JdbcType.BIGINT),
            @Result(column = "send_user_id", property = "otherId", jdbcType = JdbcType.BIGINT),
            @Result(column = "message_id", property = "messageId", jdbcType = JdbcType.INTEGER),
            @Result(column = "form_flag", property = "fromFlag", jdbcType = JdbcType.INTEGER),
            @Result(column = "message_content", property = "messageContent", jdbcType = JdbcType.VARCHAR),
            @Result(column = "message_sendDT", property = "messageSendDT", jdbcType = JdbcType.TIMESTAMP),
    })
    List<MessageContextDTO> selectNextMessages(@Param("reqDTO") MessageContextReqDTO reqDTO);

    /**
     * 动态字段,根据主键来更新符合条件的数据库记录
     *
     * @param record
     */
    @UpdateProvider(type = MessageSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Message record);

    /**
     * 根据主键来更新符合条件的数据库记录
     *
     * @param record
     */
    @Update({
            "update t_message",
            "set received_user_id = #{receivedUserId,jdbcType=BIGINT},",
            "product_id = #{productId,jdbcType=INTEGER},",
            "send_user_id = #{sendUserId,jdbcType=BIGINT},",
            "message_type = #{messageType,jdbcType=INTEGER},",
            "message_content = #{messageContent,jdbcType=VARCHAR},",
            "message_status = #{messageStatus,jdbcType=INTEGER},",
            "message_sendDT = #{messageSenddt,jdbcType=TIMESTAMP}",
            "where message_id = #{messageId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Message record);

    @Select({
            "call p_back_message_wait_count(#{userId})"
    })
    int callMessageTotal(@Param("userId") Long userId);


    class MessageSqlProvider {

        /**
         * 动态字段,写入数据库记录
         *
         * @param record
         */
        public String insertSelective(Message record) {
            SQL sql = new SQL();
            sql.INSERT_INTO("t_message");

            if (record.getMessageId() != null) {
                sql.VALUES("message_id", "#{messageId,jdbcType=INTEGER}");
            }

            if (record.getReceivedUserId() != null) {
                sql.VALUES("received_user_id", "#{receivedUserId,jdbcType=BIGINT}");
            }

            if (record.getProductId() != null) {
                sql.VALUES("product_id", "#{productId,jdbcType=INTEGER}");
            }

            if (record.getSendUserId() != null) {
                sql.VALUES("send_user_id", "#{sendUserId,jdbcType=BIGINT}");
            }

            if (record.getMessageType() != null) {
                sql.VALUES("message_type", "#{messageType,jdbcType=INTEGER}");
            }

            if (record.getMessageContent() != null) {
                sql.VALUES("message_content", "#{messageContent,jdbcType=VARCHAR}");
            }

            if (record.getMessageStatus() != null) {
                sql.VALUES("message_status", "#{messageStatus,jdbcType=INTEGER}");
            }

            if (record.getMessageSenddt() != null) {
                sql.VALUES("message_sendDT", "#{messageSenddt,jdbcType=TIMESTAMP}");
            }

            return sql.toString();
        }

        /**
         * 动态字段,根据主键来更新符合条件的数据库记录
         *
         * @param record
         */
        public String updateByPrimaryKeySelective(Message record) {
            SQL sql = new SQL();
            sql.UPDATE("t_message");

            if (record.getReceivedUserId() != null) {
                sql.SET("received_user_id = #{receivedUserId,jdbcType=BIGINT}");
            }

            if (record.getProductId() != null) {
                sql.SET("product_id = #{productId,jdbcType=INTEGER}");
            }

            if (record.getSendUserId() != null) {
                sql.SET("send_user_id = #{sendUserId,jdbcType=BIGINT}");
            }

            if (record.getMessageType() != null) {
                sql.SET("message_type = #{messageType,jdbcType=INTEGER}");
            }

            if (record.getMessageContent() != null) {
                sql.SET("message_content = #{messageContent,jdbcType=VARCHAR}");
            }

            if (record.getMessageStatus() != null) {
                sql.SET("message_status = #{messageStatus,jdbcType=INTEGER}");
            }

            if (record.getMessageSenddt() != null) {
                sql.SET("message_sendDT = #{messageSenddt,jdbcType=TIMESTAMP}");
            }

            sql.WHERE("message_id = #{messageId,jdbcType=INTEGER}");

            return sql.toString();
        }
    }
}