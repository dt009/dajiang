/* github.com/zhouwd */
package com.dajiang.app.business.dao;

import com.dajiang.app.business.po.dmo.ProfessionalPhotoApply;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.type.JdbcType;

/**
 * 本文件由 github.com/zhouwd/mybatis-generator-core 自动生成
 *
 * @author zhouwd code generator
 */
public interface ProfessionalPhotoApplyDAO {
    /**
     * 根据主键删除数据库的记录
     *
     * @param professionalPhoteApplyId
     */
    @Delete({
            "delete from t_professional_photo_apply",
            "where professional_phote_apply_id = #{professionalPhoteApplyId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer professionalPhoteApplyId);

    /**
     * 动态字段,写入数据库记录
     *
     * @param record
     */
    @InsertProvider(type = ProfessionalPhotoApplySqlProvider.class, method = "insertSelective")
    int insertSelective(ProfessionalPhotoApply record);

    /**
     * 根据指定主键获取一条数据库记录
     *
     * @param professionalPhoteApplyId
     */
    @Select({
            "select",
            "professional_phote_apply_id, user_id, professional_phote_type, professional_phote_path, ",
            "professional_phote_sort, professional_phote_insertDT, professional_apply_id",
            "from t_professional_photo_apply",
            "where professional_phote_apply_id = #{professionalPhoteApplyId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "professional_phote_apply_id", property = "professionalPhoteApplyId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.BIGINT),
            @Result(column = "professional_phote_type", property = "professionalPhoteType", jdbcType = JdbcType.TINYINT),
            @Result(column = "professional_phote_path", property = "professionalPhotePath", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_phote_sort", property = "professionalPhoteSort", jdbcType = JdbcType.INTEGER),
            @Result(column = "professional_phote_insertDT", property = "professionalPhoteInsertdt", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "professional_apply_id", property = "professionalApplyId", jdbcType = JdbcType.INTEGER)
    })
    ProfessionalPhotoApply selectByPrimaryKey(Integer professionalPhoteApplyId);

    /**
     * 动态字段,根据主键来更新符合条件的数据库记录
     *
     * @param record
     */
    @UpdateProvider(type = ProfessionalPhotoApplySqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ProfessionalPhotoApply record);

    /**
     * 根据主键来更新符合条件的数据库记录
     *
     * @param record
     */
    @Update({
            "update t_professional_photo_apply",
            "set user_id = #{userId,jdbcType=BIGINT},",
            "professional_phote_type = #{professionalPhoteType,jdbcType=TINYINT},",
            "professional_phote_path = #{professionalPhotePath,jdbcType=VARCHAR},",
            "professional_phote_sort = #{professionalPhoteSort,jdbcType=INTEGER},",
            "professional_phote_insertDT = #{professionalPhoteInsertdt,jdbcType=TIMESTAMP},",
            "professional_apply_id = #{professionalApplyId,jdbcType=INTEGER}",
            "where professional_phote_apply_id = #{professionalPhoteApplyId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ProfessionalPhotoApply record);

    @Select({
            "call p_prof_apply(#{professionalApplyId})"
    })
    int callProfApply(@Param("professionalApplyId") Integer professionalApplyId);

    class ProfessionalPhotoApplySqlProvider {

        /**
         * 动态字段,写入数据库记录
         *
         * @param record
         */
        public String insertSelective(ProfessionalPhotoApply record) {
            SQL sql = new SQL();
            sql.INSERT_INTO("t_professional_photo_apply");

            if (record.getProfessionalPhoteApplyId() != null) {
                sql.VALUES("professional_phote_apply_id", "#{professionalPhoteApplyId,jdbcType=INTEGER}");
            }

            if (record.getUserId() != null) {
                sql.VALUES("user_id", "#{userId,jdbcType=BIGINT}");
            }

            if (record.getProfessionalPhoteType() != null) {
                sql.VALUES("professional_phote_type", "#{professionalPhoteType,jdbcType=TINYINT}");
            }

            if (record.getProfessionalPhotePath() != null) {
                sql.VALUES("professional_phote_path", "#{professionalPhotePath,jdbcType=VARCHAR}");
            }

            if (record.getProfessionalPhoteSort() != null) {
                sql.VALUES("professional_phote_sort", "#{professionalPhoteSort,jdbcType=INTEGER}");
            }

            if (record.getProfessionalPhoteInsertdt() != null) {
                sql.VALUES("professional_phote_insertDT", "#{professionalPhoteInsertdt,jdbcType=TIMESTAMP}");
            }

            if (record.getProfessionalApplyId() != null) {
                sql.VALUES("professional_apply_id", "#{professionalApplyId,jdbcType=INTEGER}");
            }

            return sql.toString();
        }

        /**
         * 动态字段,根据主键来更新符合条件的数据库记录
         *
         * @param record
         */
        public String updateByPrimaryKeySelective(ProfessionalPhotoApply record) {
            SQL sql = new SQL();
            sql.UPDATE("t_professional_photo_apply");

            if (record.getUserId() != null) {
                sql.SET("user_id = #{userId,jdbcType=BIGINT}");
            }

            if (record.getProfessionalPhoteType() != null) {
                sql.SET("professional_phote_type = #{professionalPhoteType,jdbcType=TINYINT}");
            }

            if (record.getProfessionalPhotePath() != null) {
                sql.SET("professional_phote_path = #{professionalPhotePath,jdbcType=VARCHAR}");
            }

            if (record.getProfessionalPhoteSort() != null) {
                sql.SET("professional_phote_sort = #{professionalPhoteSort,jdbcType=INTEGER}");
            }

            if (record.getProfessionalPhoteInsertdt() != null) {
                sql.SET("professional_phote_insertDT = #{professionalPhoteInsertdt,jdbcType=TIMESTAMP}");
            }

            if (record.getProfessionalApplyId() != null) {
                sql.SET("professional_apply_id = #{professionalApplyId,jdbcType=INTEGER}");
            }

            sql.WHERE("professional_phote_apply_id = #{professionalPhoteApplyId,jdbcType=INTEGER}");

            return sql.toString();
        }
    }
}