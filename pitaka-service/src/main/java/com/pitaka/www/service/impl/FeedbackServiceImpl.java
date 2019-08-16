package com.pitaka.www.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pitaka.www.mapper.FeedbackMapper;
import com.pitaka.www.mapper.ProductMapper;
import com.pitaka.www.model.ExcelBean;
import com.pitaka.www.model.Feedback;
import com.pitaka.www.model.FeedbackExcel;
import com.pitaka.www.model.Product;
import com.pitaka.www.service.FeedbackService;
import com.pitaka.www.utils.*;
import com.pitaka.www.vo.FeedbackVO;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//@CacheConfig(cacheNames = "feed")
@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackMapper feedbackMapper;
    @Autowired
    private ProductMapper productMapper;

//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;
    /**
     * 添加反馈记录
     * @param feedbackVO
     * @return
     */
    @Override
    public int addFeedback(FeedbackVO feedbackVO) {
        List<MultipartFile> imgFileList = feedbackVO.getImgFileList();
        String imaUrl = null;
        if (imgFileList != null) {
            try {
                imaUrl = FileUploadUtils.fileUpload(imgFileList);
            } catch (Exception e) {
                e.printStackTrace();
            }
            feedbackVO.setImage(imaUrl);
        }
        List<Integer> purchaseList = feedbackVO.getPurchaseList();
        if(purchaseList.size() != 0){
            feedbackVO.setPurchase( purchaseList.toString());
        }else{
            feedbackVO.setPurchase(null);
        }
        return feedbackMapper.insertFeedback(feedbackVO);
    }

    /**
     * 删除反馈记录
     * @param id
     * @return
     */
    @Override
    public int delFeedback(Integer id) {
        return feedbackMapper.delFeedback(id);
    }

    /**
     * 更新反馈记录
     * @param feedbackVO
     * @return
     */
    @Override
    public int updateFeedback(FeedbackVO feedbackVO) {
        List<MultipartFile> imgFileList = feedbackVO.getImgFileList();
        String imgUrl = "";
        String oldImageUrl = feedbackVO.getImage();
        String newimage;
        //有上传图片
        if (imgFileList != null) {
            try {
                imgUrl = FileUploadUtils.fileUpload(imgFileList);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (oldImageUrl != null) {//在原有图片上添加
                newimage = oldImageUrl + "," + imgUrl;
            } else {//覆盖原有图片
                newimage = imgUrl;
            }
            feedbackVO.setImage(newimage);

        }
        List<Integer> purchaseList = feedbackVO.getPurchaseList();
        if(purchaseList.size() != 0){
            feedbackVO.setPurchase( purchaseList.toString());
        }else {
            feedbackVO.setPurchase(null);
        }
        return feedbackMapper.updateFeedback(feedbackVO);
    }

    /**
     * 根据id查询反馈记录
     * @param id
     * @return
     */
    @Override
    public ResultUtil findFeedbackById(Integer id) {
        FeedbackVO feedbackVO = feedbackMapper.findFeedbackById(id);
        List<Integer> purchaseList;
        if(feedbackVO.getPurchase() == null || "".equals(feedbackVO.getPurchase())){
            purchaseList = null;
        }else{
            purchaseList = TypeUtils.arrayStingToList(feedbackVO.getPurchase());
        }
        feedbackVO.setPurchaseList(purchaseList);
       return  new ResultUtil().success(feedbackVO);

    }

    /**
     * 分页查询所有记录
     * @return
     */
    @Override
//    @Cacheable(value = "lxl")
    public ResultUtil findFeedbackByPage(Integer currentPage, Integer currentSize) {
//            stringRedisTemplate.opsForValue().set("test", "100",60*10, TimeUnit.SECONDS);
            PageHelper.startPage(currentPage,currentSize,true);
            List<Feedback> feedbackList = feedbackMapper.findAllFeedback();
            PageInfo<Feedback> pageInfo = new PageInfo<Feedback>(feedbackList);
            PageBean<Feedback> pageBean = new PageBean<Feedback>();
            pageBean.setCurrentPage(currentPage);
            pageBean.setCurrentSize(currentSize);
            pageBean.setItems(feedbackList);
            pageBean.setRecordsFiltered(pageInfo.getTotal());
            pageBean.setRecordsTotal(pageInfo.getTotal());
            return new ResultUtil().success(pageBean);
    }
    /**
     * 根据series  product  creator 模糊查询
     * @param currentPage
     * @param currentSize
     * @param  data
     * @return
     */
    @Override
    public ResultUtil findByVague(Integer currentPage, Integer currentSize,String data) {
        PageHelper.startPage(currentPage,currentSize,true);
        List<Feedback> feedbackList = feedbackMapper.findFeedbackByString(data);
        PageInfo<Feedback> pageInfo = new PageInfo<Feedback>(feedbackList);
        PageBean<Feedback> pageBean = new PageBean<Feedback>();
        pageBean.setCurrentPage(currentPage);
        pageBean.setCurrentSize(currentSize);
        pageBean.setItems(feedbackList);
        pageBean.setRecordsFiltered(pageInfo.getTotal());
        pageBean.setRecordsTotal(pageInfo.getTotal());
        return new ResultUtil().success(pageBean);
    }

    /**
     * 导出excel
     * @return
     */
    @Override
    public XSSFWorkbook exportExcel() {
        List<FeedbackExcel> feedbackList = feedbackMapper.findAllByExcel();
         /***************************************设置excel里购买产品*************************************************************/
        List<Product> productList =  productMapper.findAll();
        Map<Integer,String> productMap = new HashMap<>();
        for(Product product : productList){
            productMap.put(product.getId(),product.getProductName());
        }
        for(FeedbackExcel feedbackExcel : feedbackList){
            String purchases = feedbackExcel.getPurchase();
            List<Integer> list = TypeUtils.arrayStingToList(purchases);
            StringBuilder build = new StringBuilder("");
           for(Integer num : list ){
               build.append(productMap.get(num)+",");
           }
            feedbackExcel.setPurchase(build.toString());
           if(feedbackExcel.getSex() == 0){
               feedbackExcel.setSexString("男");
           }else{
               feedbackExcel.setSexString("女");
           }
        }
        /***************************************************************************************************************************/
        List<ExcelBean> excelBeanList = new ArrayList<>();
        String[] headArray ={"序号","所属系列","所属产品","现状说明","创意/建议描述","附件/图片" ,"创意提出人","提出方式","所属国家","性别","年龄","职业","职位","联系方式","是否为公司客户","购买的产品","创意提交人","提交日期"};
        String[] propArray ={ "id" ,"series", "product", "condition","idea","image","user",  "method",  "country",   "sexString",   "age",  "career", "position", "contactinfo", "iscustomer", "purchase", "creator", "commitdate"           };
        for(int i = 0; i < 18; i++){
            ExcelBean excelBean = new ExcelBean();
            excelBean.setHeadTextName(headArray[i]);
            excelBean.setPropertyName(propArray[i]);
            excelBean.setCols(0);
            excelBeanList.add(excelBean);
        }
        Map<Integer, List<ExcelBean>> map = new HashMap<>();
        map.put(0,excelBeanList);
        XSSFWorkbook excel = null;

       try{
            excel =  ExcelUtil.createExcelFile(FeedbackExcel.class,feedbackList,map,"用户反馈意见");
            return excel;
       }catch(Exception e){
           return null;
       }

    }
}
