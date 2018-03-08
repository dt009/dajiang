/* github.com/zhouwd */
package com.dajiang.app.kuaiqian.dao;

import com.dajiang.app.kuaiqian.po.resp.KqUserLog;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.type.JdbcType;

/**
 * 本文件由 github.com/zhouwd/mybatis-generator-core 自动生成
 *
 * @author zhouwd code generator
 */
public interface KqUserLogDAO {
    /**
     * 根据主键删除数据库的记录
     *
     * @param kqUserLogId
     */
    @Delete({
            "delete from t_kq_user_log",
            "where kq_user_log_id = #{kqUserLogId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer kqUserLogId);

    /**
     * 动态字段,写入数据库记录
     *
     * @param record
     */
    @InsertProvider(type = KqUserLogSqlProvider.class, method = "insertSelective")
    int insertSelective(KqUserLog record);

    @Select({
            "select",
            "kq_user_log_id, merchant_acctId, version, language, sign_type, pay_type, bank_id, ",
            "order_id, order_time, order_amount, bind_card, bind_mobile, deal_id, bank_deal_id, ",
            "deal_time, pay_amount, fee, ext1, ext2, aggregate_pay, pay_result, err_code, ",
            "sign_msg",
            "from t_kq_user_log",
            "where order_id = #{orderId,jdbcType=VARCHAR} and deal_id=#{dealId}"
    })
    @Results({
            @Result(column = "kq_user_log_id", property = "kqUserLogId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "merchant_acctId", property = "merchantAcctid", jdbcType = JdbcType.VARCHAR),
            @Result(column = "version", property = "version", jdbcType = JdbcType.VARCHAR),
            @Result(column = "language", property = "language", jdbcType = JdbcType.VARCHAR),
            @Result(column = "sign_type", property = "signType", jdbcType = JdbcType.VARCHAR),
            @Result(column = "pay_type", property = "payType", jdbcType = JdbcType.VARCHAR),
            @Result(column = "bank_id", property = "bankId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "order_id", property = "orderId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "order_time", property = "orderTime", jdbcType = JdbcType.VARCHAR),
            @Result(column = "order_amount", property = "orderAmount", jdbcType = JdbcType.VARCHAR),
            @Result(column = "bind_card", property = "bindCard", jdbcType = JdbcType.VARCHAR),
            @Result(column = "bind_mobile", property = "bindMobile", jdbcType = JdbcType.VARCHAR),
            @Result(column = "deal_id", property = "dealId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "bank_deal_id", property = "bankDealId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "deal_time", property = "dealTime", jdbcType = JdbcType.VARCHAR),
            @Result(column = "pay_amount", property = "payAmount", jdbcType = JdbcType.VARCHAR),
            @Result(column = "fee", property = "fee", jdbcType = JdbcType.VARCHAR),
            @Result(column = "ext1", property = "ext1", jdbcType = JdbcType.VARCHAR),
            @Result(column = "ext2", property = "ext2", jdbcType = JdbcType.VARCHAR),
            @Result(column = "aggregate_pay", property = "aggregatePay", jdbcType = JdbcType.VARCHAR),
            @Result(column = "pay_result", property = "payResult", jdbcType = JdbcType.VARCHAR),
            @Result(column = "err_code", property = "errCode", jdbcType = JdbcType.VARCHAR),
            @Result(column = "sign_msg", property = "signMsg", jdbcType = JdbcType.VARCHAR)
    })
    KqUserLog selectByOrderIdDealId(@Param("orderId") String orderId, @Param("dealId") String dealId);


    /**
     * 根据指定主键获取一条数据库记录
     *
     * @param kqUserLogId
     */
    @Select({
            "select",
            "kq_user_log_id, merchant_acctId, version, language, sign_type, pay_type, bank_id, ",
            "order_id, order_time, order_amount, bind_card, bind_mobile, deal_id, bank_deal_id, ",
            "deal_time, pay_amount, fee, ext1, ext2, aggregate_pay, pay_result, err_code, ",
            "sign_msg",
            "from t_kq_user_log",
            "where kq_user_log_id = #{kqUserLogId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "kq_user_log_id", property = "kqUserLogId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "merchant_acctId", property = "merchantAcctid", jdbcType = JdbcType.VARCHAR),
            @Result(column = "version", property = "version", jdbcType = JdbcType.VARCHAR),
            @Result(column = "language", property = "language", jdbcType = JdbcType.VARCHAR),
            @Result(column = "sign_type", property = "signType", jdbcType = JdbcType.VARCHAR),
            @Result(column = "pay_type", property = "payType", jdbcType = JdbcType.VARCHAR),
            @Result(column = "bank_id", property = "bankId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "order_id", property = "orderId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "order_time", property = "orderTime", jdbcType = JdbcType.VARCHAR),
            @Result(column = "order_amount", property = "orderAmount", jdbcType = JdbcType.VARCHAR),
            @Result(column = "bind_card", property = "bindCard", jdbcType = JdbcType.VARCHAR),
            @Result(column = "bind_mobile", property = "bindMobile", jdbcType = JdbcType.VARCHAR),
            @Result(column = "deal_id", property = "dealId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "bank_deal_id", property = "bankDealId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "deal_time", property = "dealTime", jdbcType = JdbcType.VARCHAR),
            @Result(column = "pay_amount", property = "payAmount", jdbcType = JdbcType.VARCHAR),
            @Result(column = "fee", property = "fee", jdbcType = JdbcType.VARCHAR),
            @Result(column = "ext1", property = "ext1", jdbcType = JdbcType.VARCHAR),
            @Result(column = "ext2", property = "ext2", jdbcType = JdbcType.VARCHAR),
            @Result(column = "aggregate_pay", property = "aggregatePay", jdbcType = JdbcType.VARCHAR),
            @Result(column = "pay_result", property = "payResult", jdbcType = JdbcType.VARCHAR),
            @Result(column = "err_code", property = "errCode", jdbcType = JdbcType.VARCHAR),
            @Result(column = "sign_msg", property = "signMsg", jdbcType = JdbcType.VARCHAR)
    })
    KqUserLog selectByPrimaryKey(Integer kqUserLogId);

    /**
     * 动态字段,根据主键来更新符合条件的数据库记录
     *
     * @param record
     */
    @UpdateProvider(type = KqUserLogSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(KqUserLog record);

    /**
     * 根据主键来更新符合条件的数据库记录
     *
     * @param record
     */
    @Update({
            "update t_kq_user_log",
            "set merchant_acctId = #{merchantAcctid,jdbcType=VARCHAR},",
            "version = #{version,jdbcType=VARCHAR},",
            "language = #{language,jdbcType=VARCHAR},",
            "sign_type = #{signType,jdbcType=VARCHAR},",
            "pay_type = #{payType,jdbcType=VARCHAR},",
            "bank_id = #{bankId,jdbcType=VARCHAR},",
            "order_id = #{orderId,jdbcType=VARCHAR},",
            "order_time = #{orderTime,jdbcType=VARCHAR},",
            "order_amount = #{orderAmount,jdbcType=VARCHAR},",
            "bind_card = #{bindCard,jdbcType=VARCHAR},",
            "bind_mobile = #{bindMobile,jdbcType=VARCHAR},",
            "deal_id = #{dealId,jdbcType=VARCHAR},",
            "bank_deal_id = #{bankDealId,jdbcType=VARCHAR},",
            "deal_time = #{dealTime,jdbcType=VARCHAR},",
            "pay_amount = #{payAmount,jdbcType=VARCHAR},",
            "fee = #{fee,jdbcType=VARCHAR},",
            "ext1 = #{ext1,jdbcType=VARCHAR},",
            "ext2 = #{ext2,jdbcType=VARCHAR},",
            "aggregate_pay = #{aggregatePay,jdbcType=VARCHAR},",
            "pay_result = #{payResult,jdbcType=VARCHAR},",
            "err_code = #{errCode,jdbcType=VARCHAR},",
            "sign_msg = #{signMsg,jdbcType=VARCHAR}",
            "where kq_user_log_id = #{kqUserLogId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(KqUserLog record);

    class KqUserLogSqlProvider {

        /**
         * 动态字段,写入数据库记录
         *
         * @param record
         */
        public String insertSelective(KqUserLog record) {
            SQL sql = new SQL();
            sql.INSERT_INTO("t_kq_user_log");

            if (record.getKqUserLogId() != null) {
                sql.VALUES("kq_user_log_id", "#{kqUserLogId,jdbcType=INTEGER}");
            }

            if (record.getMerchantAcctid() != null) {
                sql.VALUES("merchant_acctId", "#{merchantAcctid,jdbcType=VARCHAR}");
            }

            if (record.getVersion() != null) {
                sql.VALUES("version", "#{version,jdbcType=VARCHAR}");
            }

            if (record.getLanguage() != null) {
                sql.VALUES("language", "#{language,jdbcType=VARCHAR}");
            }

            if (record.getSignType() != null) {
                sql.VALUES("sign_type", "#{signType,jdbcType=VARCHAR}");
            }

            if (record.getPayType() != null) {
                sql.VALUES("pay_type", "#{payType,jdbcType=VARCHAR}");
            }

            if (record.getBankId() != null) {
                sql.VALUES("bank_id", "#{bankId,jdbcType=VARCHAR}");
            }

            if (record.getOrderId() != null) {
                sql.VALUES("order_id", "#{orderId,jdbcType=VARCHAR}");
            }

            if (record.getOrderTime() != null) {
                sql.VALUES("order_time", "#{orderTime,jdbcType=VARCHAR}");
            }

            if (record.getOrderAmount() != null) {
                sql.VALUES("order_amount", "#{orderAmount,jdbcType=VARCHAR}");
            }

            if (record.getBindCard() != null) {
                sql.VALUES("bind_card", "#{bindCard,jdbcType=VARCHAR}");
            }

            if (record.getBindMobile() != null) {
                sql.VALUES("bind_mobile", "#{bindMobile,jdbcType=VARCHAR}");
            }

            if (record.getDealId() != null) {
                sql.VALUES("deal_id", "#{dealId,jdbcType=VARCHAR}");
            }

            if (record.getBankDealId() != null) {
                sql.VALUES("bank_deal_id", "#{bankDealId,jdbcType=VARCHAR}");
            }

            if (record.getDealTime() != null) {
                sql.VALUES("deal_time", "#{dealTime,jdbcType=VARCHAR}");
            }

            if (record.getPayAmount() != null) {
                sql.VALUES("pay_amount", "#{payAmount,jdbcType=VARCHAR}");
            }

            if (record.getFee() != null) {
                sql.VALUES("fee", "#{fee,jdbcType=VARCHAR}");
            }

            if (record.getExt1() != null) {
                sql.VALUES("ext1", "#{ext1,jdbcType=VARCHAR}");
            }

            if (record.getExt2() != null) {
                sql.VALUES("ext2", "#{ext2,jdbcType=VARCHAR}");
            }

            if (record.getAggregatePay() != null) {
                sql.VALUES("aggregate_pay", "#{aggregatePay,jdbcType=VARCHAR}");
            }

            if (record.getPayResult() != null) {
                sql.VALUES("pay_result", "#{payResult,jdbcType=VARCHAR}");
            }

            if (record.getErrCode() != null) {
                sql.VALUES("err_code", "#{errCode,jdbcType=VARCHAR}");
            }

            if (record.getSignMsg() != null) {
                sql.VALUES("sign_msg", "#{signMsg,jdbcType=VARCHAR}");
            }

            return sql.toString();
        }

        /**
         * 动态字段,根据主键来更新符合条件的数据库记录
         *
         * @param record
         */
        public String updateByPrimaryKeySelective(KqUserLog record) {
            SQL sql = new SQL();
            sql.UPDATE("t_kq_user_log");

            if (record.getMerchantAcctid() != null) {
                sql.SET("merchant_acctId = #{merchantAcctid,jdbcType=VARCHAR}");
            }

            if (record.getVersion() != null) {
                sql.SET("version = #{version,jdbcType=VARCHAR}");
            }

            if (record.getLanguage() != null) {
                sql.SET("language = #{language,jdbcType=VARCHAR}");
            }

            if (record.getSignType() != null) {
                sql.SET("sign_type = #{signType,jdbcType=VARCHAR}");
            }

            if (record.getPayType() != null) {
                sql.SET("pay_type = #{payType,jdbcType=VARCHAR}");
            }

            if (record.getBankId() != null) {
                sql.SET("bank_id = #{bankId,jdbcType=VARCHAR}");
            }

            if (record.getOrderId() != null) {
                sql.SET("order_id = #{orderId,jdbcType=VARCHAR}");
            }

            if (record.getOrderTime() != null) {
                sql.SET("order_time = #{orderTime,jdbcType=VARCHAR}");
            }

            if (record.getOrderAmount() != null) {
                sql.SET("order_amount = #{orderAmount,jdbcType=VARCHAR}");
            }

            if (record.getBindCard() != null) {
                sql.SET("bind_card = #{bindCard,jdbcType=VARCHAR}");
            }

            if (record.getBindMobile() != null) {
                sql.SET("bind_mobile = #{bindMobile,jdbcType=VARCHAR}");
            }

            if (record.getDealId() != null) {
                sql.SET("deal_id = #{dealId,jdbcType=VARCHAR}");
            }

            if (record.getBankDealId() != null) {
                sql.SET("bank_deal_id = #{bankDealId,jdbcType=VARCHAR}");
            }

            if (record.getDealTime() != null) {
                sql.SET("deal_time = #{dealTime,jdbcType=VARCHAR}");
            }

            if (record.getPayAmount() != null) {
                sql.SET("pay_amount = #{payAmount,jdbcType=VARCHAR}");
            }

            if (record.getFee() != null) {
                sql.SET("fee = #{fee,jdbcType=VARCHAR}");
            }

            if (record.getExt1() != null) {
                sql.SET("ext1 = #{ext1,jdbcType=VARCHAR}");
            }

            if (record.getExt2() != null) {
                sql.SET("ext2 = #{ext2,jdbcType=VARCHAR}");
            }

            if (record.getAggregatePay() != null) {
                sql.SET("aggregate_pay = #{aggregatePay,jdbcType=VARCHAR}");
            }

            if (record.getPayResult() != null) {
                sql.SET("pay_result = #{payResult,jdbcType=VARCHAR}");
            }

            if (record.getErrCode() != null) {
                sql.SET("err_code = #{errCode,jdbcType=VARCHAR}");
            }

            if (record.getSignMsg() != null) {
                sql.SET("sign_msg = #{signMsg,jdbcType=VARCHAR}");
            }

            sql.WHERE("kq_user_log_id = #{kqUserLogId,jdbcType=INTEGER}");

            return sql.toString();
        }
    }
}