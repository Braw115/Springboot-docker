package com.pitaka.www.service;

import com.pitaka.www.utils.ResultUtil;
import com.pitaka.www.vo.FeedbackVO;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public interface FeedbackService {

    /**
     * 添加反馈记录
     * @return
     */
    int addFeedback(FeedbackVO feedbackVO);

    /**
     * 删除反馈记录
     * @param id
     * @return
     */
    int delFeedback(Integer id);

    /**
     * 修改(更新)反馈记录
     * @param feedbackVO
     * @return
     */

    int updateFeedback(FeedbackVO feedbackVO);

    /**
     * 根据id查询反馈记录
     * @param id
     * @return
     */

    ResultUtil findFeedbackById(Integer id);

    /**
     * 分页查询所有记录
     * @return
     */

    ResultUtil findFeedbackByPage(Integer currentPage, Integer currentSize) ;

    /**
     * 根据series  product  creator 模糊查询
     * @param currentPage
     * @param currentSize
     * @param  data
     * @return
     */
    ResultUtil findByVague(Integer currentPage, Integer currentSize,String data);

    /**
     * 导出excel
     * @return
     */
    XSSFWorkbook exportExcel();


}
