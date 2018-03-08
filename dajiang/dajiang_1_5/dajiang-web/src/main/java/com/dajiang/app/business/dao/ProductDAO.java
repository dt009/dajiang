/* github.com/zhouwd */
package com.dajiang.app.business.dao;

import com.dajiang.app.business.po.dmo.Product;
import com.dajiang.app.business.po.req.ProductQueryReqDTO;
import com.dajiang.app.business.po.resp.ProductPageRespDTO;
import com.dajiang.app.business.po.resp.ProductRespDTO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * 本文件由 github.com/zhouwd/mybatis-generator-core 自动生成
 *
 * @author zhouwd code generator
 */
public interface ProductDAO {
    /**
     * 根据主键删除数据库的记录
     *
     * @param productId
     */
    @Delete({
            "delete from t_product",
            "where product_id = #{productId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer productId);

    /**
     * 动态字段,写入数据库记录
     *
     * @param record
     */
    @InsertProvider(type = ProductSqlProvider.class, method = "insertSelective")
    @Options(useGeneratedKeys = true, keyProperty = "productId", keyColumn = "product_id")
    int insertSelective(Product record);

    /**
     * 根据指定主键获取一条数据库记录
     *
     * @param productId
     */
    @Select({
            "select",
            "product_id, product_title, product_price, product_type, professional_type_id, ",
            "product_status, user_id_author, product_author_name, product_desc, product_patent_number, ",
            "product_patent_type, product_createDT, product_updateDT, product_style,f_product_style(product_style) as product_style_str ",
            "from t_product",
            "where product_id = #{productId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "product_id", property = "productId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "product_title", property = "productTitle", jdbcType = JdbcType.VARCHAR),
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
            @Result(column = "product_style", property = "productStyle", jdbcType = JdbcType.TINYINT),
            @Result(column = "product_style_str", property = "productStyleStr", jdbcType = JdbcType.VARCHAR),

    })
    ProductRespDTO selectByPrimaryKey(Integer productId);

    @Select({
            "<script>",
            "select tp.product_id, tp.product_title, tp.product_price, tp.product_sales_num, tp.user_id_author, tp.product_author_name, tp.product_desc, tp.product_style, f_product_style(tp.product_style) as product_style_str, f_product_type(#{curUserId},tp.product_id) as have_flag, tp.product_updateDT",
            "from t_product tp ",
            "INNER join t_product_user tpu on tp.product_id=tpu.product_id and tpu.product_user_isowner=1 ",
            "where 1=1 ",
            "<if test=\"userId != null \">",
            " and tpu.user_id = #{userId} ",
            "</if>",
            "<if test=\"productStyle != null and productStyle!='' \">",
            " and tp.product_style = #{productStyle} ",
            "</if>",
            "</script>",
    })
    @Results({
            @Result(column = "product_id", property = "productId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "product_title", property = "productTitle", jdbcType = JdbcType.VARCHAR),
            @Result(column = "product_price", property = "productPrice", jdbcType = JdbcType.DECIMAL),
            @Result(column = "product_author_name", property = "productAuthorName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "product_desc", property = "productDesc", jdbcType = JdbcType.VARCHAR),
            @Result(column = "have_flag", property = "haveFlag", jdbcType = JdbcType.TINYINT),
            @Result(column = "product_sales_num", property = "orderNum", jdbcType = JdbcType.TINYINT),
            @Result(column = "product_style", property = "productStyle", jdbcType = JdbcType.TINYINT),
            @Result(column = "product_style_str", property = "productStyleStr", jdbcType = JdbcType.VARCHAR),
            @Result(column = "product_updateDT", property = "productUpdatedt", jdbcType = JdbcType.TIMESTAMP)
    })
    List<ProductPageRespDTO> selectByUserId(@Param("curUserId") Long currentUser, @Param("userId") Long userId, @Param("productStyle") String productStyle);

    @Select({
            "<script>",
            "select",
            "product_id, product_title, product_price, ",
            "user_id_author, product_author_name, product_desc, product_style, product_sales_num, f_product_style(product_style) as product_style_str, product_updateDT, f_product_type(#{curUserId},product_id) as have_flag",
            "from t_product",
            "where product_status = 6 ",
            "<if test=\"reqDTO != null and reqDTO.keyWord!=null and reqDTO.keyWord!='' \">",
            " and product_title like CONCAT('%',#{reqDTO.keyWord},'%')",
            "</if>",
            "<if test=\"reqDTO != null and reqDTO.professionalTypeIds != null and reqDTO.professionalTypeIds.size() > 0\">",
            "and professional_type_id in",
            "<foreach collection=\"reqDTO.professionalTypeIds\" item=\"temp\" open=\"(\" separator=\",\" close=\")\">",
            "#{temp}",
            "</foreach>",
            "</if>",
            "<if test=\"reqDTO != null and reqDTO.productStyles != null and reqDTO.productStyles.size() > 0\">",
            "and product_style in",
            "<foreach collection=\"reqDTO.productStyles\" item=\"temp\" open=\"(\" separator=\",\" close=\")\">",
            "#{temp}",
            "</foreach>",
            "</if>",
            "<if test=\"reqDTO != null and reqDTO.maxPrice!=null \">",
            " and product_price &lt;= #{reqDTO.maxPrice} ",
            "</if>",
            "<if test=\"reqDTO != null and reqDTO.minPrice!=null \">",
            " and product_price &gt;= #{reqDTO.minPrice} ",
            "</if>",
            "order by product_updateDT desc",
            "</script>",
    })
    @Results({
            @Result(column = "product_id", property = "productId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "product_title", property = "productTitle", jdbcType = JdbcType.VARCHAR),
            @Result(column = "product_price", property = "productPrice", jdbcType = JdbcType.DECIMAL),
//            @Result(column = "user_id_author", property = "userIdAuthor", jdbcType = JdbcType.BIGINT),
            @Result(column = "product_author_name", property = "productAuthorName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "product_desc", property = "productDesc", jdbcType = JdbcType.VARCHAR),
            @Result(column = "product_style", property = "productStyle", jdbcType = JdbcType.TINYINT),
            @Result(column = "product_style_str", property = "productStyleStr", jdbcType = JdbcType.VARCHAR),
            @Result(column = "itemValue", property = "productStyleStr", jdbcType = JdbcType.VARCHAR),
            @Result(column = "have_flag", property = "haveFlag", jdbcType = JdbcType.TINYINT),
            @Result(column = "product_sales_num", property = "orderNum", jdbcType = JdbcType.TINYINT),
            @Result(column = "product_updateDT", property = "productUpdatedt", jdbcType = JdbcType.TIMESTAMP)
    })
    List<ProductPageRespDTO> selectShowList(@Param("curUserId") Long userId, @Param("reqDTO") ProductQueryReqDTO condition);

    /**
     * 查询该用户已经上架的商品
     *
     * @param userId
     * @param condition
     * @return
     */
    @Select({
            "<script>",
            "select ",
            "p.product_id, p.product_title, p.product_price, p.product_style,",
            "p.user_id_author, p.product_author_name, p.product_desc, p.product_updateDT",
            "from t_product p",
            "left join t_product_user pu on p.product_id=pu.product_id and pu.product_user_isowner=1",
            "where 1=1",
            "and pu.user_id=#{userId}",
            "and p.product_status in",
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
//            @Result(column = "user_id_author", property = "userIdAuthor", jdbcType = JdbcType.BIGINT),
            @Result(column = "product_author_name", property = "productAuthorName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "product_desc", property = "productDesc", jdbcType = JdbcType.VARCHAR),
            @Result(column = "product_style", property = "productStyle", jdbcType = JdbcType.TINYINT),
            @Result(column = "product_updateDT", property = "productUpdatedt", jdbcType = JdbcType.TIMESTAMP)
    })
    List<ProductPageRespDTO> selectOnSale(@Param("userId") Long userId, @Param("productStatusList") List<Byte> condition);

    /**
     * 动态字段,根据主键来更新符合条件的数据库记录
     *
     * @param record
     */
    @UpdateProvider(type = ProductSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Product record);

    /**
     * 根据主键来更新符合条件的数据库记录
     *
     * @param record
     */
    @Update({
            "update t_product",
            "set product_title = #{productTitle,jdbcType=VARCHAR},",
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
    int updateByPrimaryKey(Product record);

    class ProductSqlProvider {

        /**
         * 动态字段,写入数据库记录
         *
         * @param record
         */
        public String insertSelective(Product record) {
            SQL sql = new SQL();
            sql.INSERT_INTO("t_product");

            if (record.getProductId() != null) {
                sql.VALUES("product_id", "#{productId,jdbcType=INTEGER}");
            }

            if (record.getProductTitle() != null) {
                sql.VALUES("product_title", "#{productTitle,jdbcType=VARCHAR}");
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
        public String updateByPrimaryKeySelective(Product record) {
            SQL sql = new SQL();
            sql.UPDATE("t_product");

            if (record.getProductTitle() != null) {
                sql.SET("product_title = #{productTitle,jdbcType=VARCHAR}");
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