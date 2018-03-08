/* github.com/zhouwd */
package com.dajiang.app.business.dao;

import com.dajiang.app.business.po.dmo.ProductUser;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.type.JdbcType;

/**
 * 本文件由 github.com/zhouwd/mybatis-generator-core 自动生成
 *
 * @author zhouwd code generator
 */
public interface ProductUserDAO {
    /**
     * 根据主键删除数据库的记录
     *
     * @param productUserId
     */
    @Delete({
            "delete from t_product_user",
            "where product_user_id = #{productUserId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer productUserId);

    /**
     * 动态字段,写入数据库记录
     *
     * @param record
     */
    @InsertProvider(type = ProductUserSqlProvider.class, method = "insertSelective")
    int insertSelective(ProductUser record);

    /**
     * 根据指定主键获取一条数据库记录
     *
     * @param productUserId
     */
    @Select({
            "select",
            "product_user_id, user_id, product_id, product_user_parent_id, product_type, ",
            "product_user_isowner, product_user_insert_dt",
            "from t_product_user",
            "where product_user_id = #{productUserId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "product_user_id", property = "productUserId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.BIGINT),
            @Result(column = "product_id", property = "productId", jdbcType = JdbcType.INTEGER),
            @Result(column = "product_user_parent_id", property = "productUserParentId", jdbcType = JdbcType.BIGINT),
            @Result(column = "product_type", property = "productType", jdbcType = JdbcType.TINYINT),
            @Result(column = "product_user_isowner", property = "productUserIsowner", jdbcType = JdbcType.TINYINT),
            @Result(column = "product_user_insert_dt", property = "productUserInsertDt", jdbcType = JdbcType.TIMESTAMP)
    })
    ProductUser selectByPrimaryKey(Integer productUserId);

    @Select({
            "select",
            "user_id, product_id, product_user_parent_id, product_type, ",
            "product_user_isowner, product_user_insert_dt",
            "from t_product_user",
            "where product_user_isowner = 1 and product_id=#{productId}"
    })
    @Results({
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.BIGINT),
            @Result(column = "product_id", property = "productId", jdbcType = JdbcType.INTEGER),
            @Result(column = "product_user_parent_id", property = "productUserParentId", jdbcType = JdbcType.BIGINT),
            @Result(column = "product_type", property = "productType", jdbcType = JdbcType.TINYINT),
            @Result(column = "product_user_isowner", property = "productUserIsowner", jdbcType = JdbcType.TINYINT),
            @Result(column = "product_user_insert_dt", property = "productUserInsertDt", jdbcType = JdbcType.TIMESTAMP)
    })
    ProductUser selectByProductId(@Param("productId") Integer productId);

    @Select({
            "select",
            "user_id, product_id, product_user_parent_id, product_type, ",
            "product_user_isowner, product_user_insert_dt",
            "from t_product_user",
            "where product_user_isowner = 1 and product_id=#{productId} and user_id=#{userId}"
    })
    @Results({
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.BIGINT),
            @Result(column = "product_id", property = "productId", jdbcType = JdbcType.INTEGER),
            @Result(column = "product_user_parent_id", property = "productUserParentId", jdbcType = JdbcType.BIGINT),
            @Result(column = "product_type", property = "productType", jdbcType = JdbcType.TINYINT),
            @Result(column = "product_user_isowner", property = "productUserIsowner", jdbcType = JdbcType.TINYINT),
            @Result(column = "product_user_insert_dt", property = "productUserInsertDt", jdbcType = JdbcType.TIMESTAMP)
    })
    ProductUser selectForAudit(@Param("userId") Long userId, @Param("productId") Integer productId);

    @Update({
            "update t_product_user",
            "set ",
            "product_user_isowner = 0",
            "where product_id = #{productId,jdbcType=INTEGER}"
    })
    int updateNoOwnerByProductId(Integer productId);
    /**
     * 动态字段,根据主键来更新符合条件的数据库记录
     *
     * @param record
     */
    @UpdateProvider(type = ProductUserSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ProductUser record);

    /**
     * 根据主键来更新符合条件的数据库记录
     *
     * @param record
     */
    @Update({
            "update t_product_user",
            "set user_id = #{userId,jdbcType=BIGINT},",
            "product_id = #{productId,jdbcType=INTEGER},",
            "product_user_parent_id = #{productUserParentId,jdbcType=BIGINT},",
            "product_type = #{productType,jdbcType=TINYINT},",
            "product_user_isowner = #{productUserIsowner,jdbcType=TINYINT},",
            "product_user_insert_dt = #{productUserInsertDt,jdbcType=TIMESTAMP}",
            "where product_user_id = #{productUserId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ProductUser record);


    class ProductUserSqlProvider {

        /**
         * 动态字段,写入数据库记录
         *
         * @param record
         */
        public String insertSelective(ProductUser record) {
            SQL sql = new SQL();
            sql.INSERT_INTO("t_product_user");

            if (record.getProductUserId() != null) {
                sql.VALUES("product_user_id", "#{productUserId,jdbcType=INTEGER}");
            }

            if (record.getUserId() != null) {
                sql.VALUES("user_id", "#{userId,jdbcType=BIGINT}");
            }

            if (record.getProductId() != null) {
                sql.VALUES("product_id", "#{productId,jdbcType=INTEGER}");
            }

            if (record.getProductUserParentId() != null) {
                sql.VALUES("product_user_parent_id", "#{productUserParentId,jdbcType=BIGINT}");
            }

            if (record.getProductType() != null) {
                sql.VALUES("product_type", "#{productType,jdbcType=TINYINT}");
            }

            if (record.getProductUserIsowner() != null) {
                sql.VALUES("product_user_isowner", "#{productUserIsowner,jdbcType=TINYINT}");
            }

            if (record.getProductUserInsertDt() != null) {
                sql.VALUES("product_user_insert_dt", "#{productUserInsertDt,jdbcType=TIMESTAMP}");
            }

            return sql.toString();
        }

        /**
         * 动态字段,根据主键来更新符合条件的数据库记录
         *
         * @param record
         */
        public String updateByPrimaryKeySelective(ProductUser record) {
            SQL sql = new SQL();
            sql.UPDATE("t_product_user");

            if (record.getUserId() != null) {
                sql.SET("user_id = #{userId,jdbcType=BIGINT}");
            }

            if (record.getProductId() != null) {
                sql.SET("product_id = #{productId,jdbcType=INTEGER}");
            }

            if (record.getProductUserParentId() != null) {
                sql.SET("product_user_parent_id = #{productUserParentId,jdbcType=BIGINT}");
            }

            if (record.getProductType() != null) {
                sql.SET("product_type = #{productType,jdbcType=TINYINT}");
            }

            if (record.getProductUserIsowner() != null) {
                sql.SET("product_user_isowner = #{productUserIsowner,jdbcType=TINYINT}");
            }

            if (record.getProductUserInsertDt() != null) {
                sql.SET("product_user_insert_dt = #{productUserInsertDt,jdbcType=TIMESTAMP}");
            }

            sql.WHERE("product_user_id = #{productUserId,jdbcType=INTEGER}");

            return sql.toString();
        }
    }
}