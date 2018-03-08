/* github.com/zhouwd */
package com.dajiang.app.business.dao;

import com.dajiang.app.business.po.dmo.CkoApply;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.type.JdbcType;

/**
 * 本文件由 github.com/zhouwd/mybatis-generator-core 自动生成
 *
 * @author zhouwd code generator
 */
public interface CkoApplyDAO {
    /**
     * 根据主键删除数据库的记录
     *
     * @param ckoApplyId
     */
    @Delete({
            "delete from t_cko_apply",
            "where cko_apply_id = #{ckoApplyId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer ckoApplyId);

    /**
     * 动态字段,写入数据库记录
     *
     * @param record
     */
    @InsertProvider(type = CkoApplySqlProvider.class, method = "insertSelective")
    @Options(useGeneratedKeys = true, keyProperty = "ckoApplyId", keyColumn = "cko_apply_id")
    int insertSelective(CkoApply record);

    @Select({
            "call p_cko_apply(#{ckoApplyId})"
    })
    int callCKOApply(@Param("ckoApplyId") Integer ckoApplyId);


    /**
     * 根据指定主键获取一条数据库记录
     *
     * @param ckoApplyId
     */
    @Select({
            "select",
            "cko_apply_id, user_id, cko_name, cko_nickname, region_id, cko_phone, cko_apply_email, ",
            "cko_issearch, cko_iscertification, cko_IDCard, cko_ID_front, cko_ID_back, cko_apply_insertDT, ",
            "cko_apply_updateDT, cko_apply_status",
            "from t_cko_apply",
            "where cko_apply_id = #{ckoApplyId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "cko_apply_id", property = "ckoApplyId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.BIGINT),
            @Result(column = "cko_name", property = "ckoName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "cko_nickname", property = "ckoNickname", jdbcType = JdbcType.VARCHAR),
            @Result(column = "region_id", property = "regionId", jdbcType = JdbcType.INTEGER),
            @Result(column = "cko_phone", property = "ckoPhone", jdbcType = JdbcType.VARCHAR),
            @Result(column = "cko_apply_email", property = "ckoApplyEmail", jdbcType = JdbcType.VARCHAR),
            @Result(column = "cko_issearch", property = "ckoIssearch", jdbcType = JdbcType.TINYINT),
            @Result(column = "cko_iscertification", property = "ckoIscertification", jdbcType = JdbcType.TINYINT),
            @Result(column = "cko_IDCard", property = "ckoIdcard", jdbcType = JdbcType.VARCHAR),
            @Result(column = "cko_ID_front", property = "ckoIdFront", jdbcType = JdbcType.VARCHAR),
            @Result(column = "cko_ID_back", property = "ckoIdBack", jdbcType = JdbcType.VARCHAR),
            @Result(column = "cko_apply_insertDT", property = "ckoApplyInsertdt", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "cko_apply_updateDT", property = "ckoApplyUpdatedt", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "cko_apply_status", property = "ckoApplyStatus", jdbcType = JdbcType.TINYINT)
    })
    CkoApply selectByPrimaryKey(Integer ckoApplyId);

    @Select({
            "select",
            "cko_apply_id, user_id, cko_name, cko_nickname, region_id, cko_phone, cko_apply_email, ",
            "cko_issearch, cko_iscertification, cko_IDCard, cko_ID_front, cko_ID_back, cko_apply_insertDT, ",
            "cko_apply_updateDT, cko_apply_status",
            "from t_cko_apply",
            "where user_id = #{userId,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column = "cko_apply_id", property = "ckoApplyId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.BIGINT),
            @Result(column = "cko_name", property = "ckoName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "cko_nickname", property = "ckoNickname", jdbcType = JdbcType.VARCHAR),
            @Result(column = "region_id", property = "regionId", jdbcType = JdbcType.INTEGER),
            @Result(column = "cko_phone", property = "ckoPhone", jdbcType = JdbcType.VARCHAR),
            @Result(column = "cko_apply_email", property = "ckoApplyEmail", jdbcType = JdbcType.VARCHAR),
            @Result(column = "cko_issearch", property = "ckoIssearch", jdbcType = JdbcType.TINYINT),
            @Result(column = "cko_iscertification", property = "ckoIscertification", jdbcType = JdbcType.TINYINT),
            @Result(column = "cko_IDCard", property = "ckoIdcard", jdbcType = JdbcType.VARCHAR),
            @Result(column = "cko_ID_front", property = "ckoIdFront", jdbcType = JdbcType.VARCHAR),
            @Result(column = "cko_ID_back", property = "ckoIdBack", jdbcType = JdbcType.VARCHAR),
            @Result(column = "cko_apply_insertDT", property = "ckoApplyInsertdt", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "cko_apply_updateDT", property = "ckoApplyUpdatedt", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "cko_apply_status", property = "ckoApplyStatus", jdbcType = JdbcType.TINYINT)
    })
    CkoApply selectByUserId(Long userId);

    /**
     * 动态字段,根据主键来更新符合条件的数据库记录
     *
     * @param record
     */
    @UpdateProvider(type = CkoApplySqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CkoApply record);

    /**
     * 根据主键来更新符合条件的数据库记录
     *
     * @param record
     */
    @Update({
            "update t_cko_apply",
            "set user_id = #{userId,jdbcType=BIGINT},",
            "cko_name = #{ckoName,jdbcType=VARCHAR},",
            "cko_nickname = #{ckoNickname,jdbcType=VARCHAR},",
            "region_id = #{regionId,jdbcType=INTEGER},",
            "cko_phone = #{ckoPhone,jdbcType=VARCHAR},",
            "cko_apply_email = #{ckoApplyEmail,jdbcType=VARCHAR},",
            "cko_issearch = #{ckoIssearch,jdbcType=TINYINT},",
            "cko_iscertification = #{ckoIscertification,jdbcType=TINYINT},",
            "cko_IDCard = #{ckoIdcard,jdbcType=VARCHAR},",
            "cko_ID_front = #{ckoIdFront,jdbcType=VARCHAR},",
            "cko_ID_back = #{ckoIdBack,jdbcType=VARCHAR},",
            "cko_apply_insertDT = #{ckoApplyInsertdt,jdbcType=TIMESTAMP},",
            "cko_apply_updateDT = #{ckoApplyUpdatedt,jdbcType=TIMESTAMP},",
            "cko_apply_status = #{ckoApplyStatus,jdbcType=TINYINT}",
            "where cko_apply_id = #{ckoApplyId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CkoApply record);

    class CkoApplySqlProvider {

        /**
         * 动态字段,写入数据库记录
         *
         * @param record
         */
        public String insertSelective(CkoApply record) {
            SQL sql = new SQL();
            sql.INSERT_INTO("t_cko_apply");

            if (record.getCkoApplyId() != null) {
                sql.VALUES("cko_apply_id", "#{ckoApplyId,jdbcType=INTEGER}");
            }

            if (record.getUserId() != null) {
                sql.VALUES("user_id", "#{userId,jdbcType=BIGINT}");
            }

            if (record.getCkoName() != null) {
                sql.VALUES("cko_name", "#{ckoName,jdbcType=VARCHAR}");
            }

            if (record.getCkoNickname() != null) {
                sql.VALUES("cko_nickname", "#{ckoNickname,jdbcType=VARCHAR}");
            }

            if (record.getRegionId() != null) {
                sql.VALUES("region_id", "#{regionId,jdbcType=INTEGER}");
            }

            if (record.getCkoPhone() != null) {
                sql.VALUES("cko_phone", "#{ckoPhone,jdbcType=VARCHAR}");
            }

            if (record.getCkoApplyEmail() != null) {
                sql.VALUES("cko_apply_email", "#{ckoApplyEmail,jdbcType=VARCHAR}");
            }

            if (record.getCkoIssearch() != null) {
                sql.VALUES("cko_issearch", "#{ckoIssearch,jdbcType=TINYINT}");
            }

            if (record.getCkoIscertification() != null) {
                sql.VALUES("cko_iscertification", "#{ckoIscertification,jdbcType=TINYINT}");
            }

            if (record.getCkoIdcard() != null) {
                sql.VALUES("cko_IDCard", "#{ckoIdcard,jdbcType=VARCHAR}");
            }

            if (record.getCkoIdFront() != null) {
                sql.VALUES("cko_ID_front", "#{ckoIdFront,jdbcType=VARCHAR}");
            }

            if (record.getCkoIdBack() != null) {
                sql.VALUES("cko_ID_back", "#{ckoIdBack,jdbcType=VARCHAR}");
            }

            if (record.getCkoApplyInsertdt() != null) {
                sql.VALUES("cko_apply_insertDT", "#{ckoApplyInsertdt,jdbcType=TIMESTAMP}");
            }

            if (record.getCkoApplyUpdatedt() != null) {
                sql.VALUES("cko_apply_updateDT", "#{ckoApplyUpdatedt,jdbcType=TIMESTAMP}");
            }

            if (record.getCkoApplyStatus() != null) {
                sql.VALUES("cko_apply_status", "#{ckoApplyStatus,jdbcType=TINYINT}");
            }

            return sql.toString();
        }

        /**
         * 动态字段,根据主键来更新符合条件的数据库记录
         *
         * @param record
         */
        public String updateByPrimaryKeySelective(CkoApply record) {
            SQL sql = new SQL();
            sql.UPDATE("t_cko_apply");

            if (record.getUserId() != null) {
                sql.SET("user_id = #{userId,jdbcType=BIGINT}");
            }

            if (record.getCkoName() != null) {
                sql.SET("cko_name = #{ckoName,jdbcType=VARCHAR}");
            }

            if (record.getCkoNickname() != null) {
                sql.SET("cko_nickname = #{ckoNickname,jdbcType=VARCHAR}");
            }

            if (record.getRegionId() != null) {
                sql.SET("region_id = #{regionId,jdbcType=INTEGER}");
            }

            if (record.getCkoPhone() != null) {
                sql.SET("cko_phone = #{ckoPhone,jdbcType=VARCHAR}");
            }

            if (record.getCkoApplyEmail() != null) {
                sql.SET("cko_apply_email = #{ckoApplyEmail,jdbcType=VARCHAR}");
            }

            if (record.getCkoIssearch() != null) {
                sql.SET("cko_issearch = #{ckoIssearch,jdbcType=TINYINT}");
            }

            if (record.getCkoIscertification() != null) {
                sql.SET("cko_iscertification = #{ckoIscertification,jdbcType=TINYINT}");
            }

            if (record.getCkoIdcard() != null) {
                sql.SET("cko_IDCard = #{ckoIdcard,jdbcType=VARCHAR}");
            }

            if (record.getCkoIdFront() != null) {
                sql.SET("cko_ID_front = #{ckoIdFront,jdbcType=VARCHAR}");
            }

            if (record.getCkoIdBack() != null) {
                sql.SET("cko_ID_back = #{ckoIdBack,jdbcType=VARCHAR}");
            }

            if (record.getCkoApplyInsertdt() != null) {
                sql.SET("cko_apply_insertDT = #{ckoApplyInsertdt,jdbcType=TIMESTAMP}");
            }

            if (record.getCkoApplyUpdatedt() != null) {
                sql.SET("cko_apply_updateDT = #{ckoApplyUpdatedt,jdbcType=TIMESTAMP}");
            }

            if (record.getCkoApplyStatus() != null) {
                sql.SET("cko_apply_status = #{ckoApplyStatus,jdbcType=TINYINT}");
            }

            sql.WHERE("cko_apply_id = #{ckoApplyId,jdbcType=INTEGER}");

            return sql.toString();
        }
    }
}