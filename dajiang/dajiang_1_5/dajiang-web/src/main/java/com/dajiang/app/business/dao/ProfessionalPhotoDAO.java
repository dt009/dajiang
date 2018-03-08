/* github.com/zhouwd */
package com.dajiang.app.business.dao;

import com.dajiang.app.business.po.dmo.ProfessionalPhoto;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * 本文件由 github.com/zhouwd/mybatis-generator-core 自动生成
 *
 * @author zhouwd code generator
 */
public interface ProfessionalPhotoDAO {
    /**
     * 根据主键删除数据库的记录
     *
     * @param professionalPhoteId
     */
    @Delete({
            "delete from t_professional_photo",
            "where professional_phote_id = #{professionalPhoteId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer professionalPhoteId);

    @Delete({
            "delete from t_professional_photo",
            "where professional_id = #{professionalId,jdbcType=INTEGER}"
    })
    int deleteByProfessionalId(@Param("professionalId") Integer professionalId);

    /**
     * 动态字段,写入数据库记录
     *
     * @param record
     */
    @InsertProvider(type = ProfessionalPhotoSqlProvider.class, method = "insertSelective")
    int insertSelective(ProfessionalPhoto record);

    /**
     * 根据指定主键获取一条数据库记录
     *
     * @param professionalPhoteId
     */
    @Select({
            "select",
            "professional_phote_id, user_id, professional_phote_type, professional_phote_path, ",
            "professional_phote_sort, professional_phote_insertDT, professional_id",
            "from t_professional_photo",
            "where professional_phote_id = #{professionalPhoteId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "professional_phote_id", property = "professionalPhoteId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.BIGINT),
            @Result(column = "professional_phote_type", property = "professionalPhoteType", jdbcType = JdbcType.TINYINT),
            @Result(column = "professional_phote_path", property = "professionalPhotePath", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_phote_sort", property = "professionalPhoteSort", jdbcType = JdbcType.INTEGER),
            @Result(column = "professional_phote_insertDT", property = "professionalPhoteInsertdt", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "professional_id", property = "professionalId", jdbcType = JdbcType.INTEGER)
    })
    ProfessionalPhoto selectByPrimaryKey(Integer professionalPhoteId);

    @Select({
            "select",
            "professional_phote_id, user_id, professional_phote_type, professional_phote_path, ",
            "professional_phote_sort, professional_phote_insertDT, professional_id",
            "from t_professional_photo",
            "where professional_id = #{professionalId,jdbcType=INTEGER} and professional_phote_type=#{professionalPhotoType,jdbcType=TINYINT}"
    })
    @Results({
            @Result(column = "professional_phote_id", property = "professionalPhoteId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.BIGINT),
            @Result(column = "professional_phote_type", property = "professionalPhoteType", jdbcType = JdbcType.TINYINT),
            @Result(column = "professional_phote_path", property = "professionalPhotePath", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_phote_sort", property = "professionalPhoteSort", jdbcType = JdbcType.INTEGER),
            @Result(column = "professional_phote_insertDT", property = "professionalPhoteInsertdt", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "professional_id", property = "professionalId", jdbcType = JdbcType.INTEGER)
    })
    List<ProfessionalPhoto> selectByProfessionalId(@Param("professionalId") Integer professionalId, @Param("professionalPhotoType") Byte aByte);

    /**
     * 动态字段,根据主键来更新符合条件的数据库记录
     *
     * @param record
     */
    @UpdateProvider(type = ProfessionalPhotoSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ProfessionalPhoto record);

    /**
     * 根据主键来更新符合条件的数据库记录
     *
     * @param record
     */
    @Update({
            "update t_professional_photo",
            "set user_id = #{userId,jdbcType=BIGINT},",
            "professional_phote_type = #{professionalPhoteType,jdbcType=TINYINT},",
            "professional_phote_path = #{professionalPhotePath,jdbcType=VARCHAR},",
            "professional_phote_sort = #{professionalPhoteSort,jdbcType=INTEGER},",
            "professional_phote_insertDT = #{professionalPhoteInsertdt,jdbcType=TIMESTAMP},",
            "professional_id = #{professionalId,jdbcType=INTEGER}",
            "where professional_phote_id = #{professionalPhoteId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ProfessionalPhoto record);

    class ProfessionalPhotoSqlProvider {

        /**
         * 动态字段,写入数据库记录
         *
         * @param record
         */
        public String insertSelective(ProfessionalPhoto record) {
            SQL sql = new SQL();
            sql.INSERT_INTO("t_professional_photo");

            if (record.getProfessionalPhoteId() != null) {
                sql.VALUES("professional_phote_id", "#{professionalPhoteId,jdbcType=INTEGER}");
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

            if (record.getProfessionalId() != null) {
                sql.VALUES("professional_id", "#{professionalId,jdbcType=INTEGER}");
            }

            return sql.toString();
        }

        /**
         * 动态字段,根据主键来更新符合条件的数据库记录
         *
         * @param record
         */
        public String updateByPrimaryKeySelective(ProfessionalPhoto record) {
            SQL sql = new SQL();
            sql.UPDATE("t_professional_photo");

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

            if (record.getProfessionalId() != null) {
                sql.SET("professional_id = #{professionalId,jdbcType=INTEGER}");
            }

            sql.WHERE("professional_phote_id = #{professionalPhoteId,jdbcType=INTEGER}");

            return sql.toString();
        }
    }
}