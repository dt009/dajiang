package com.dajiang.app.business.dao;

import com.dajiang.app.business.po.resp.ProductPageRespDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface MyKnowLedgesDAO {

    @Select({
            "call p_back_myproduct(#{userId},#{productType})"
    })
    @Results({
            @Result(column = "product_id", property = "productId", jdbcType = JdbcType.INTEGER),
            @Result(column = "product_title", property = "productTitle", jdbcType = JdbcType.VARCHAR),
            @Result(column = "product_author_name", property = "productAuthorName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "product_desc", property = "productDesc", jdbcType = JdbcType.VARCHAR),
            @Result(column = "product_price", property = "productPrice", jdbcType = JdbcType.DECIMAL),
            @Result(column = "product_style", property = "productStyle", jdbcType = JdbcType.TINYINT),
    })
    List<ProductPageRespDTO> initMyKnowLedges(@Param("userId") Long userId, @Param("productType") Integer productType);
}
