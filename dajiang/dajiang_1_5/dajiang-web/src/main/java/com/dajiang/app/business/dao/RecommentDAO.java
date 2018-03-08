/* github.com/zhouwd */
package com.dajiang.app.business.dao;

import com.dajiang.app.business.po.dmo.Recomment;
import com.dajiang.app.business.po.resp.RecommentRespDTO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * 本文件由 github.com/zhouwd/mybatis-generator-core 自动生成
 *
 * @author zhouwd code generator
 */
public interface RecommentDAO {
    /**
     * 根据主键删除数据库的记录
     *
     * @param recommentId
     */
    @Delete({
            "delete from t_recomment",
            "where recomment_id = #{recommentId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer recommentId);

    /**
     * 动态字段,写入数据库记录
     *
     * @param record
     */
    @InsertProvider(type = RecommentSqlProvider.class, method = "insertSelective")
    int insertSelective(Recomment record);

    /**
     * 根据指定主键获取一条数据库记录
     *
     * @param recommentId
     */
    @Select({
            "select",
            "recomment_id, recomment_sort, recomment_imag_path, recomment_url, recomment_insertDT, ",
            "recomment_updateDT",
            "from t_recomment",
            "where recomment_id = #{recommentId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "recomment_id", property = "recommentId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "recomment_sort", property = "recommentSort", jdbcType = JdbcType.INTEGER),
            @Result(column = "recomment_imag_path", property = "recommentImagPath", jdbcType = JdbcType.VARCHAR),
            @Result(column = "recomment_url", property = "recommentUrl", jdbcType = JdbcType.VARCHAR),
            @Result(column = "recomment_insertDT", property = "recommentInsertdt", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "recomment_updateDT", property = "recommentUpdatedt", jdbcType = JdbcType.TIMESTAMP)
    })
    Recomment selectByPrimaryKey(Integer recommentId);

    @Select({
            "select",
            "recomment_sort, recomment_imag_path, recomment_url",
            "from t_recomment where recomment_isshow=1",
    })
    @Results({
            @Result(column = "recomment_sort", property = "recommentSort", jdbcType = JdbcType.INTEGER),
            @Result(column = "recomment_imag_path", property = "recommentImagPath", jdbcType = JdbcType.VARCHAR),
            @Result(column = "recomment_url", property = "recommentUrl", jdbcType = JdbcType.VARCHAR),
    })
    List<RecommentRespDTO> selectShowList();

    /**
     * 动态字段,根据主键来更新符合条件的数据库记录
     *
     * @param record
     */
    @UpdateProvider(type = RecommentSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Recomment record);

    /**
     * 根据主键来更新符合条件的数据库记录
     *
     * @param record
     */
    @Update({
            "update t_recomment",
            "set recomment_sort = #{recommentSort,jdbcType=INTEGER},",
            "recomment_imag_path = #{recommentImagPath,jdbcType=VARCHAR},",
            "recomment_url = #{recommentUrl,jdbcType=VARCHAR},",
            "recomment_insertDT = #{recommentInsertdt,jdbcType=TIMESTAMP},",
            "recomment_updateDT = #{recommentUpdatedt,jdbcType=TIMESTAMP}",
            "where recomment_id = #{recommentId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Recomment record);

    class RecommentSqlProvider {

        /**
         * 动态字段,写入数据库记录
         *
         * @param record
         */
        public String insertSelective(Recomment record) {
            SQL sql = new SQL();
            sql.INSERT_INTO("t_recomment");

            if (record.getRecommentId() != null) {
                sql.VALUES("recomment_id", "#{recommentId,jdbcType=INTEGER}");
            }

            if (record.getRecommentSort() != null) {
                sql.VALUES("recomment_sort", "#{recommentSort,jdbcType=INTEGER}");
            }

            if (record.getRecommentImagPath() != null) {
                sql.VALUES("recomment_imag_path", "#{recommentImagPath,jdbcType=VARCHAR}");
            }

            if (record.getRecommentUrl() != null) {
                sql.VALUES("recomment_url", "#{recommentUrl,jdbcType=VARCHAR}");
            }

            if (record.getRecommentInsertdt() != null) {
                sql.VALUES("recomment_insertDT", "#{recommentInsertdt,jdbcType=TIMESTAMP}");
            }

            if (record.getRecommentUpdatedt() != null) {
                sql.VALUES("recomment_updateDT", "#{recommentUpdatedt,jdbcType=TIMESTAMP}");
            }

            return sql.toString();
        }

        /**
         * 动态字段,根据主键来更新符合条件的数据库记录
         *
         * @param record
         */
        public String updateByPrimaryKeySelective(Recomment record) {
            SQL sql = new SQL();
            sql.UPDATE("t_recomment");

            if (record.getRecommentSort() != null) {
                sql.SET("recomment_sort = #{recommentSort,jdbcType=INTEGER}");
            }

            if (record.getRecommentImagPath() != null) {
                sql.SET("recomment_imag_path = #{recommentImagPath,jdbcType=VARCHAR}");
            }

            if (record.getRecommentUrl() != null) {
                sql.SET("recomment_url = #{recommentUrl,jdbcType=VARCHAR}");
            }

            if (record.getRecommentInsertdt() != null) {
                sql.SET("recomment_insertDT = #{recommentInsertdt,jdbcType=TIMESTAMP}");
            }

            if (record.getRecommentUpdatedt() != null) {
                sql.SET("recomment_updateDT = #{recommentUpdatedt,jdbcType=TIMESTAMP}");
            }

            sql.WHERE("recomment_id = #{recommentId,jdbcType=INTEGER}");

            return sql.toString();
        }
    }
}