/* github.com/zhouwd */
package com.dajiang.app.business.dao;

import com.dajiang.app.business.po.dmo.ProfessionalType;
import com.dajiang.app.business.po.resp.ProfessionalTypeRespDTO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * 本文件由 github.com/zhouwd/mybatis-generator-core 自动生成
 *
 * @author zhouwd code generator
 */
public interface ProfessionalTypeDAO {
    /**
     * 根据主键删除数据库的记录
     *
     * @param professionalTypeId
     */
    @Delete({
            "delete from t_professional_type",
            "where professional_type_id = #{professionalTypeId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer professionalTypeId);

    /**
     * 动态字段,写入数据库记录
     *
     * @param record
     */
    @InsertProvider(type = ProfessionalTypeSqlProvider.class, method = "insertSelective")
    int insertSelective(ProfessionalType record);

    /**
     * 根据指定主键获取一条数据库记录
     *
     * @param professionalTypeId
     */
    @Select({
            "select",
            "professional_type_id, professional_type_name, professional_type_parent_id, professional_type_level, ",
            "professional_type_insertDT, professional_type_updateDT",
            "from t_professional_type",
            "where professional_type_id = #{professionalTypeId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "professional_type_id", property = "professionalTypeId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "professional_type_name", property = "professionalTypeName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_type_parent_id", property = "professionalTypeParentId", jdbcType = JdbcType.INTEGER),
            @Result(column = "professional_type_level", property = "professionalTypeLevel", jdbcType = JdbcType.INTEGER),
            @Result(column = "professional_type_insertDT", property = "professionalTypeInsertdt", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "professional_type_updateDT", property = "professionalTypeUpdatedt", jdbcType = JdbcType.TIMESTAMP)
    })
    ProfessionalType selectByPrimaryKey(Integer professionalTypeId);


    @Select({
            "select",
            "professional_type_id, professional_type_name, professional_type_parent_id, professional_type_level",
            "from t_professional_type",
            "where professional_type_parent_id = #{parentId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "professional_type_id", property = "professionalTypeId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "professional_type_name", property = "professionalTypeName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_type_parent_id", property = "professionalTypeParentId", jdbcType = JdbcType.INTEGER),
            @Result(column = "professional_type_level", property = "professionalTypeLevel", jdbcType = JdbcType.INTEGER),
    })
    List<ProfessionalTypeRespDTO> selectByParentId(@Param("parentId") Integer parentId);

    /**
     * 动态字段,根据主键来更新符合条件的数据库记录
     *
     * @param record
     */
    @UpdateProvider(type = ProfessionalTypeSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ProfessionalType record);

    /**
     * 根据主键来更新符合条件的数据库记录
     *
     * @param record
     */
    @Update({
            "update t_professional_type",
            "set professional_type_name = #{professionalTypeName,jdbcType=VARCHAR},",
            "professional_type_parent_id = #{professionalTypeParentId,jdbcType=INTEGER},",
            "professional_type_level = #{professionalTypeLevel,jdbcType=INTEGER},",
            "professional_type_insertDT = #{professionalTypeInsertdt,jdbcType=TIMESTAMP},",
            "professional_type_updateDT = #{professionalTypeUpdatedt,jdbcType=TIMESTAMP}",
            "where professional_type_id = #{professionalTypeId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ProfessionalType record);

    class ProfessionalTypeSqlProvider {

        /**
         * 动态字段,写入数据库记录
         *
         * @param record
         */
        public String insertSelective(ProfessionalType record) {
            SQL sql = new SQL();
            sql.INSERT_INTO("t_professional_type");

            if (record.getProfessionalTypeId() != null) {
                sql.VALUES("professional_type_id", "#{professionalTypeId,jdbcType=INTEGER}");
            }

            if (record.getProfessionalTypeName() != null) {
                sql.VALUES("professional_type_name", "#{professionalTypeName,jdbcType=VARCHAR}");
            }

            if (record.getProfessionalTypeParentId() != null) {
                sql.VALUES("professional_type_parent_id", "#{professionalTypeParentId,jdbcType=INTEGER}");
            }

            if (record.getProfessionalTypeLevel() != null) {
                sql.VALUES("professional_type_level", "#{professionalTypeLevel,jdbcType=INTEGER}");
            }

            if (record.getProfessionalTypeInsertdt() != null) {
                sql.VALUES("professional_type_insertDT", "#{professionalTypeInsertdt,jdbcType=TIMESTAMP}");
            }

            if (record.getProfessionalTypeUpdatedt() != null) {
                sql.VALUES("professional_type_updateDT", "#{professionalTypeUpdatedt,jdbcType=TIMESTAMP}");
            }

            return sql.toString();
        }

        /**
         * 动态字段,根据主键来更新符合条件的数据库记录
         *
         * @param record
         */
        public String updateByPrimaryKeySelective(ProfessionalType record) {
            SQL sql = new SQL();
            sql.UPDATE("t_professional_type");

            if (record.getProfessionalTypeName() != null) {
                sql.SET("professional_type_name = #{professionalTypeName,jdbcType=VARCHAR}");
            }

            if (record.getProfessionalTypeParentId() != null) {
                sql.SET("professional_type_parent_id = #{professionalTypeParentId,jdbcType=INTEGER}");
            }

            if (record.getProfessionalTypeLevel() != null) {
                sql.SET("professional_type_level = #{professionalTypeLevel,jdbcType=INTEGER}");
            }

            if (record.getProfessionalTypeInsertdt() != null) {
                sql.SET("professional_type_insertDT = #{professionalTypeInsertdt,jdbcType=TIMESTAMP}");
            }

            if (record.getProfessionalTypeUpdatedt() != null) {
                sql.SET("professional_type_updateDT = #{professionalTypeUpdatedt,jdbcType=TIMESTAMP}");
            }

            sql.WHERE("professional_type_id = #{professionalTypeId,jdbcType=INTEGER}");

            return sql.toString();
        }
    }
}