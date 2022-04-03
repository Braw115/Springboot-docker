package com.pitaka.www.pitakaController;

import com.pitaka.www.service.FeedbackService;
import com.pitaka.www.utils.ResultUtil;
import com.pitaka.www.vo.FeedbackVO;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("v1/feedback")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    /**
     * 添加反馈记录
     *
     * @param feedbackVO
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResultUtil addFeedback(FeedbackVO feedbackVO) {
        int result = feedbackService.addFeedback(feedbackVO);
        if (result > 0) {
            return new ResultUtil(200, "添加成功！");
        }
        return ResultUtil.error(500, "添加失败！");
    }

    /**
     * 删除反馈记录
     *
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public ResultUtil delFeedback(Integer id) {
        int result = feedbackService.delFeedback(id);
        if (result > 0) {
            return new ResultUtil(200, "删除成功！");
        }
        return new ResultUtil().error(500, "删除失败");
    }

    /**
     * 更新反馈记录
     *
     * @param feedbackVO
     * @return
     */
    @RequestMapping( value ="update",method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResultUtil updateFeedack(FeedbackVO feedbackVO) {

        int result = feedbackService.updateFeedback(feedbackVO);
        if (result > 0) {
            return new ResultUtil(200, "更新成功！");
        }
        return new ResultUtil().error(500, "更新失败！");

    }

    /**
     * 根据id查询反馈记录
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ResultUtil findFeedbackById(@RequestParam("id") Integer id) {
        return feedbackService.findFeedbackById(id);
    }

    /**
     * 分页查询反馈记录
     *
     * @param start
     * @param length
     * @return
     */
    @RequestMapping(value = "all", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ResultUtil findFeedBypage(@RequestParam(value = "start", defaultValue = "1", required = false) Integer start,
                                     @RequestParam(value = "length", defaultValue = "10", required = false) Integer length) {
        return feedbackService.findFeedbackByPage(start, length);

    }

    /**
     * 根据series  product  creator 模糊查询
     *
     * @param data
     * @param start
     * @param length
     * @return
     */

    @RequestMapping(value = "/{data}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ResultUtil findByVague(@PathVariable(value = "data") String data,
                                  @RequestParam(value = "start", defaultValue = "1", required = false) Integer start,
                                  @RequestParam(value = "length", defaultValue = "10", required = false) Integer length) {
        return feedbackService.findByVague(start, length, data);
    }

    @RequestMapping(value = "excel", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public void exportExcel(HttpServletRequest request, HttpServletResponse response) {
        XSSFWorkbook workbook = null;
        response.reset(); //清除buffer缓存
        Map<String, Object> map = new HashMap<String, Object>();
        // 指定下载的文件名
        response.setHeader("Content-Disposition", "attachment;filename=" + "feedback.xlsx");
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        //导出Excel对象
        workbook = feedbackService.exportExcel();
        OutputStream output;
        try {
            output = response.getOutputStream();
            BufferedOutputStream bufferedOutPut = new BufferedOutputStream(output);
            bufferedOutPut.flush();
            workbook.write(bufferedOutPut);
            bufferedOutPut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping(value = "test", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public Object test() {
        Map<String,String> map = new HashMap<>();
        map.put("test","docker");
        map.put("title","helloworld");
        map.put("name","local branch is not pushed");
        return map ;
    }

}