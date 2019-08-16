package com.pitaka.www.pitakaController;


import com.pitaka.www.service.SeriesService;
import com.pitaka.www.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("v1/series")
public class SeriesController {
    @Autowired
    private SeriesService seriesService;

    /**
     *查询所有系列
     * @param
     * @return
     */
    @RequestMapping(value="all", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ResultUtil findAll() {
        return seriesService.findAllSeries();
    }
}