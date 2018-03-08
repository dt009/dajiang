/* github.com/zhouwd */
package com.dajiang.app.business.dao;

import com.dajiang.app.business.po.dmo.ProductDetail;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * 本文件由 github.com/zhouwd/mybatis-generator-core 自动生成
 *
 * @author zhouwd code generator
 */
public interface ProductDetailDAO {
    /**
     * 根据主键删除数据库的记录
     *
     * @param productDetailId
     */
    @Delete({
            "delete from t_product_detail",
            "where product_detail_id = #{productDetailId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer productDetailId);

    /**
     * 动态字段,写入数据库记录
     *
     * @param record
     */
    @InsertProvider(type = ProductDetailSqlProvider.class, method = "insertSelective")
    int insertSelective(ProductDetail record);

    /**
     * 根据指定主键获取一条数据库记录
     *
     * @param productDetailId
     */
    @Select({
            "select",
            "product_detail_id, product_detail_title, product_id, PRODUCT_DETAIL_TYPE, product_path, ",
            "product_detail_url, product_detail_desc, product_detail_sort",
            "from t_product_detail",
            "where product_detail_id = #{productDetailId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "product_detail_id", property = "productDetailId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "product_detail_title", property = "productDetailTitle", jdbcType = JdbcType.VARCHAR),
            @Result(column = "product_id", property = "productId", jdbcType = JdbcType.INTEGER),
            @Result(column = "PRODUCT_DETAIL_TYPE", property = "productDetailType", jdbcType = JdbcType.INTEGER),
            @Result(column = "product_path", property = "productPath", jdbcType = JdbcType.VARCHAR),
            @Result(column = "product_detail_url", property = "productDetailUrl", jdbcType = JdbcType.VARCHAR),
            @Result(column = "product_detail_desc", property = "productDetailDesc", jdbcType = JdbcType.VARCHAR),
            @Result(column = "product_detail_sort", property = "productDetailSort", jdbcType = JdbcType.INTEGER)
    })
    ProductDetail selectByPrimaryKey(Integer productDetailId);

    @Select({
            "select",
            "product_detail_id, product_detail_title, product_id, PRODUCT_DETAIL_TYPE, product_path, ",
            "product_detail_url, product_detail_desc, product_detail_sort",
            "from t_product_detail",
            "where product_id = #{productId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "product_detail_id", property = "productDetailId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "product_detail_title", property = "productDetailTitle", jdbcType = JdbcType.VARCHAR),
            @Result(column = "product_id", property = "productId", jdbcType = JdbcType.INTEGER),
            @Result(column = "PRODUCT_DETAIL_TYPE", property = "productDetailType", jdbcType = JdbcType.INTEGER),
            @Result(column = "product_path", property = "productPath", jdbcType = JdbcType.VARCHAR),
            @Result(column = "product_detail_url", property = "productDetailUrl", jdbcType = JdbcType.VARCHAR),
            @Result(column = "product_detail_desc", property = "productDetailDesc", jdbcType = JdbcType.VARCHAR),
            @Result(column = "product_detail_sort", property = "productDetailSort", jdbcType = JdbcType.INTEGER)
    })
    List<ProductDetail> selectByProductId(@Param("productId") Integer productId);

    /**
     * 动态字段,根据主键来更新符合条件的数据库记录
     *
     * @param record
     */
    @UpdateProvider(type = ProductDetailSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ProductDetail record);

    /**
     * 根据主键来更新符合条件的数据库记录
     *
     * @param record
     */
    @Update({
            "update t_product_detail",
            "set product_detail_title = #{productDetailTitle,jdbcType=VARCHAR},",
            "product_id = #{productId,jdbcType=INTEGER},",
            "PRODUCT_DETAIL_TYPE = #{productDetailType,jdbcType=INTEGER},",
            "product_path = #{productPath,jdbcType=VARCHAR},",
            "product_detail_url = #{productDetailUrl,jdbcType=VARCHAR},",
            "product_detail_desc = #{productDetailDesc,jdbcType=VARCHAR},",
            "product_detail_sort = #{productDetailSort,jdbcType=INTEGER}",
            "where product_detail_id = #{productDetailId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ProductDetail record);

    class ProductDetailSqlProvider {

        /**
         * 动态字段,写入数据库记录
         *
         * @param record
         */
        public String insertSelective(ProductDetail record) {
            SQL sql = new SQL();
            sql.INSERT_INTO("t_product_detail");

            if (record.getProductDetailId() != null) {
                sql.VALUES("product_detail_id", "#{productDetailId,jdbcType=INTEGER}");
            }

            if (record.getProductDetailTitle() != null) {
                sql.VALUES("product_detail_title", "#{productDetailTitle,jdbcType=VARCHAR}");
            }

            if (record.getProductId() != null) {
                sql.VALUES("product_id", "#{productId,jdbcType=INTEGER}");
            }

            if (record.getProductDetailType() != null) {
                sql.VALUES("PRODUCT_DETAIL_TYPE", "#{productDetailType,jdbcType=INTEGER}");
            }

            if (record.getProductPath() != null) {
                sql.VALUES("product_path", "#{productPath,jdbcType=VARCHAR}");
            }

            if (record.getProductDetailUrl() != null) {
                sql.VALUES("product_detail_url", "#{productDetailUrl,jdbcType=VARCHAR}");
            }

            if (record.getProductDetailDesc() != null) {
                sql.VALUES("product_detail_desc", "#{productDetailDesc,jdbcType=VARCHAR}");
            }

            if (record.getProductDetailSort() != null) {
                sql.VALUES("product_detail_sort", "#{productDetailSort,jdbcType=INTEGER}");
            }

            return sql.toString();
        }

        /**
         * 动态字段,根据主键来更新符合条件的数据库记录
         *
         * @param record
         */
        public String updateByPrimaryKeySelective(ProductDetail record) {
            SQL sql = new SQL();
            sql.UPDATE("t_product_detail");

            if (record.getProductDetailTitle() != null) {
                sql.SET("product_detail_title = #{productDetailTitle,jdbcType=VARCHAR}");
            }

            if (record.getProductId() != null) {
                sql.SET("product_id = #{productId,jdbcType=INTEGER}");
            }

            if (record.getProductDetailType() != null) {
                sql.SET("PRODUCT_DETAIL_TYPE = #{productDetailType,jdbcType=INTEGER}");
            }

            if (record.getProductPath() != null) {
                sql.SET("product_path = #{productPath,jdbcType=VARCHAR}");
            }

            if (record.getProductDetailUrl() != null) {
                sql.SET("product_detail_url = #{productDetailUrl,jdbcType=VARCHAR}");
            }

            if (record.getProductDetailDesc() != null) {
                sql.SET("product_detail_desc = #{productDetailDesc,jdbcType=VARCHAR}");
            }

            if (record.getProductDetailSort() != null) {
                sql.SET("product_detail_sort = #{productDetailSort,jdbcType=INTEGER}");
            }

            sql.WHERE("product_detail_id = #{productDetailId,jdbcType=INTEGER}");

            return sql.toString();
        }
    }
}