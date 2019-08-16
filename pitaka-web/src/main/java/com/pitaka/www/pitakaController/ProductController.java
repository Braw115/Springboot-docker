package com.pitaka.www.pitakaController;


import com.pitaka.www.service.ProductService;
import com.pitaka.www.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("v1/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    /**
     * 查询所有产品
     * @param
     * @return
     */
    @RequestMapping( value="all",method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ResultUtil findAll() {
        return productService.findAllProduct();

    }

    /**
     *
     *按系列id查询产品
     * @param seriesId
     * @return
     */
    @RequestMapping(value="/series/{seriesId}",method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ResultUtil delFeedback(@PathVariable("seriesId") Integer seriesId) {
       return productService.findBySeriesId(seriesId);
    }


}