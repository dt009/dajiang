/* github.com/zhouwd */
package com.dajiang.app.business.dao;

import com.dajiang.app.business.po.dmo.Invoice;
import com.dajiang.app.business.po.req.InvoiceReqDTO;
import com.dajiang.app.business.po.resp.OrderRespDTO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * 本文件由 github.com/zhouwd/mybatis-generator-core 自动生成
 *
 * @author zhouwd code generator
 */
public interface InvoiceDAO {
    /**
     * 根据主键删除数据库的记录
     *
     * @param invoiceId
     */
    @Delete({
            "delete from t_invoice",
            "where invoice_id = #{invoiceId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer invoiceId);

    /**
     * 动态字段,写入数据库记录
     *
     * @param record
     */
    @InsertProvider(type = InvoiceSqlProvider.class, method = "insertSelective")
    int insertSelective(Invoice record);

    /**
     * 根据指定主键获取一条数据库记录
     *
     * @param invoiceId
     */
    @Select({
            "select",
            "invoice_id, user_id, invoice_header, invoice_tax_number, invoice_amount, invoice_code, ",
            "invoice_receive_name, invoice_receive_address, invoice_receive_email, invoice_receive_telephone, ",
            "invoice_status, invoice_medium, invoice_apply_dt, invoice_process_dt, invoice_send_dt",
            "from t_invoice",
            "where invoice_id = #{invoiceId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "invoice_id", property = "invoiceId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.BIGINT),
            @Result(column = "invoice_header", property = "invoiceHeader", jdbcType = JdbcType.VARCHAR),
            @Result(column = "invoice_tax_number", property = "invoiceTaxNumber", jdbcType = JdbcType.VARCHAR),
            @Result(column = "invoice_amount", property = "invoiceAmount", jdbcType = JdbcType.DECIMAL),
            @Result(column = "invoice_code", property = "invoiceCode", jdbcType = JdbcType.VARCHAR),
            @Result(column = "invoice_receive_name", property = "invoiceReceiveName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "invoice_receive_address", property = "invoiceReceiveAddress", jdbcType = JdbcType.VARCHAR),
            @Result(column = "invoice_receive_email", property = "invoiceReceiveEmail", jdbcType = JdbcType.VARCHAR),
            @Result(column = "invoice_receive_telephone", property = "invoiceReceiveTelephone", jdbcType = JdbcType.VARCHAR),
            @Result(column = "invoice_status", property = "invoiceStatus", jdbcType = JdbcType.INTEGER),
            @Result(column = "invoice_medium", property = "invoiceMedium", jdbcType = JdbcType.INTEGER),
            @Result(column = "invoice_apply_dt", property = "invoiceApplyDt", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "invoice_process_dt", property = "invoiceProcessDt", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "invoice_send_dt", property = "invoiceSendDt", jdbcType = JdbcType.TIMESTAMP)
    })
    Invoice selectByPrimaryKey(Integer invoiceId);

    /**
     * 动态字段,根据主键来更新符合条件的数据库记录
     *
     * @param record
     */
    @UpdateProvider(type = InvoiceSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Invoice record);

    /**
     * 根据主键来更新符合条件的数据库记录
     *
     * @param record
     */
    @Update({
            "update t_invoice",
            "set user_id = #{userId,jdbcType=BIGINT},",
            "invoice_header = #{invoiceHeader,jdbcType=VARCHAR},",
            "invoice_tax_number = #{invoiceTaxNumber,jdbcType=VARCHAR},",
            "invoice_amount = #{invoiceAmount,jdbcType=DECIMAL},",
            "invoice_code = #{invoiceCode,jdbcType=VARCHAR},",
            "invoice_receive_name = #{invoiceReceiveName,jdbcType=VARCHAR},",
            "invoice_receive_address = #{invoiceReceiveAddress,jdbcType=VARCHAR},",
            "invoice_receive_email = #{invoiceReceiveEmail,jdbcType=VARCHAR},",
            "invoice_receive_telephone = #{invoiceReceiveTelephone,jdbcType=VARCHAR},",
            "invoice_status = #{invoiceStatus,jdbcType=INTEGER},",
            "invoice_medium = #{invoiceMedium,jdbcType=INTEGER},",
            "invoice_apply_dt = #{invoiceApplyDt,jdbcType=TIMESTAMP},",
            "invoice_process_dt = #{invoiceProcessDt,jdbcType=TIMESTAMP},",
            "invoice_send_dt = #{invoiceSendDt,jdbcType=TIMESTAMP}",
            "where invoice_id = #{invoiceId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Invoice record);

    @Select({
            "call p_back_init_invoice(#{userId})",
    })
    @Results({
            @Result(column = "order_id", property = "orderId", jdbcType = JdbcType.INTEGER),
            @Result(column = "product_title", property = "productTitle", jdbcType = JdbcType.VARCHAR),
            @Result(column = "order_amount", property = "orderAmount", jdbcType = JdbcType.DECIMAL),
            @Result(column = "order_DT", property = "orderDt", jdbcType = JdbcType.TIMESTAMP)
    })
    List<OrderRespDTO> initAskInvoice(@Param("userId") Long userId);

    @Select({
            "call p_back_invoice(#{userId},#{reqDTO.invoiceHeader},#{reqDTO.invoiceTaxNumber},#{reqDTO.invoiceMedium},#{reqDTO.invoiceReceiveName},#{reqDTO.invoiceReceiveAddress},#{reqDTO.invoiceReceiveEmail},#{reqDTO.invoiceReceiveTelephone},#{reqDTO.orderIdListStr})"
    })
    int insertInvoice(@Param("userId") Long userId, @Param("reqDTO") InvoiceReqDTO reqDTO);

    class InvoiceSqlProvider {

        /**
         * 动态字段,写入数据库记录
         *
         * @param record
         */
        public String insertSelective(Invoice record) {
            SQL sql = new SQL();
            sql.INSERT_INTO("t_invoice");

            if (record.getInvoiceId() != null) {
                sql.VALUES("invoice_id", "#{invoiceId,jdbcType=INTEGER}");
            }

            if (record.getUserId() != null) {
                sql.VALUES("user_id", "#{userId,jdbcType=BIGINT}");
            }

            if (record.getInvoiceHeader() != null) {
                sql.VALUES("invoice_header", "#{invoiceHeader,jdbcType=VARCHAR}");
            }

            if (record.getInvoiceTaxNumber() != null) {
                sql.VALUES("invoice_tax_number", "#{invoiceTaxNumber,jdbcType=VARCHAR}");
            }

            if (record.getInvoiceAmount() != null) {
                sql.VALUES("invoice_amount", "#{invoiceAmount,jdbcType=DECIMAL}");
            }

            if (record.getInvoiceCode() != null) {
                sql.VALUES("invoice_code", "#{invoiceCode,jdbcType=VARCHAR}");
            }

            if (record.getInvoiceReceiveName() != null) {
                sql.VALUES("invoice_receive_name", "#{invoiceReceiveName,jdbcType=VARCHAR}");
            }

            if (record.getInvoiceReceiveAddress() != null) {
                sql.VALUES("invoice_receive_address", "#{invoiceReceiveAddress,jdbcType=VARCHAR}");
            }

            if (record.getInvoiceReceiveEmail() != null) {
                sql.VALUES("invoice_receive_email", "#{invoiceReceiveEmail,jdbcType=VARCHAR}");
            }

            if (record.getInvoiceReceiveTelephone() != null) {
                sql.VALUES("invoice_receive_telephone", "#{invoiceReceiveTelephone,jdbcType=VARCHAR}");
            }

            if (record.getInvoiceStatus() != null) {
                sql.VALUES("invoice_status", "#{invoiceStatus,jdbcType=INTEGER}");
            }

            if (record.getInvoiceMedium() != null) {
                sql.VALUES("invoice_medium", "#{invoiceMedium,jdbcType=INTEGER}");
            }

            if (record.getInvoiceApplyDt() != null) {
                sql.VALUES("invoice_apply_dt", "#{invoiceApplyDt,jdbcType=TIMESTAMP}");
            }

            if (record.getInvoiceProcessDt() != null) {
                sql.VALUES("invoice_process_dt", "#{invoiceProcessDt,jdbcType=TIMESTAMP}");
            }

            if (record.getInvoiceSendDt() != null) {
                sql.VALUES("invoice_send_dt", "#{invoiceSendDt,jdbcType=TIMESTAMP}");
            }

            return sql.toString();
        }

        /**
         * 动态字段,根据主键来更新符合条件的数据库记录
         *
         * @param record
         */
        public String updateByPrimaryKeySelective(Invoice record) {
            SQL sql = new SQL();
            sql.UPDATE("t_invoice");

            if (record.getUserId() != null) {
                sql.SET("user_id = #{userId,jdbcType=BIGINT}");
            }

            if (record.getInvoiceHeader() != null) {
                sql.SET("invoice_header = #{invoiceHeader,jdbcType=VARCHAR}");
            }

            if (record.getInvoiceTaxNumber() != null) {
                sql.SET("invoice_tax_number = #{invoiceTaxNumber,jdbcType=VARCHAR}");
            }

            if (record.getInvoiceAmount() != null) {
                sql.SET("invoice_amount = #{invoiceAmount,jdbcType=DECIMAL}");
            }

            if (record.getInvoiceCode() != null) {
                sql.SET("invoice_code = #{invoiceCode,jdbcType=VARCHAR}");
            }

            if (record.getInvoiceReceiveName() != null) {
                sql.SET("invoice_receive_name = #{invoiceReceiveName,jdbcType=VARCHAR}");
            }

            if (record.getInvoiceReceiveAddress() != null) {
                sql.SET("invoice_receive_address = #{invoiceReceiveAddress,jdbcType=VARCHAR}");
            }

            if (record.getInvoiceReceiveEmail() != null) {
                sql.SET("invoice_receive_email = #{invoiceReceiveEmail,jdbcType=VARCHAR}");
            }

            if (record.getInvoiceReceiveTelephone() != null) {
                sql.SET("invoice_receive_telephone = #{invoiceReceiveTelephone,jdbcType=VARCHAR}");
            }

            if (record.getInvoiceStatus() != null) {
                sql.SET("invoice_status = #{invoiceStatus,jdbcType=INTEGER}");
            }

            if (record.getInvoiceMedium() != null) {
                sql.SET("invoice_medium = #{invoiceMedium,jdbcType=INTEGER}");
            }

            if (record.getInvoiceApplyDt() != null) {
                sql.SET("invoice_apply_dt = #{invoiceApplyDt,jdbcType=TIMESTAMP}");
            }

            if (record.getInvoiceProcessDt() != null) {
                sql.SET("invoice_process_dt = #{invoiceProcessDt,jdbcType=TIMESTAMP}");
            }

            if (record.getInvoiceSendDt() != null) {
                sql.SET("invoice_send_dt = #{invoiceSendDt,jdbcType=TIMESTAMP}");
            }

            sql.WHERE("invoice_id = #{invoiceId,jdbcType=INTEGER}");

            return sql.toString();
        }
    }
}