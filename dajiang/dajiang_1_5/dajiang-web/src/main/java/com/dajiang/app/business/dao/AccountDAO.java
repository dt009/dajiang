/* github.com/zhouwd */
package com.dajiang.app.business.dao;

import com.dajiang.app.business.po.dmo.Account;
import com.dajiang.app.business.po.dmo.AccountWithdraw;
import com.dajiang.app.business.po.req.RechargeReqDTO;
import com.dajiang.app.business.po.resp.AccountHisRespDTO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.type.JdbcType;

import java.math.BigDecimal;
import java.util.List;

/**
 * 本文件由 github.com/zhouwd/mybatis-generator-core 自动生成
 *
 * @author zhouwd code generator
 */
public interface AccountDAO {
    /**
     * 根据主键删除数据库的记录
     *
     * @param accountId
     */
    @Delete({
            "delete from t_account",
            "where account_id = #{accountId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer accountId);

    /**
     * 动态字段,写入数据库记录
     *
     * @param record
     */
    @InsertProvider(type = AccountSqlProvider.class, method = "insertSelective")
    int insertSelective(Account record);

    /**
     * 根据指定主键获取一条数据库记录
     *
     * @param accountId
     */
    @Select({
            "select",
            "account_id, user_id, account_type, order_id, account_amount, account_balance, ",
            "account_desc, account_insertDT",
            "from t_account",
            "where account_id = #{accountId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "account_id", property = "accountId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.BIGINT),
            @Result(column = "account_type", property = "accountType", jdbcType = JdbcType.BIT),
            @Result(column = "order_id", property = "orderId", jdbcType = JdbcType.INTEGER),
            @Result(column = "account_amount", property = "accountAmount", jdbcType = JdbcType.DECIMAL),
            @Result(column = "account_balance", property = "accountBalance", jdbcType = JdbcType.DECIMAL),
            @Result(column = "account_desc", property = "accountDesc", jdbcType = JdbcType.VARCHAR),
            @Result(column = "account_insertDT", property = "accountInsertdt", jdbcType = JdbcType.TIMESTAMP)
    })
    Account selectByPrimaryKey(Integer accountId);

    /**
     * 动态字段,根据主键来更新符合条件的数据库记录
     *
     * @param record
     */
    @UpdateProvider(type = AccountSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Account record);

    /**
     * 根据主键来更新符合条件的数据库记录
     *
     * @param record
     */
    @Update({
            "update t_account",
            "set user_id = #{userId,jdbcType=BIGINT},",
            "account_type = #{accountType,jdbcType=BIT},",
            "order_id = #{orderId,jdbcType=INTEGER},",
            "account_amount = #{accountAmount,jdbcType=DECIMAL},",
            "account_balance = #{accountBalance,jdbcType=DECIMAL},",
            "account_desc = #{accountDesc,jdbcType=VARCHAR},",
            "account_insertDT = #{accountInsertdt,jdbcType=TIMESTAMP}",
            "where account_id = #{accountId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Account record);

    /**
     * 查询全部余额
     *
     * @param userId
     * @return
     */
    @Select({
            "call p_back_init_recharge(#{userId})"
    })
    BigDecimal initAllBalance(@Param("userId") Long userId);


    @Select({
            "call p_back_recharge(#{reqDTO.userId},#{reqDTO.amount})"
    })
    int rechargeAccount(@Param("reqDTO") RechargeReqDTO reqDTO);

    /**
     * 查询可提现金额
     * @param userId
     * @return
     */
    @Select({
            "call p_back_init_balance(#{userId})"
    })
    BigDecimal initWithdrawal(Long userId);


    @Select({
            "call p_back_account_list(#{userId},#{dayStr})"
    })
    @Results({
            @Result(column = "account_type", property = "accountType", jdbcType = JdbcType.BIT),
            @Result(column = "order_id", property = "orderId", jdbcType = JdbcType.INTEGER),
            @Result(column = "account_amount", property = "accountAmount", jdbcType = JdbcType.DECIMAL),
            @Result(column = "account_desc", property = "accountDesc", jdbcType = JdbcType.VARCHAR),
            @Result(column = "account_insertDT", property = "accountInsertDT", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "producttypename", property = "productTypeName", jdbcType = JdbcType.TIMESTAMP),
    })
    List<AccountHisRespDTO> selectAccountHistList(@Param("userId") Long userId, @Param("dayStr") String dayStr);

    @Select({
            "call p_back_withdraw(#{userId}, #{reqDTO.withdrawName},#{reqDTO.withdrawBankname},#{reqDTO.withdrawBankno},#{reqDTO.withdrawAmount})"
    })
    int withdrawal(@Param("userId") Long userId, @Param("reqDTO") AccountWithdraw reqDTO);

    @Select({
            "call p_back_invitecode(#{inviteCode})"
    })
    int validInviteCode(@Param("inviteCode") String inviteCode);

    class AccountSqlProvider {

        /**
         * 动态字段,写入数据库记录
         *
         * @param record
         */
        public String insertSelective(Account record) {
            SQL sql = new SQL();
            sql.INSERT_INTO("t_account");

            if (record.getAccountId() != null) {
                sql.VALUES("account_id", "#{accountId,jdbcType=INTEGER}");
            }

            if (record.getUserId() != null) {
                sql.VALUES("user_id", "#{userId,jdbcType=BIGINT}");
            }

            if (record.getAccountType() != null) {
                sql.VALUES("account_type", "#{accountType,jdbcType=BIT}");
            }

            if (record.getOrderId() != null) {
                sql.VALUES("order_id", "#{orderId,jdbcType=INTEGER}");
            }

            if (record.getAccountAmount() != null) {
                sql.VALUES("account_amount", "#{accountAmount,jdbcType=DECIMAL}");
            }

            if (record.getAccountBalance() != null) {
                sql.VALUES("account_balance", "#{accountBalance,jdbcType=DECIMAL}");
            }

            if (record.getAccountDesc() != null) {
                sql.VALUES("account_desc", "#{accountDesc,jdbcType=VARCHAR}");
            }

            if (record.getAccountInsertdt() != null) {
                sql.VALUES("account_insertDT", "#{accountInsertdt,jdbcType=TIMESTAMP}");
            }

            return sql.toString();
        }

        /**
         * 动态字段,根据主键来更新符合条件的数据库记录
         *
         * @param record
         */
        public String updateByPrimaryKeySelective(Account record) {
            SQL sql = new SQL();
            sql.UPDATE("t_account");

            if (record.getUserId() != null) {
                sql.SET("user_id = #{userId,jdbcType=BIGINT}");
            }

            if (record.getAccountType() != null) {
                sql.SET("account_type = #{accountType,jdbcType=BIT}");
            }

            if (record.getOrderId() != null) {
                sql.SET("order_id = #{orderId,jdbcType=INTEGER}");
            }

            if (record.getAccountAmount() != null) {
                sql.SET("account_amount = #{accountAmount,jdbcType=DECIMAL}");
            }

            if (record.getAccountBalance() != null) {
                sql.SET("account_balance = #{accountBalance,jdbcType=DECIMAL}");
            }

            if (record.getAccountDesc() != null) {
                sql.SET("account_desc = #{accountDesc,jdbcType=VARCHAR}");
            }

            if (record.getAccountInsertdt() != null) {
                sql.SET("account_insertDT = #{accountInsertdt,jdbcType=TIMESTAMP}");
            }

            sql.WHERE("account_id = #{accountId,jdbcType=INTEGER}");

            return sql.toString();
        }
    }
}