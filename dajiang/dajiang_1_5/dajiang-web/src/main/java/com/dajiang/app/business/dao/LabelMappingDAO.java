/* github.com/zhouwd */
package com.dajiang.app.business.dao;

import com.dajiang.app.business.po.dmo.LabelMapping;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.type.JdbcType;

/**
 * 本文件由 github.com/zhouwd/mybatis-generator-core 自动生成
 *
 * @author zhouwd code generator
 */
public interface LabelMappingDAO {
    /**
     * 根据主键删除数据库的记录
     *
     * @param labelMappingId
     */
    @Delete({
            "delete from t_label_mapping",
            "where label_mapping_id = #{labelMappingId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer labelMappingId);

    /**
     * 动态字段,写入数据库记录
     *
     * @param record
     */
    @InsertProvider(type = LabelMappingSqlProvider.class, method = "insertSelective")
    int insertSelective(LabelMapping record);

    /**
     * 根据指定主键获取一条数据库记录
     *
     * @param labelMappingId
     */
    @Select({
            "select",
            "label_mapping_id, label_id, label_mapping_type, mapping_id",
            "from t_label_mapping",
            "where label_mapping_id = #{labelMappingId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "label_mapping_id", property = "labelMappingId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "label_id", property = "labelId", jdbcType = JdbcType.INTEGER),
            @Result(column = "label_mapping_type", property = "labelMappingType", jdbcType = JdbcType.INTEGER),
            @Result(column = "mapping_id", property = "mappingId", jdbcType = JdbcType.BIGINT)
    })
    LabelMapping selectByPrimaryKey(Integer labelMappingId);

    /**
     * 动态字段,根据主键来更新符合条件的数据库记录
     *
     * @param record
     */
    @UpdateProvider(type = LabelMappingSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(LabelMapping record);

    /**
     * 根据主键来更新符合条件的数据库记录
     *
     * @param record
     */
    @Update({
            "update t_label_mapping",
            "set label_id = #{labelId,jdbcType=INTEGER},",
            "label_mapping_type = #{labelMappingType,jdbcType=INTEGER},",
            "mapping_id = #{mappingId,jdbcType=BIGINT}",
            "where label_mapping_id = #{labelMappingId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(LabelMapping record);

    class LabelMappingSqlProvider {

        /**
         * 动态字段,写入数据库记录
         *
         * @param record
         */
        public String insertSelective(LabelMapping record) {
            SQL sql = new SQL();
            sql.INSERT_INTO("t_label_mapping");

            if (record.getLabelMappingId() != null) {
                sql.VALUES("label_mapping_id", "#{labelMappingId,jdbcType=INTEGER}");
            }

            if (record.getLabelId() != null) {
                sql.VALUES("label_id", "#{labelId,jdbcType=INTEGER}");
            }

            if (record.getLabelMappingType() != null) {
                sql.VALUES("label_mapping_type", "#{labelMappingType,jdbcType=INTEGER}");
            }

            if (record.getMappingId() != null) {
                sql.VALUES("mapping_id", "#{mappingId,jdbcType=BIGINT}");
            }

            return sql.toString();
        }

        /**
         * 动态字段,根据主键来更新符合条件的数据库记录
         *
         * @param record
         */
        public String updateByPrimaryKeySelective(LabelMapping record) {
            SQL sql = new SQL();
            sql.UPDATE("t_label_mapping");

            if (record.getLabelId() != null) {
                sql.SET("label_id = #{labelId,jdbcType=INTEGER}");
            }

            if (record.getLabelMappingType() != null) {
                sql.SET("label_mapping_type = #{labelMappingType,jdbcType=INTEGER}");
            }

            if (record.getMappingId() != null) {
                sql.SET("mapping_id = #{mappingId,jdbcType=BIGINT}");
            }

            sql.WHERE("label_mapping_id = #{labelMappingId,jdbcType=INTEGER}");

            return sql.toString();
        }
    }
}