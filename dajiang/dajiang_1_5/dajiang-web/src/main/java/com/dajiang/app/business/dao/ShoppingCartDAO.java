/* github.com/zhouwd */
package com.dajiang.app.business.dao;

import com.dajiang.app.business.po.dmo.ShoppingCart;
import com.dajiang.app.business.po.resp.ShoppingCartRespDTO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * 本文件由 github.com/zhouwd/mybatis-generator-core 自动生成
 *
 * @author zhouwd code generator
 */
public interface ShoppingCartDAO {
    /**
     * 根据主键删除数据库的记录
     *
     * @param userId
     * @param productId
     */
    @Delete({
            "delete from t_shoppingcart",
            "where user_id=#{userId} and product_id = #{productId,jdbcType=INTEGER}"
    })
    int deleteByUserProduct(@Param("userId") Long userId, @Param("productId") Integer productId);

    /**
     * 动态字段,写入数据库记录
     *
     * @param record
     */
    @InsertProvider(type = ShoppingcartSqlProvider.class, method = "insertSelective")
    int insertSelective(ShoppingCart record);

    /**
     * 根据指定主键获取一条数据库记录
     *
     * @param shoppingcartId
     */
    @Select({
            "select",
            "shoppingcart_id, user_id, product_id, shoppingcart_insertDT, shoppingcart_updateDT",
            "from t_shoppingcart",
            "where shoppingcart_id = #{shoppingcartId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "shoppingcart_id", property = "shoppingcartId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.BIGINT),
            @Result(column = "product_id", property = "productId", jdbcType = JdbcType.INTEGER),
            @Result(column = "shoppingcart_insertDT", property = "shoppingcartInsertdt", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "shoppingcart_updateDT", property = "shoppingcartUpdatedt", jdbcType = JdbcType.TIMESTAMP)
    })
    ShoppingCart selectByPrimaryKey(Integer shoppingcartId);

    @Select({
            "select",
            "shoppingcart_id, user_id, product_id, shoppingcart_insertDT, shoppingcart_updateDT",
            "from t_shoppingcart",
            "where user_id=#{userId} and product_id = #{productId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "shoppingcart_id", property = "shoppingcartId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.BIGINT),
            @Result(column = "product_id", property = "productId", jdbcType = JdbcType.INTEGER),
            @Result(column = "shoppingcart_insertDT", property = "shoppingcartInsertdt", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "shoppingcart_updateDT", property = "shoppingcartUpdatedt", jdbcType = JdbcType.TIMESTAMP)
    })
    ShoppingCart selectByUserProduct(@Param("userId") Long userId, @Param("productId") Integer productId);

    @Select({
            "<script>",
            "select sc.shoppingcart_id , sc.product_id , p.product_title, p.product_sales_num, p.product_author_name , p.product_desc , p.product_price , f_product_type(3 , p.product_id) AS have_flag , p.product_style , sc.shoppingcart_insertDT , sc.shoppingcart_updateDT from t_shoppingcart sc ",
            "left join t_product p on sc.product_id=p.product_id",
            "where sc.user_id=#{userId}",
            "</script>",
    })
    @Results({
            @Result(column = "shoppingcart_id", property = "shoppingcartId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "product_id", property = "productId", jdbcType = JdbcType.INTEGER),
            @Result(column = "product_title", property = "productTitle", jdbcType = JdbcType.VARCHAR),
            @Result(column = "product_author_name", property = "productAuthorName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "product_desc", property = "productDesc", jdbcType = JdbcType.VARCHAR),
            @Result(column = "product_price", property = "productPrice", jdbcType = JdbcType.DECIMAL),
            @Result(column = "have_flag", property = "haveFlag", jdbcType = JdbcType.TINYINT),
            @Result(column = "product_sales_num", property = "orderNum", jdbcType = JdbcType.TINYINT),
            @Result(column = "product_style", property = "productStyle", jdbcType = JdbcType.TINYINT),
            @Result(column = "shoppingcart_insertDT", property = "shoppingcartInsertdt", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "shoppingcart_updateDT", property = "shoppingcartUpdatedt", jdbcType = JdbcType.TIMESTAMP)
    })
    List<ShoppingCartRespDTO> selectList(@Param("userId") Long userId);

    /**
     * 动态字段,根据主键来更新符合条件的数据库记录
     *
     * @param record
     */
    @UpdateProvider(type = ShoppingcartSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ShoppingCart record);

    /**
     * 根据主键来更新符合条件的数据库记录
     *
     * @param record
     */
    @Update({
            "update t_shoppingcart",
            "set user_id = #{userId,jdbcType=BIGINT},",
            "product_id = #{productId,jdbcType=INTEGER},",
            "shoppingcart_insertDT = #{shoppingcartInsertdt,jdbcType=TIMESTAMP},",
            "shoppingcart_updateDT = #{shoppingcartUpdatedt,jdbcType=TIMESTAMP}",
            "where shoppingcart_id = #{shoppingcartId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ShoppingCart record);


    class ShoppingcartSqlProvider {

        /**
         * 动态字段,写入数据库记录
         *
         * @param record
         */
        public String insertSelective(ShoppingCart record) {
            SQL sql = new SQL();
            sql.INSERT_INTO("t_shoppingcart");

            if (record.getShoppingcartId() != null) {
                sql.VALUES("shoppingcart_id", "#{shoppingcartId,jdbcType=INTEGER}");
            }

            if (record.getUserId() != null) {
                sql.VALUES("user_id", "#{userId,jdbcType=BIGINT}");
            }

            if (record.getProductId() != null) {
                sql.VALUES("product_id", "#{productId,jdbcType=INTEGER}");
            }

            if (record.getShoppingcartInsertdt() != null) {
                sql.VALUES("shoppingcart_insertDT", "#{shoppingcartInsertdt,jdbcType=TIMESTAMP}");
            }

            if (record.getShoppingcartUpdatedt() != null) {
                sql.VALUES("shoppingcart_updateDT", "#{shoppingcartUpdatedt,jdbcType=TIMESTAMP}");
            }

            return sql.toString();
        }

        /**
         * 动态字段,根据主键来更新符合条件的数据库记录
         *
         * @param record
         */
        public String updateByPrimaryKeySelective(ShoppingCart record) {
            SQL sql = new SQL();
            sql.UPDATE("t_shoppingcart");

            if (record.getUserId() != null) {
                sql.SET("user_id = #{userId,jdbcType=BIGINT}");
            }

            if (record.getProductId() != null) {
                sql.SET("product_id = #{productId,jdbcType=INTEGER}");
            }

            if (record.getShoppingcartInsertdt() != null) {
                sql.SET("shoppingcart_insertDT = #{shoppingcartInsertdt,jdbcType=TIMESTAMP}");
            }

            if (record.getShoppingcartUpdatedt() != null) {
                sql.SET("shoppingcart_updateDT = #{shoppingcartUpdatedt,jdbcType=TIMESTAMP}");
            }

            sql.WHERE("shoppingcart_id = #{shoppingcartId,jdbcType=INTEGER}");

            return sql.toString();
        }
    }
}