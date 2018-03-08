/* github.com/zhouwd */
package com.dajiang.app.business.dao;

import com.dajiang.app.business.po.dmo.VerificationLog;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.type.JdbcType;

/**
 * 本文件由 github.com/zhouwd/mybatis-generator-core 自动生成
 *
 * @author zhouwd code generator
 */
public interface VerificationLogDAO {
    /**
     * 根据主键删除数据库的记录
     *
     * @param id
     */
    @Delete({
            "delete from t_verification_log",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * 动态字段,写入数据库记录
     *
     * @param record
     */
    @InsertProvider(type = VerificationLogSqlProvider.class, method = "insertSelective")
    int insertSelective(VerificationLog record);

    /**
     * 根据指定主键获取一条数据库记录
     */
    @Select({
            "select",
            "id, user_phone, verification_code, first_time, last_time, send_times",
            "from t_verification_log",
            "where user_phone = #{userPhone,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "user_phone", property = "userPhone", jdbcType = JdbcType.VARCHAR),
            @Result(column = "verification_code", property = "verificationCode", jdbcType = JdbcType.VARCHAR),
            @Result(column = "first_time", property = "firstTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "last_time", property = "lastTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "send_times", property = "sendTimes", jdbcType = JdbcType.INTEGER)
    })
    VerificationLog selectByUserPhone(@Param("userPhone") String userPhone);

    /**
     * 动态字段,根据主键来更新符合条件的数据库记录
     *
     * @param record
     */
    @UpdateProvider(type = VerificationLogSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(VerificationLog record);

    /**
     * 根据主键来更新符合条件的数据库记录
     *
     * @param record
     */
    @Update({
            "update t_verification_log",
            "set user_phone = #{userPhone,jdbcType=VARCHAR},",
            "verification_code = #{verificationCode,jdbcType=VARCHAR},",
            "first_time = #{firstTime,jdbcType=TIMESTAMP},",
            "last_time = #{lastTime,jdbcType=TIMESTAMP},",
            "send_times = #{sendTimes,jdbcType=INTEGER}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(VerificationLog record);

    class VerificationLogSqlProvider {

        /**
         * 动态字段,写入数据库记录
         *
         * @param record
         */
        public String insertSelective(VerificationLog record) {
            SQL sql = new SQL();
            sql.INSERT_INTO("t_verification_log");

            if (record.getId() != null) {
                sql.VALUES("id", "#{id,jdbcType=INTEGER}");
            }

            if (record.getUserPhone() != null) {
                sql.VALUES("user_phone", "#{userPhone,jdbcType=VARCHAR}");
            }

            if (record.getUseType() != null) {
                sql.VALUES("use_type", "#{useType,jdbcType=VARCHAR}");
            }

            if (record.getVerificationCode() != null) {
                sql.VALUES("verification_code", "#{verificationCode,jdbcType=VARCHAR}");
            }

            if (record.getFirstTime() != null) {
                sql.VALUES("first_time", "#{firstTime,jdbcType=TIMESTAMP}");
            }

            if (record.getLastTime() != null) {
                sql.VALUES("last_time", "#{lastTime,jdbcType=TIMESTAMP}");
            }

            if (record.getSendTimes() != null) {
                sql.VALUES("send_times", "#{sendTimes,jdbcType=INTEGER}");
            }

            return sql.toString();
        }

        /**
         * 动态字段,根据主键来更新符合条件的数据库记录
         *
         * @param record
         */
        public String updateByPrimaryKeySelective(VerificationLog record) {
            SQL sql = new SQL();
            sql.UPDATE("t_verification_log");

            if (record.getUserPhone() != null) {
                sql.SET("user_phone = #{userPhone,jdbcType=VARCHAR}");
            }
            if (record.getUseType() != null) {
                sql.SET("use_type = #{useType,jdbcType=VARCHAR}");
            }

            if (record.getVerificationCode() != null) {
                sql.SET("verification_code = #{verificationCode,jdbcType=VARCHAR}");
            }

            if (record.getFirstTime() != null) {
                sql.SET("first_time = #{firstTime,jdbcType=TIMESTAMP}");
            }

            if (record.getLastTime() != null) {
                sql.SET("last_time = #{lastTime,jdbcType=TIMESTAMP}");
            }

            if (record.getSendTimes() != null) {
                sql.SET("send_times = #{sendTimes,jdbcType=INTEGER}");
            }

            sql.WHERE("id = #{id,jdbcType=INTEGER}");

            return sql.toString();
        }
    }
}