package com.pitaka.www.mapper;

import com.pitaka.www.model.Feedback;
import com.pitaka.www.model.FeedbackExcel;
import com.pitaka.www.vo.FeedbackVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FeedbackMapper {
    /**
     * 添加反馈记录
     * @return
     */
    int insertFeedback(FeedbackVO feedbackVO);

    /**
     * 删除反馈记录
     * @param id
     * @return
     */
    int delFeedback(@Param("id") Integer id);

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
    FeedbackVO findFeedbackById(@Param("id") Integer id);

    /**
     * 分页查询所有记录
     * @return
     */
    List<Feedback> findAllFeedback();

    /**
     * 模糊查询
     * @param data
     * @return
     */
    List<Feedback> findFeedbackByString(@Param("data") String  data);

    /**
     * 按excel格式查询
     * @return
     */
    List<FeedbackExcel> findAllByExcel();
}
