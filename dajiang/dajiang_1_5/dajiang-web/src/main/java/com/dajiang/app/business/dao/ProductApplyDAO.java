/* github.com/zhouwd */
package com.dajiang.app.business.dao;

import com.dajiang.app.business.po.dmo.ProductApply;
import com.dajiang.app.business.po.resp.ProductApplyRespDTO;
import com.dajiang.app.business.po.resp.ProductPageRespDTO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * 本文件由 github.com/zhouwd/mybatis-generator-core 自动生成
 *
 * @author zhouwd code generator
 */
public interface ProductApplyDAO {
    /**
     * 根据主键删除数据库的记录
     *
     * @param productId
     */
    @Delete({
            "delete from t_product_apply",
            "where product_id = #{productId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer productId);

    /**
     * 动态字段,写入数据库记录
     *
     * @param record
     */
    @InsertProvider(type = ProductApplySqlProvider.class, method = "insertSelective")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "productId", before = false, resultType = Integer.class)
    @Options(useGeneratedKeys = true, keyProperty = "productId", keyColumn = "product_id")
    int insertSelective(ProductApply record);

    /**
     * 根据指定主键获取一条数据库记录
     *
     * @param productId
     */
    @Select({
            "select",
            "product_id, product_title, user_id, product_price, product_type, professional_type_id, ",
            "product_status, user_id_author, product_author_name, product_desc, product_patent_number, ",
            "product_patent_type, product_createDT, product_updateDT, product_style",
            "from t_product_apply",
            "where product_id = #{productId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "product_id", property = "productId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "product_title", property = "productTitle", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.BIGINT),
            @Result(column = "product_price", property = "productPrice", jdbcType = JdbcType.DECIMAL),
            @Result(column = "product_type", property = "productType", jdbcType = JdbcType.TINYINT),
            @Result(column = "professional_type_id", property = "professionalTypeId", jdbcType = JdbcType.INTEGER),
            @Result(column = "product_status", property = "productStatus", jdbcType = JdbcType.TINYINT),
            @Result(column = "user_id_author", property = "userIdAuthor", jdbcType = JdbcType.BIGINT),
            @Result(column = "product_author_name", property = "productAuthorName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "product_desc", property = "productDesc", jdbcType = JdbcType.VARCHAR),
            @Result(column = "product_patent_number", property = "productPatentNumber", jdbcType = JdbcType.VARCHAR),
            @Result(column = "product_patent_type", property = "productPatentType", jdbcType = JdbcType.TINYINT),
            @Result(column = "product_createDT", property = "productCreatedt", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "product_updateDT", property = "productUpdatedt", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "product_style", property = "productStyle", jdbcType = JdbcType.TINYINT)
    })
    ProductApplyRespDTO selectByPrimaryKey(Integer productId);

    /**
     * @param userId
     * @param productStatus
     * @return
     */
    @Select({
            "<script>",
            "select ",
            "p.product_id, p.product_title, p.product_price, p.product_style,",
            "p.user_id_author, p.product_author_name, p.product_desc, p.product_updateDT",
            "from t_product_apply p",
            "where 1=1",
            "and p.user_id=#{userId} and p.product_status in ",
            "<foreach collection=\"productStatusList\" item=\"temp\" open=\"(\" separator=\",\" close=\")\">",
            "#{temp}",
            "</foreach>",
            "order by product_updateDT desc ",
            "</script>",
    })
    @Results({
            @Result(column = "product_id", property = "productId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "product_title", property = "productTitle", jdbcType = JdbcType.VARCHAR),
            @Result(column = "product_price", property = "productPrice", jdbcType = JdbcType.DECIMAL),
            @Result(column = "product_author_name", property = "productAuthorName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "product_desc", property = "productDesc", jdbcType = JdbcType.VARCHAR),
            @Result(column = "product_style", property = "productStyle", jdbcType = JdbcType.VARCHAR),
            @Result(column = "product_updateDT", property = "productUpdatedt", jdbcType = JdbcType.TIMESTAMP)
    })
    List<ProductPageRespDTO> selectPreSale(@Param("userId") Long userId, @Param("productStatusList") List<Byte> productStatus);

    /**
     * 动态字段,根据主键来更新符合条件的数据库记录
     *
     * @param record
     */
    @UpdateProvider(type = ProductApplySqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ProductApply record);

    /**
     * 根据主键来更新符合条件的数据库记录
     *
     * @param record
     */
    @Update({
            "update t_product_apply",
            "set product_title = #{productTitle,jdbcType=VARCHAR},",
            "user_id = #{userId,jdbcType=BIGINT},",
            "product_price = #{productPrice,jdbcType=DECIMAL},",
            "product_type = #{productType,jdbcType=TINYINT},",
            "professional_type_id = #{professionalTypeId,jdbcType=INTEGER},",
            "product_status = #{productStatus,jdbcType=TINYINT},",
            "user_id_author = #{userIdAuthor,jdbcType=BIGINT},",
            "product_author_name = #{productAuthorName,jdbcType=VARCHAR},",
            "product_desc = #{productDesc,jdbcType=VARCHAR},",
            "product_patent_number = #{productPatentNumber,jdbcType=VARCHAR},",
            "product_patent_type = #{productPatentType,jdbcType=TINYINT},",
            "product_createDT = #{productCreatedt,jdbcType=TIMESTAMP},",
            "product_updateDT = #{productUpdatedt,jdbcType=TIMESTAMP},",
            "product_style = #{productStyle,jdbcType=TINYINT}",
            "where product_id = #{productId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ProductApply record);

    @Select({
            "CALL p_product_apply(#{productId})"
    })
    int callProductApply(@Param("productId") Integer productId);

    class ProductApplySqlProvider {

        /**
         * 动态字段,写入数据库记录
         *
         * @param record
         */
        public String insertSelective(ProductApply record) {
            SQL sql = new SQL();
            sql.INSERT_INTO("t_product_apply");

            if (record.getProductId() != null) {
                sql.VALUES("product_id", "#{productId,jdbcType=INTEGER}");
            }

            if (record.getProductTitle() != null) {
                sql.VALUES("product_title", "#{productTitle,jdbcType=VARCHAR}");
            }

            if (record.getUserId() != null) {
                sql.VALUES("user_id", "#{userId,jdbcType=BIGINT}");
            }

            if (record.getProductPrice() != null) {
                sql.VALUES("product_price", "#{productPrice,jdbcType=DECIMAL}");
            }

            if (record.getProductType() != null) {
                sql.VALUES("product_type", "#{productType,jdbcType=TINYINT}");
            }

            if (record.getProfessionalTypeId() != null) {
                sql.VALUES("professional_type_id", "#{professionalTypeId,jdbcType=INTEGER}");
            }

            if (record.getProductStatus() != null) {
                sql.VALUES("product_status", "#{productStatus,jdbcType=TINYINT}");
            }

            if (record.getUserIdAuthor() != null) {
                sql.VALUES("user_id_author", "#{userIdAuthor,jdbcType=BIGINT}");
            }

            if (record.getProductAuthorName() != null) {
                sql.VALUES("product_author_name", "#{productAuthorName,jdbcType=VARCHAR}");
            }

            if (record.getProductDesc() != null) {
                sql.VALUES("product_desc", "#{productDesc,jdbcType=VARCHAR}");
            }

            if (record.getProductPatentNumber() != null) {
                sql.VALUES("product_patent_number", "#{productPatentNumber,jdbcType=VARCHAR}");
            }

            if (record.getProductPatentType() != null) {
                sql.VALUES("product_patent_type", "#{productPatentType,jdbcType=TINYINT}");
            }

            if (record.getProductCreatedt() != null) {
                sql.VALUES("product_createDT", "#{productCreatedt,jdbcType=TIMESTAMP}");
            }

            if (record.getProductUpdatedt() != null) {
                sql.VALUES("product_updateDT", "#{productUpdatedt,jdbcType=TIMESTAMP}");
            }

            if (record.getProductStyle() != null) {
                sql.VALUES("product_style", "#{productStyle,jdbcType=TINYINT}");
            }

            return sql.toString();
        }

        /**
         * 动态字段,根据主键来更新符合条件的数据库记录
         *
         * @param record
         */
        public String updateByPrimaryKeySelective(ProductApply record) {
            SQL sql = new SQL();
            sql.UPDATE("t_product_apply");

            if (record.getProductTitle() != null) {
                sql.SET("product_title = #{productTitle,jdbcType=VARCHAR}");
            }

            if (record.getUserId() != null) {
                sql.SET("user_id = #{userId,jdbcType=BIGINT}");
            }

            if (record.getProductPrice() != null) {
                sql.SET("product_price = #{productPrice,jdbcType=DECIMAL}");
            }

            if (record.getProductType() != null) {
                sql.SET("product_type = #{productType,jdbcType=TINYINT}");
            }

            if (record.getProfessionalTypeId() != null) {
                sql.SET("professional_type_id = #{professionalTypeId,jdbcType=INTEGER}");
            }

            if (record.getProductStatus() != null) {
                sql.SET("product_status = #{productStatus,jdbcType=TINYINT}");
            }

            if (record.getUserIdAuthor() != null) {
                sql.SET("user_id_author = #{userIdAuthor,jdbcType=BIGINT}");
            }

            if (record.getProductAuthorName() != null) {
                sql.SET("product_author_name = #{productAuthorName,jdbcType=VARCHAR}");
            }

            if (record.getProductDesc() != null) {
                sql.SET("product_desc = #{productDesc,jdbcType=VARCHAR}");
            }

            if (record.getProductPatentNumber() != null) {
                sql.SET("product_patent_number = #{productPatentNumber,jdbcType=VARCHAR}");
            }

            if (record.getProductPatentType() != null) {
                sql.SET("product_patent_type = #{productPatentType,jdbcType=TINYINT}");
            }

            if (record.getProductCreatedt() != null) {
                sql.SET("product_createDT = #{productCreatedt,jdbcType=TIMESTAMP}");
            }

            if (record.getProductUpdatedt() != null) {
                sql.SET("product_updateDT = #{productUpdatedt,jdbcType=TIMESTAMP}");
            }

            if (record.getProductStyle() != null) {
                sql.SET("product_style = #{productStyle,jdbcType=TINYINT}");
            }

            sql.WHERE("product_id = #{productId,jdbcType=INTEGER}");

            return sql.toString();
        }
    }
}