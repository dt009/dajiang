/* github.com/zhouwd */
package com.dajiang.app.business.dao;

import com.dajiang.app.business.po.dmo.Bank;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * 本文件由 github.com/zhouwd/mybatis-generator-core 自动生成
 *
 * @author zhouwd code generator
 */
public interface BankDAO {

    /**
     * 根据指定主键获取一条数据库记录
     *
     * @param bankId
     */
    @Select({
            "select",
            "bank_id, bank_name, bank_code, bank_num_length, bank_sort",
            "from t_bank",
            "where bank_id = #{bankId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "bank_id", property = "bankId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "bank_name", property = "bankName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "bank_code", property = "bankCode", jdbcType = JdbcType.VARCHAR),
            @Result(column = "bank_num_length", property = "bankNumLength", jdbcType = JdbcType.INTEGER),
            @Result(column = "bank_sort", property = "bankSort", jdbcType = JdbcType.TINYINT)
    })
    Bank selectByPrimaryKey(Integer bankId);

    @Select({
            "select",
            "bank_id, bank_name, bank_code, bank_num_length, bank_sort",
            "from t_bank order by bank_sort asc",
    })
    @Results({
            @Result(column = "bank_id", property = "bankId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "bank_name", property = "bankName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "bank_code", property = "bankCode", jdbcType = JdbcType.VARCHAR),
            @Result(column = "bank_num_length", property = "bankNumLength", jdbcType = JdbcType.INTEGER),
            @Result(column = "bank_sort", property = "bankSort", jdbcType = JdbcType.TINYINT)
    })
    List<Bank> selectAll();
}