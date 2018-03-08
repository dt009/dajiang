/* github.com/zhouwd */
package com.dajiang.app.business.dao;

import com.dajiang.app.business.po.dmo.Order;
import com.dajiang.app.business.po.resp.OrderRespDTO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.type.JdbcType;

/**
 * 本文件由 github.com/zhouwd/mybatis-generator-core 自动生成
 *
 * @author zhouwd code generator
 */
public interface OrderDAO {
    /**
     * 根据主键删除数据库的记录
     *
     * @param orderId
     */
    @Delete({
            "delete from t_order",
            "where order_id = #{orderId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer orderId);

    /**
     * 动态字段,写入数据库记录
     *
     * @param record
     */
    @InsertProvider(type = OrderSqlProvider.class, method = "insertSelective")
    int insertSelective(Order record);

    /**
     * 根据指定主键获取一条数据库记录
     *
     * @param orderId
     */
    @Select({
            "select",
            "order_id, order_Code, user_id_sales, user_id_purchase, product_id, order_amount, ",
            "order_commission, order_paytype, order_payreturn, order_DT",
            "from t_order",
            "where order_id = #{orderId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "order_id", property = "orderId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "order_Code", property = "orderCode", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_id_sales", property = "userIdSales", jdbcType = JdbcType.BIGINT),
            @Result(column = "user_id_purchase", property = "userIdPurchase", jdbcType = JdbcType.BIGINT),
            @Result(column = "product_id", property = "productId", jdbcType = JdbcType.INTEGER),
            @Result(column = "order_amount", property = "orderAmount", jdbcType = JdbcType.DECIMAL),
            @Result(column = "order_commission", property = "orderCommission", jdbcType = JdbcType.DECIMAL),
            @Result(column = "order_paytype", property = "orderPaytype", jdbcType = JdbcType.INTEGER),
            @Result(column = "order_payreturn", property = "orderPayreturn", jdbcType = JdbcType.VARCHAR),
            @Result(column = "order_DT", property = "orderDt", jdbcType = JdbcType.TIMESTAMP)
    })
    Order selectByPrimaryKey(Integer orderId);

    /**
     * 动态字段,根据主键来更新符合条件的数据库记录
     *
     * @param record
     */
    @UpdateProvider(type = OrderSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Order record);

    /**
     * 根据主键来更新符合条件的数据库记录
     *
     * @param record
     */
    @Update({
            "update t_order",
            "set order_Code = #{orderCode,jdbcType=VARCHAR},",
            "user_id_sales = #{userIdSales,jdbcType=BIGINT},",
            "user_id_purchase = #{userIdPurchase,jdbcType=BIGINT},",
            "product_id = #{productId,jdbcType=INTEGER},",
            "order_amount = #{orderAmount,jdbcType=DECIMAL},",
            "order_commission = #{orderCommission,jdbcType=DECIMAL},",
            "order_paytype = #{orderPaytype,jdbcType=INTEGER},",
            "order_payreturn = #{orderPayreturn,jdbcType=VARCHAR},",
            "order_DT = #{orderDt,jdbcType=TIMESTAMP}",
            "where order_id = #{orderId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Order record);

    @Select({
            "call p_back_order_detail(#{orderId})",
    })
    @Results({
            @Result(column = "order_Code", property = "orderCode", jdbcType = JdbcType.VARCHAR),
            @Result(column = "product_id", property = "productId", jdbcType = JdbcType.INTEGER),
            @Result(column = "product_title", property = "productTitle", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_id_buyer", property = "userIdBuyer", jdbcType = JdbcType.INTEGER),
            @Result(column = "order_amount", property = "orderAmount", jdbcType = JdbcType.DECIMAL),
            @Result(column = "order_paytype", property = "orderPaytype", jdbcType = JdbcType.INTEGER),
            @Result(column = "order_DT", property = "orderDt", jdbcType = JdbcType.TIMESTAMP)
    })
    OrderRespDTO selectOrderById(@Param("orderId") Integer orderId);

    @Select({
            "call p_back_init_order(#{userId}, #{productId})",
    })
    @Results({
            @Result(column = "orderid", property = "orderId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "ordercode", property = "orderCode", jdbcType = JdbcType.VARCHAR),
            @Result(column = "producttitle", property = "productTitle", jdbcType = JdbcType.VARCHAR),
            @Result(column = "order_amount", property = "orderAmount", jdbcType = JdbcType.DECIMAL),
            @Result(column = "orderdt", property = "orderDt", jdbcType = JdbcType.TIMESTAMP)
    })
    OrderRespDTO insertNewOrder(@Param("userId") Long userId, @Param("productId") Integer productId);

    @Select({
            "call p_back_payment (#{inviteCode}, #{orderId})",
    })
    int payOrder(@Param("inviteCode") String inviteCode, @Param("orderId") Integer orderId);

    @Select({
            "call p_back_payment_lock(#{orderId})"
    })
    int lockPayOrder(@Param("orderId") Integer orderId);

    class OrderSqlProvider {

        /**
         * 动态字段,写入数据库记录
         *
         * @param record
         */
        public String insertSelective(Order record) {
            SQL sql = new SQL();
            sql.INSERT_INTO("t_order");

            if (record.getOrderId() != null) {
                sql.VALUES("order_id", "#{orderId,jdbcType=INTEGER}");
            }

            if (record.getOrderCode() != null) {
                sql.VALUES("order_Code", "#{orderCode,jdbcType=VARCHAR}");
            }

            if (record.getUserIdSales() != null) {
                sql.VALUES("user_id_sales", "#{userIdSales,jdbcType=BIGINT}");
            }

            if (record.getUserIdPurchase() != null) {
                sql.VALUES("user_id_purchase", "#{userIdPurchase,jdbcType=BIGINT}");
            }

            if (record.getProductId() != null) {
                sql.VALUES("product_id", "#{productId,jdbcType=INTEGER}");
            }

            if (record.getOrderAmount() != null) {
                sql.VALUES("order_amount", "#{orderAmount,jdbcType=DECIMAL}");
            }

            if (record.getOrderCommission() != null) {
                sql.VALUES("order_commission", "#{orderCommission,jdbcType=DECIMAL}");
            }

            if (record.getOrderPaytype() != null) {
                sql.VALUES("order_paytype", "#{orderPaytype,jdbcType=INTEGER}");
            }

            if (record.getOrderPayreturn() != null) {
                sql.VALUES("order_payreturn", "#{orderPayreturn,jdbcType=VARCHAR}");
            }

            if (record.getOrderDt() != null) {
                sql.VALUES("order_DT", "#{orderDt,jdbcType=TIMESTAMP}");
            }

            return sql.toString();
        }

        /**
         * 动态字段,根据主键来更新符合条件的数据库记录
         *
         * @param record
         */
        public String updateByPrimaryKeySelective(Order record) {
            SQL sql = new SQL();
            sql.UPDATE("t_order");

            if (record.getOrderCode() != null) {
                sql.SET("order_Code = #{orderCode,jdbcType=VARCHAR}");
            }

            if (record.getUserIdSales() != null) {
                sql.SET("user_id_sales = #{userIdSales,jdbcType=BIGINT}");
            }

            if (record.getUserIdPurchase() != null) {
                sql.SET("user_id_purchase = #{userIdPurchase,jdbcType=BIGINT}");
            }

            if (record.getProductId() != null) {
                sql.SET("product_id = #{productId,jdbcType=INTEGER}");
            }

            if (record.getOrderAmount() != null) {
                sql.SET("order_amount = #{orderAmount,jdbcType=DECIMAL}");
            }

            if (record.getOrderCommission() != null) {
                sql.SET("order_commission = #{orderCommission,jdbcType=DECIMAL}");
            }

            if (record.getOrderPaytype() != null) {
                sql.SET("order_paytype = #{orderPaytype,jdbcType=INTEGER}");
            }

            if (record.getOrderPayreturn() != null) {
                sql.SET("order_payreturn = #{orderPayreturn,jdbcType=VARCHAR}");
            }

            if (record.getOrderDt() != null) {
                sql.SET("order_DT = #{orderDt,jdbcType=TIMESTAMP}");
            }

            sql.WHERE("order_id = #{orderId,jdbcType=INTEGER}");

            return sql.toString();
        }
    }
}