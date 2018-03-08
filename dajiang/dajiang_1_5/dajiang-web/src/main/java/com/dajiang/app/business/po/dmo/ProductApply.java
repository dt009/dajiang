/* github.com/zhouwd */
package com.dajiang.app.business.po.dmo;

import com.dajiang.app.base.po.dmo.BaseDTO;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 申请上架产品 t_product_apply
 *
 * @author zhouwd code generator
 */
public class ProductApply extends BaseDTO {
    private Integer productId;

    /**
     * 标题说明
     */
    private String productTitle;

    /**
     * 上架用户id，即销售人id
     */
    private Long userId;

    /**
     * 价格
     */
    private BigDecimal productPrice;

    /**
     * 产品类型：1、共享知识；2、授权知识
     */
    private Byte productType;

    /**
     * 产品专业分类id
     */
    private Integer professionalTypeId;

    /**
     * 状态:1、商品保存，未提交审核；2，提交审核但不提交上架，3、提交审核并提交上架，4，拒绝通过，5、审核通过，6、商品上架；7、商品下架；
     */
    private Byte productStatus;

    /**
     * 原创,即上架大匠id
     * 如果为空，显示名称
     */
    private Long userIdAuthor;

    /**
     * 原创人姓名
     */
    private String productAuthorName;

    /**
     * 产品说明
     */
    private String productDesc;

    /**
     * 专利号
     */
    private String productPatentNumber;

    /**
     * 专利类型：1：发明专利；2：实用新型；3：设计方案；
     */
    private Byte productPatentType;

    /**
     * 创建时间
     */
    private Date productCreatedt;

    /**
     * 修改时间
     */
    private Date productUpdatedt;

    /**
     * 产品类别：1、专利技术；2、图文知识；3、视频知识
     */
    private Byte productStyle;

    /**
     * 获取 t_product_apply.product_id
     *
     * @return t_product_apply.product_id
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 设置 t_product_apply.product_id
     *
     * @param productId t_product_apply.product_id
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * 获取 标题说明 t_product_apply.product_title
     *
     * @return 标题说明
     */
    public String getProductTitle() {
        return productTitle;
    }

    /**
     * 设置 标题说明 t_product_apply.product_title
     *
     * @param productTitle 标题说明
     */
    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle == null ? null : productTitle.trim();
    }

    /**
     * 获取 上架用户id，即销售人id t_product_apply.user_id
     *
     * @return 上架用户id，即销售人id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置 上架用户id，即销售人id t_product_apply.user_id
     *
     * @param userId 上架用户id，即销售人id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取 价格 t_product_apply.product_price
     *
     * @return 价格
     */
    public BigDecimal getProductPrice() {
        return productPrice;
    }

    /**
     * 设置 价格 t_product_apply.product_price
     *
     * @param productPrice 价格
     */
    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    /**
     * 获取 产品类型：1、共享知识；2、授权知识 t_product_apply.product_type
     *
     * @return 产品类型：1、共享知识；2、授权知识
     */
    public Byte getProductType() {
        return productType;
    }

    /**
     * 设置 产品类型：1、共享知识；2、授权知识 t_product_apply.product_type
     *
     * @param productType 产品类型：1、共享知识；2、授权知识
     */
    public void setProductType(Byte productType) {
        this.productType = productType;
    }

    /**
     * 获取 产品专业分类id t_product_apply.professional_type_id
     *
     * @return 产品专业分类id
     */
    public Integer getProfessionalTypeId() {
        return professionalTypeId;
    }

    /**
     * 设置 产品专业分类id t_product_apply.professional_type_id
     *
     * @param professionalTypeId 产品专业分类id
     */
    public void setProfessionalTypeId(Integer professionalTypeId) {
        this.professionalTypeId = professionalTypeId;
    }

    /**
     * 获取 状态:1、商品保存，未提交审核；2，提交审核但不提交上架，3、提交审核并提交上架，4，拒绝通过，5、审核通过，6、商品上架；7、商品下架； t_product_apply.product_status
     *
     * @return 状态:1、商品保存，未提交审核；2，提交审核但不提交上架，3、提交审核并提交上架，4，拒绝通过，5、审核通过，6、商品上架；7、商品下架；
     */
    public Byte getProductStatus() {
        return productStatus;
    }

    /**
     * 设置 状态:1、商品保存，未提交审核；2，提交审核但不提交上架，3、提交审核并提交上架，4，拒绝通过，5、审核通过，6、商品上架；7、商品下架； t_product_apply.product_status
     *
     * @param productStatus 状态:1、商品保存，未提交审核；2，提交审核但不提交上架，3、提交审核并提交上架，4，拒绝通过，5、审核通过，6、商品上架；7、商品下架；
     */
    public void setProductStatus(Byte productStatus) {
        this.productStatus = productStatus;
    }

    /**
     * 获取 原创,即上架大匠id
     * 如果为空，显示名称 t_product_apply.user_id_author
     *
     * @return 原创, 即上架大匠id
     * 如果为空，显示名称
     */
    public Long getUserIdAuthor() {
        return userIdAuthor;
    }

    /**
     * 设置 原创,即上架大匠id
     * 如果为空，显示名称 t_product_apply.user_id_author
     *
     * @param userIdAuthor 原创,即上架大匠id
     *                     如果为空，显示名称
     */
    public void setUserIdAuthor(Long userIdAuthor) {
        this.userIdAuthor = userIdAuthor;
    }

    /**
     * 获取 原创人姓名 t_product_apply.product_author_name
     *
     * @return 原创人姓名
     */
    public String getProductAuthorName() {
        return productAuthorName;
    }

    /**
     * 设置 原创人姓名 t_product_apply.product_author_name
     *
     * @param productAuthorName 原创人姓名
     */
    public void setProductAuthorName(String productAuthorName) {
        this.productAuthorName = productAuthorName == null ? null : productAuthorName.trim();
    }

    /**
     * 获取 产品说明 t_product_apply.product_desc
     *
     * @return 产品说明
     */
    public String getProductDesc() {
        return productDesc;
    }

    /**
     * 设置 产品说明 t_product_apply.product_desc
     *
     * @param productDesc 产品说明
     */
    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc == null ? null : productDesc.trim();
    }

    /**
     * 获取 专利号 t_product_apply.product_patent_number
     *
     * @return 专利号
     */
    public String getProductPatentNumber() {
        return productPatentNumber;
    }

    /**
     * 设置 专利号 t_product_apply.product_patent_number
     *
     * @param productPatentNumber 专利号
     */
    public void setProductPatentNumber(String productPatentNumber) {
        this.productPatentNumber = productPatentNumber == null ? null : productPatentNumber.trim();
    }

    /**
     * 获取 专利类型：1：发明专利；2：实用新型；3：设计方案； t_product_apply.product_patent_type
     *
     * @return 专利类型：1：发明专利；2：实用新型；3：设计方案；
     */
    public Byte getProductPatentType() {
        return productPatentType;
    }

    /**
     * 设置 专利类型：1：发明专利；2：实用新型；3：设计方案； t_product_apply.product_patent_type
     *
     * @param productPatentType 专利类型：1：发明专利；2：实用新型；3：设计方案；
     */
    public void setProductPatentType(Byte productPatentType) {
        this.productPatentType = productPatentType;
    }

    /**
     * 获取 创建时间 t_product_apply.product_createDT
     *
     * @return 创建时间
     */
    public Date getProductCreatedt() {
        return productCreatedt;
    }

    /**
     * 设置 创建时间 t_product_apply.product_createDT
     *
     * @param productCreatedt 创建时间
     */
    public void setProductCreatedt(Date productCreatedt) {
        this.productCreatedt = productCreatedt;
    }

    /**
     * 获取 修改时间 t_product_apply.product_updateDT
     *
     * @return 修改时间
     */
    public Date getProductUpdatedt() {
        return productUpdatedt;
    }

    /**
     * 设置 修改时间 t_product_apply.product_updateDT
     *
     * @param productUpdatedt 修改时间
     */
    public void setProductUpdatedt(Date productUpdatedt) {
        this.productUpdatedt = productUpdatedt;
    }

    /**
     * 获取 产品类别：1、专利技术；2、图文知识；3、视频知识 t_product_apply.product_style
     *
     * @return 产品类别：1、专利技术；2、图文知识；3、视频知识
     */
    public Byte getProductStyle() {
        return productStyle;
    }

    /**
     * 设置 产品类别：1、专利技术；2、图文知识；3、视频知识 t_product_apply.product_style
     *
     * @param productStyle 产品类别：1、专利技术；2、图文知识；3、视频知识
     */
    public void setProductStyle(Byte productStyle) {
        this.productStyle = productStyle;
    }
}