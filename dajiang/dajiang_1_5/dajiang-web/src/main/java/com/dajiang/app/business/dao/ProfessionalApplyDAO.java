/* github.com/zhouwd */
package com.dajiang.app.business.dao;

import com.dajiang.app.business.po.dmo.ProfessionalApply;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.type.JdbcType;

/**
 * 本文件由 github.com/zhouwd/mybatis-generator-core 自动生成
 *
 * @author zhouwd code generator
 */
public interface ProfessionalApplyDAO {
    /**
     * 根据主键删除数据库的记录
     *
     * @param professionalApplyId
     */
    @Delete({
            "delete from t_professional_apply",
            "where professional_apply_id = #{professionalApplyId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer professionalApplyId);

    /**
     * 动态字段,写入数据库记录
     *
     * @param record
     */
    @InsertProvider(type = ProfessionalApplySqlProvider.class, method = "insertSelective")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "professionalApplyId", before = false, resultType = Integer.class)
    @Options(useGeneratedKeys = true, keyProperty = "professionalApplyId", keyColumn = "professional_apply_id")
    int insertSelective(ProfessionalApply record);

    /**
     * 根据指定主键获取一条数据库记录
     *
     * @param professionalApplyId
     */
    @Select({
            "select",
            "professional_apply_id, user_id, professional_name, professional_type_id, region_id, ",
            "professional_workunit, professional_workDT, professional_high_educ, ",
            "professional_position, professional_photo_path, professional_ID_front, professional_ID_back, ",
            "professional_level, professional_gender, professional_email, professional_phone, ",
            "professional_birth, professional_field, professional_IDCard, professional_introduction, ",
            "professional_apply_insertDT, professional_apply_status",
            "from t_professional_apply",
            "where professional_apply_id = #{professionalApplyId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "professional_apply_id", property = "professionalApplyId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.BIGINT),
            @Result(column = "professional_name", property = "professionalName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_type_id", property = "professionalTypeId", jdbcType = JdbcType.INTEGER),
            @Result(column = "region_id", property = "regionId", jdbcType = JdbcType.INTEGER),
            @Result(column = "professional_workunit", property = "professionalWorkunit", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_workDT", property = "professionalWorkdt", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "professional_high_educ", property = "professionalHighEduc", jdbcType = JdbcType.TINYINT),
            @Result(column = "professional_position", property = "professionalPosition", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_photo_path", property = "professionalPhotoPath", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_ID_front", property = "professionalIdFront", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_ID_back", property = "professionalIdBack", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_level", property = "professionalLevel", jdbcType = JdbcType.TINYINT),
            @Result(column = "professional_gender", property = "professionalGender", jdbcType = JdbcType.TINYINT),
            @Result(column = "professional_email", property = "professionalEmail", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_phone", property = "professionalPhone", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_birth", property = "professionalBirth", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "professional_field", property = "professionalField", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_IDCard", property = "professionalIdcard", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_introduction", property = "professionalIntroduction", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_apply_insertDT", property = "professionalApplyInsertdt", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "professional_apply_status", property = "professionalApplyStatus", jdbcType = JdbcType.TINYINT)
    })
    ProfessionalApply selectByPrimaryKey(Integer professionalApplyId);

    @Select({
            "select",
            "professional_apply_id, user_id, professional_name, professional_type_id, region_id, ",
            "professional_workunit, professional_workDT, professional_high_educ, ",
            "professional_position, professional_photo_path, professional_ID_front, professional_ID_back, ",
            "professional_level, professional_gender, professional_email, professional_phone, ",
            "professional_birth, professional_field, professional_IDCard, professional_introduction, ",
            "professional_apply_insertDT, professional_apply_status",
            "from t_professional_apply",
            "where user_id = #{userId,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column = "professional_apply_id", property = "professionalApplyId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.BIGINT),
            @Result(column = "professional_name", property = "professionalName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_type_id", property = "professionalTypeId", jdbcType = JdbcType.INTEGER),
            @Result(column = "region_id", property = "regionId", jdbcType = JdbcType.INTEGER),
            @Result(column = "professional_workunit", property = "professionalWorkunit", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_workDT", property = "professionalWorkdt", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "professional_high_educ", property = "professionalHighEduc", jdbcType = JdbcType.TINYINT),
            @Result(column = "professional_position", property = "professionalPosition", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_photo_path", property = "professionalPhotoPath", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_ID_front", property = "professionalIdFront", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_ID_back", property = "professionalIdBack", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_level", property = "professionalLevel", jdbcType = JdbcType.TINYINT),
            @Result(column = "professional_gender", property = "professionalGender", jdbcType = JdbcType.TINYINT),
            @Result(column = "professional_email", property = "professionalEmail", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_phone", property = "professionalPhone", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_birth", property = "professionalBirth", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "professional_field", property = "professionalField", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_IDCard", property = "professionalIdcard", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_introduction", property = "professionalIntroduction", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_apply_insertDT", property = "professionalApplyInsertdt", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "professional_apply_status", property = "professionalApplyStatus", jdbcType = JdbcType.TINYINT)
    })
    ProfessionalApply selectByUserId(@Param("userId") Long userId);

    /**
     * 动态字段,根据主键来更新符合条件的数据库记录
     *
     * @param record
     */
    @UpdateProvider(type = ProfessionalApplySqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ProfessionalApply record);

    /**
     * 根据主键来更新符合条件的数据库记录
     *
     * @param record
     */
    @Update({
            "update t_professional_apply",
            "set user_id = #{userId,jdbcType=BIGINT},",
            "professional_name = #{professionalName,jdbcType=VARCHAR},",
            "professional_type_id = #{professionalTypeId,jdbcType=INTEGER},",
            "region_id = #{regionId,jdbcType=INTEGER},",
            "professional_workunit = #{professionalWorkunit,jdbcType=VARCHAR},",
            "professional_workDT = #{professionalWorkdt,jdbcType=TIMESTAMP},",
            "professional_high_educ = #{professionalHighEduc,jdbcType=TINYINT},",
            "professional_position = #{professionalPosition,jdbcType=VARCHAR},",
            "professional_photo_path = #{professionalPhotoPath,jdbcType=VARCHAR},",
            "professional_ID_front = #{professionalIdFront,jdbcType=VARCHAR},",
            "professional_ID_back = #{professionalIdBack,jdbcType=VARCHAR},",
            "professional_level = #{professionalLevel,jdbcType=TINYINT},",
            "professional_gender = #{professionalGender,jdbcType=TINYINT},",
            "professional_email = #{professionalEmail,jdbcType=VARCHAR},",
            "professional_phone = #{professionalPhone,jdbcType=VARCHAR},",
            "professional_birth = #{professionalBirth,jdbcType=TIMESTAMP},",
            "professional_field = #{professionalField,jdbcType=VARCHAR},",
            "professional_IDCard = #{professionalIdcard,jdbcType=VARCHAR},",
            "professional_introduction = #{professionalIntroduction,jdbcType=VARCHAR},",
            "professional_apply_insertDT = #{professionalApplyInsertdt,jdbcType=TIMESTAMP},",
            "professional_apply_status = #{professionalApplyStatus,jdbcType=TINYINT}",
            "where professional_apply_id = #{professionalApplyId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ProfessionalApply record);

    class ProfessionalApplySqlProvider {

        /**
         * 动态字段,写入数据库记录
         *
         * @param record
         */
        public String insertSelective(ProfessionalApply record) {
            SQL sql = new SQL();
            sql.INSERT_INTO("t_professional_apply");

            if (record.getProfessionalApplyId() != null) {
                sql.VALUES("professional_apply_id", "#{professionalApplyId,jdbcType=INTEGER}");
            }

            if (record.getUserId() != null) {
                sql.VALUES("user_id", "#{userId,jdbcType=BIGINT}");
            }

            if (record.getProfessionalName() != null) {
                sql.VALUES("professional_name", "#{professionalName,jdbcType=VARCHAR}");
            }

            if (record.getProfessionalTypeId() != null) {
                sql.VALUES("professional_type_id", "#{professionalTypeId,jdbcType=INTEGER}");
            }

            if (record.getRegionId() != null) {
                sql.VALUES("region_id", "#{regionId,jdbcType=INTEGER}");
            }

            if (record.getProfessionalWorkunit() != null) {
                sql.VALUES("professional_workunit", "#{professionalWorkunit,jdbcType=VARCHAR}");
            }

            if (record.getProfessionalWorkdt() != null) {
                sql.VALUES("professional_workDT", "#{professionalWorkdt,jdbcType=TIMESTAMP}");
            }

            if (record.getProfessionalHighEduc() != null) {
                sql.VALUES("professional_high_educ", "#{professionalHighEduc,jdbcType=TINYINT}");
            }

            if (record.getProfessionalPosition() != null) {
                sql.VALUES("professional_position", "#{professionalPosition,jdbcType=VARCHAR}");
            }

            if (record.getProfessionalPhotoPath() != null) {
                sql.VALUES("professional_photo_path", "#{professionalPhotoPath,jdbcType=VARCHAR}");
            }

            if (record.getProfessionalIdFront() != null) {
                sql.VALUES("professional_ID_front", "#{professionalIdFront,jdbcType=VARCHAR}");
            }

            if (record.getProfessionalIdBack() != null) {
                sql.VALUES("professional_ID_back", "#{professionalIdBack,jdbcType=VARCHAR}");
            }

            if (record.getProfessionalLevel() != null) {
                sql.VALUES("professional_level", "#{professionalLevel,jdbcType=TINYINT}");
            }

            if (record.getProfessionalGender() != null) {
                sql.VALUES("professional_gender", "#{professionalGender,jdbcType=TINYINT}");
            }

            if (record.getProfessionalEmail() != null) {
                sql.VALUES("professional_email", "#{professionalEmail,jdbcType=VARCHAR}");
            }

            if (record.getProfessionalPhone() != null) {
                sql.VALUES("professional_phone", "#{professionalPhone,jdbcType=VARCHAR}");
            }

            if (record.getProfessionalBirth() != null) {
                sql.VALUES("professional_birth", "#{professionalBirth,jdbcType=TIMESTAMP}");
            }

            if (record.getProfessionalField() != null) {
                sql.VALUES("professional_field", "#{professionalField,jdbcType=VARCHAR}");
            }

            if (record.getProfessionalIdcard() != null) {
                sql.VALUES("professional_IDCard", "#{professionalIdcard,jdbcType=VARCHAR}");
            }

            if (record.getProfessionalIntroduction() != null) {
                sql.VALUES("professional_introduction", "#{professionalIntroduction,jdbcType=VARCHAR}");
            }

            if (record.getProfessionalApplyInsertdt() != null) {
                sql.VALUES("professional_apply_insertDT", "#{professionalApplyInsertdt,jdbcType=TIMESTAMP}");
            }

            if (record.getProfessionalApplyStatus() != null) {
                sql.VALUES("professional_apply_status", "#{professionalApplyStatus,jdbcType=TINYINT}");
            }

            return sql.toString();
        }

        /**
         * 动态字段,根据主键来更新符合条件的数据库记录
         *
         * @param record
         */
        public String updateByPrimaryKeySelective(ProfessionalApply record) {
            SQL sql = new SQL();
            sql.UPDATE("t_professional_apply");

            if (record.getUserId() != null) {
                sql.SET("user_id = #{userId,jdbcType=BIGINT}");
            }

            if (record.getProfessionalName() != null) {
                sql.SET("professional_name = #{professionalName,jdbcType=VARCHAR}");
            }

            if (record.getProfessionalTypeId() != null) {
                sql.SET("professional_type_id = #{professionalTypeId,jdbcType=INTEGER}");
            }

            if (record.getRegionId() != null) {
                sql.SET("region_id = #{regionId,jdbcType=INTEGER}");
            }

            if (record.getProfessionalWorkunit() != null) {
                sql.SET("professional_workunit = #{professionalWorkunit,jdbcType=VARCHAR}");
            }

            if (record.getProfessionalWorkdt() != null) {
                sql.SET("professional_workDT = #{professionalWorkdt,jdbcType=TIMESTAMP}");
            }

            if (record.getProfessionalHighEduc() != null) {
                sql.SET("professional_high_educ = #{professionalHighEduc,jdbcType=TINYINT}");
            }

            if (record.getProfessionalPosition() != null) {
                sql.SET("professional_position = #{professionalPosition,jdbcType=VARCHAR}");
            }

            if (record.getProfessionalPhotoPath() != null) {
                sql.SET("professional_photo_path = #{professionalPhotoPath,jdbcType=VARCHAR}");
            }

            if (record.getProfessionalIdFront() != null) {
                sql.SET("professional_ID_front = #{professionalIdFront,jdbcType=VARCHAR}");
            }

            if (record.getProfessionalIdBack() != null) {
                sql.SET("professional_ID_back = #{professionalIdBack,jdbcType=VARCHAR}");
            }

            if (record.getProfessionalLevel() != null) {
                sql.SET("professional_level = #{professionalLevel,jdbcType=TINYINT}");
            }

            if (record.getProfessionalGender() != null) {
                sql.SET("professional_gender = #{professionalGender,jdbcType=TINYINT}");
            }

            if (record.getProfessionalEmail() != null) {
                sql.SET("professional_email = #{professionalEmail,jdbcType=VARCHAR}");
            }

            if (record.getProfessionalPhone() != null) {
                sql.SET("professional_phone = #{professionalPhone,jdbcType=VARCHAR}");
            }

            if (record.getProfessionalBirth() != null) {
                sql.SET("professional_birth = #{professionalBirth,jdbcType=TIMESTAMP}");
            }

            if (record.getProfessionalField() != null) {
                sql.SET("professional_field = #{professionalField,jdbcType=VARCHAR}");
            }

            if (record.getProfessionalIdcard() != null) {
                sql.SET("professional_IDCard = #{professionalIdcard,jdbcType=VARCHAR}");
            }

            if (record.getProfessionalIntroduction() != null) {
                sql.SET("professional_introduction = #{professionalIntroduction,jdbcType=VARCHAR}");
            }

            if (record.getProfessionalApplyInsertdt() != null) {
                sql.SET("professional_apply_insertDT = #{professionalApplyInsertdt,jdbcType=TIMESTAMP}");
            }

            if (record.getProfessionalApplyStatus() != null) {
                sql.SET("professional_apply_status = #{professionalApplyStatus,jdbcType=TINYINT}");
            }

            sql.WHERE("professional_apply_id = #{professionalApplyId,jdbcType=INTEGER}");

            return sql.toString();
        }
    }
}