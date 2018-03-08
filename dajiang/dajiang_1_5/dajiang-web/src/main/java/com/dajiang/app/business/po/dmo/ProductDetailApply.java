/* github.com/zhouwd */
package com.dajiang.app.business.po.dmo;

import com.dajiang.app.base.po.dmo.BaseDTO;

/**
 * 产品详细信息申请 t_product_detail_apply
 *
 * @author zhouwd code generator
 */
public class ProductDetailApply extends BaseDTO {
    private Integer productDetailId;

    /**
     * 标题
     */
    private String productDetailTitle;

    /**
     * 产品明细种类：1、视频；2、音频；3、文件；4、文字说明；5、图片；6：封面
     */
    private Integer productDetailType;

    /**
     * 产品详细指向路径
     */
    private String productPath;

    /**
     * 产品链接
     */
    private String productDetailUrl;

    /**
     * 产品描述
     */
    private String productDetailDesc;

    /**
     * 显示顺序
     */
    private Integer productDetailSort;

    private Integer productId;

    /**
     * 获取 t_product_detail_apply.product_detail_id
     *
     * @return t_product_detail_apply.product_detail_id
     */
    public Integer getProductDetailId() {
        return productDetailId;
    }

    /**
     * 设置 t_product_detail_apply.product_detail_id
     *
     * @param productDetailId t_product_detail_apply.product_detail_id
     */
    public void setProductDetailId(Integer productDetailId) {
        this.productDetailId = productDetailId;
    }

    /**
     * 获取 标题 t_product_detail_apply.product_detail_title
     *
     * @return 标题
     */
    public String getProductDetailTitle() {
        return productDetailTitle;
    }

    /**
     * 设置 标题 t_product_detail_apply.product_detail_title
     *
     * @param productDetailTitle 标题
     */
    public void setProductDetailTitle(String productDetailTitle) {
        this.productDetailTitle = productDetailTitle == null ? null : productDetailTitle.trim();
    }

    /**
     * 获取 产品明细种类：1、视频；2、音频；3、文件；4、文字说明；5、图片；6：封面 t_product_detail_apply.product_detail_type
     *
     * @return 产品明细种类：1、视频；2、音频；3、文件；4、文字说明；5、图片；6：封面
     */
    public Integer getProductDetailType() {
        return productDetailType;
    }

    /**
     * 设置 产品明细种类：1、视频；2、音频；3、文件；4、文字说明；5、图片；6：封面 t_product_detail_apply.product_detail_type
     *
     * @param productDetailType 产品明细种类：1、视频；2、音频；3、文件；4、文字说明；5、图片；6：封面
     */
    public void setProductDetailType(Integer productDetailType) {
        this.productDetailType = productDetailType;
    }

    /**
     * 获取 产品详细指向路径 t_product_detail_apply.product_path
     *
     * @return 产品详细指向路径
     */
    public String getProductPath() {
        return productPath;
    }

    /**
     * 设置 产品详细指向路径 t_product_detail_apply.product_path
     *
     * @param productPath 产品详细指向路径
     */
    public void setProductPath(String productPath) {
        this.productPath = productPath == null ? null : productPath.trim();
    }

    /**
     * 获取 产品链接 t_product_detail_apply.product_detail_url
     *
     * @return 产品链接
     */
    public String getProductDetailUrl() {
        return productDetailUrl;
    }

    /**
     * 设置 产品链接 t_product_detail_apply.product_detail_url
     *
     * @param productDetailUrl 产品链接
     */
    public void setProductDetailUrl(String productDetailUrl) {
        this.productDetailUrl = productDetailUrl == null ? null : productDetailUrl.trim();
    }

    /**
     * 获取 产品描述 t_product_detail_apply.product_detail_desc
     *
     * @return 产品描述
     */
    public String getProductDetailDesc() {
        return productDetailDesc;
    }

    /**
     * 设置 产品描述 t_product_detail_apply.product_detail_desc
     *
     * @param productDetailDesc 产品描述
     */
    public void setProductDetailDesc(String productDetailDesc) {
        this.productDetailDesc = productDetailDesc == null ? null : productDetailDesc.trim();
    }

    /**
     * 获取 显示顺序 t_product_detail_apply.product_detail_sort
     *
     * @return 显示顺序
     */
    public Integer getProductDetailSort() {
        return productDetailSort;
    }

    /**
     * 设置 显示顺序 t_product_detail_apply.product_detail_sort
     *
     * @param productDetailSort 显示顺序
     */
    public void setProductDetailSort(Integer productDetailSort) {
        this.productDetailSort = productDetailSort;
    }

    /**
     * 获取 t_product_detail_apply.product_id
     *
     * @return t_product_detail_apply.product_id
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 设置 t_product_detail_apply.product_id
     *
     * @param productId t_product_detail_apply.product_id
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}