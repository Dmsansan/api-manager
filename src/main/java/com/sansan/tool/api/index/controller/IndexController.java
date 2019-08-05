package com.sansan.tool.api.index.controller;

import com.sansan.tool.api.entity.index.ApiUserActivies;
import com.sansan.tool.api.index.service.IndexService;
import com.sansan.tool.api.util.DateUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/index")
@Api(tags = "首页")
public class IndexController {

    @Autowired
    private IndexService indexService;

    @ApiOperation(value = "initIndexData", notes = "初始化首页数据")
    @RequestMapping(value = "/initIndexData", method = RequestMethod.GET, produces = "application/json;utf-8")
    public ResponseEntity<?> initIndexData() throws ParseException {
        String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String dateStr = DateUtils.getFirstAndLastOfWeek(format, "yyyy-MM-dd", "yyyy-MM-dd");

        String strTime = dateStr.split("_")[0];
        String endTime = dateStr.split("_")[1];

        List<ApiUserActivies> apiUserActivies = indexService.queryUserActivies(new SimpleDateFormat("yyyy-MM-dd").parse(strTime),
                new SimpleDateFormat("yyyy-MM-dd").parse(endTime));

        Map<String, Integer> result = indexService.getUserWeeksActivities(apiUserActivies);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
