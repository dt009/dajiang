package com.dajiang.app.business.controller;

import com.dajiang.app.base.controller.BaseController;
import com.dajiang.app.base.po.dmo.ResponseBaseDTO;
import com.dajiang.app.business.po.req.CKOQueryReqDTO;
import com.dajiang.app.business.po.req.ProductQueryReqDTO;
import com.dajiang.app.business.po.req.ProfessionalQueryReqDTO;
import com.dajiang.app.business.po.resp.CkoBaseInfoRespDTO;
import com.dajiang.app.business.po.resp.RecommentRespDTO;
import com.dajiang.app.business.service.*;
import com.dajiang.app.common.exception.BaseException;
import com.dajiang.app.common.page.PageReqBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomePageController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(HomePageController.class);

    @Autowired
    @Qualifier("recommentServiceImpl")
    private RecommentService recommentService;


    @Autowired
    @Qualifier("professionalServiceImpl")
    private ProfessionalService professionalService;

    @Autowired
    @Qualifier("productServiceImpl")
    private ProductService productService;

    @Autowired
    @Qualifier("productApplyServiceImpl")
    private ProductApplyService productApplyService;

    @Autowired
    @Qualifier("ckoServiceImpl")
    private CkoService ckoService;

    /**
     * 初始化——banner
     */
    @GetMapping("/public/banner/initBanners")
    @ResponseBody
    public ResponseBaseDTO<List<RecommentRespDTO>> initBanners() {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, recommentService.selectShowList());
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }


    /**
     * 初始化——大匠列表
     */
    @GetMapping("/public/professional/initProfessionals")
    @ResponseBody
    public ResponseBaseDTO<Object> initProfessionals() {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, professionalService.selectShowList());
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

    /**
     *
     */
    @GetMapping("/public/product/initProducts")
    @ResponseBody
    public ResponseBaseDTO<Object> initProducts() {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, productService.selectShowList(getUserSession()));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

    /**
     *
     */
    @PostMapping("/public/professional/queryMoreProfessionals")
    @ResponseBody
    public ResponseBaseDTO<Object> queryMoreProfessionals(@RequestBody PageReqBean<ProfessionalQueryReqDTO> reqDTO) {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, professionalService.selectForMore(reqDTO));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

    /**
     *
     */
    @RequestMapping("/public/professional/queryProfessionalById/{professionalId}")
    @ResponseBody
    public ResponseBaseDTO<Object> queryProfessionalById(@PathVariable("professionalId") Integer professionalId) {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, professionalService.selectByPrimaryKey(getUserSession(), professionalId));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

    /**
     * 查看大匠下的商品分类列表
     */
    @RequestMapping("/public/product/queryProductByProfessionalId/{professionalId}/{productStyle}")
    @ResponseBody
    public ResponseBaseDTO<Object> queryProductByProfessionalId(@PathVariable("professionalId") Integer professionalId, @PathVariable("productStyle") String productStyle, @RequestBody PageReqBean pageReqBean) {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, productService.selectByProfessionalId(getUserSession(), pageReqBean, professionalId, productStyle));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

    /**
     * 查看更多自己的商品
     */
    @PostMapping("/public/product/queryMoreProducts")
    @ResponseBody
    public ResponseBaseDTO<Object> queryMoreProducts(@RequestBody PageReqBean<ProductQueryReqDTO> reqDTO) {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, productService.selectForMore(getUserSession(), reqDTO));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }


    /**
     *查看CKO列表
     */
    @RequestMapping("/public/cko/queryMoreCkos")
    @ResponseBody
    public ResponseBaseDTO<Object> queryMoreCkos(@RequestBody PageReqBean<CKOQueryReqDTO> reqDTO) {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, ckoService.selectForMore(reqDTO));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

    /**
     * 查看CKO的详情
     */
    @RequestMapping("/public/cko/queryCKOById/{ckoId}")
    @ResponseBody
    public ResponseBaseDTO<CkoBaseInfoRespDTO> queryCKOById(@PathVariable("ckoId") Integer ckoId) {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, ckoService.selectBaseInfoByPrimaryKey(ckoId));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

    /**
     * 查看CKO下的商品分类列表
     */
    @RequestMapping("/public/product/queryProductByCkoId/{ckoId}/{productStyle}")
    @ResponseBody
    public ResponseBaseDTO<Object> queryProductByCkoId(@PathVariable("ckoId") Integer professionalId, @PathVariable("productStyle") String productStyle, @RequestBody PageReqBean pageReqBean) {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, productService.selectByCkoId(getUserSession(), pageReqBean, professionalId, productStyle));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

    /**
     * 专利证书详情
     *
     * @param productId
     * @return
     */
    @RequestMapping("/public/product/initPatentInfo/{productId}")
    @ResponseBody
    public ResponseBaseDTO<Object> initPatentInfo(@PathVariable("productId") Integer productId) {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, productService.selectByPrimaryKey(productId));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

    /**
     * 未上架专利
     *
     * @param productId
     * @return
     */
    @RequestMapping("/private/product/initApplyPatentInfo/{productId}")
    @ResponseBody
    public ResponseBaseDTO<Object> initApplyPatentInfo(@PathVariable("productId") Integer productId) {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, productApplyService.selectByPrimaryKey(productId));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

    /**
     * 图文详情
     *
     * @param productId
     * @return
     */
    @RequestMapping("/public/product/initDocInfo/{productId}")
    @ResponseBody
    public ResponseBaseDTO<Object> initDocInfo(@PathVariable("productId") Integer productId) {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, productService.selectByPrimaryKey(productId));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

    /**
     * 未上架图文详情
     *
     * @param productId
     * @return
     */
    @RequestMapping("/private/product/initApplyDocInfo/{productId}")
    @ResponseBody
    public ResponseBaseDTO<Object> initApplyDocInfo(@PathVariable("productId") Integer productId) {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, productApplyService.selectByPrimaryKey(productId));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

    /**
     * 视频详情
     *
     * @param productId
     * @return
     */
    @RequestMapping("/public/product/initVideoInfo/{productId}")
    @ResponseBody
    public ResponseBaseDTO<Object> initVideoInfo(@PathVariable("productId") Integer productId) {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, productService.selectByPrimaryKey(productId));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

    /**
     * 未上架视频详情
     *
     * @param productId
     * @return
     */
    @RequestMapping("/private/product/initApplyVideoInfo/{productId}")
    @ResponseBody
    public ResponseBaseDTO<Object> initApplyVideoInfo(@PathVariable("productId") Integer productId) {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, productApplyService.selectByPrimaryKey(productId));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }


}
