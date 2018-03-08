/* github.com/zhouwd */
package com.dajiang.app.business.dao;

import com.dajiang.app.business.po.dmo.Label;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.type.JdbcType;

/**
 * 本文件由 github.com/zhouwd/mybatis-generator-core 自动生成
 *
 * @author zhouwd code generator
 */
public interface LabelDAO {
    /**
     * 根据主键删除数据库的记录
     *
     * @param labelId
     */
    @Delete({
            "delete from t_label",
            "where label_id = #{labelId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer labelId);

    /**
     * 动态字段,写入数据库记录
     *
     * @param record
     */
    @InsertProvider(type = LabelSqlProvider.class, method = "insertSelective")
    int insertSelective(Label record);

    /**
     * 根据指定主键获取一条数据库记录
     *
     * @param labelId
     */
    @Select({
            "select",
            "label_id, label_name, label_type",
            "from t_label",
            "where label_id = #{labelId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "label_id", property = "labelId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "label_name", property = "labelName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "label_type", property = "labelType", jdbcType = JdbcType.VARCHAR)
    })
    Label selectByPrimaryKey(Integer labelId);

    /**
     * 动态字段,根据主键来更新符合条件的数据库记录
     *
     * @param record
     */
    @UpdateProvider(type = LabelSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Label record);

    /**
     * 根据主键来更新符合条件的数据库记录
     *
     * @param record
     */
    @Update({
            "update t_label",
            "set label_name = #{labelName,jdbcType=VARCHAR},",
            "label_type = #{labelType,jdbcType=VARCHAR}",
            "where label_id = #{labelId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Label record);

    class LabelSqlProvider {

        /**
         * 动态字段,写入数据库记录
         *
         * @param record
         */
        public String insertSelective(Label record) {
            SQL sql = new SQL();
            sql.INSERT_INTO("t_label");

            if (record.getLabelId() != null) {
                sql.VALUES("label_id", "#{labelId,jdbcType=INTEGER}");
            }

            if (record.getLabelName() != null) {
                sql.VALUES("label_name", "#{labelName,jdbcType=VARCHAR}");
            }

            if (record.getLabelType() != null) {
                sql.VALUES("label_type", "#{labelType,jdbcType=VARCHAR}");
            }

            return sql.toString();
        }

        /**
         * 动态字段,根据主键来更新符合条件的数据库记录
         *
         * @param record
         */
        public String updateByPrimaryKeySelective(Label record) {
            SQL sql = new SQL();
            sql.UPDATE("t_label");

            if (record.getLabelName() != null) {
                sql.SET("label_name = #{labelName,jdbcType=VARCHAR}");
            }

            if (record.getLabelType() != null) {
                sql.SET("label_type = #{labelType,jdbcType=VARCHAR}");
            }

            sql.WHERE("label_id = #{labelId,jdbcType=INTEGER}");

            return sql.toString();
        }
    }
}