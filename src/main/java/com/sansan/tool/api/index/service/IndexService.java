package com.sansan.tool.api.index.service;

import com.sansan.tool.api.entity.index.ApiUserActivies;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface IndexService {

    List<ApiUserActivies> queryUserActivies(Date startTime, Date endTime);

    Map<String, Integer> getUserWeeksActivities(List<ApiUserActivies> apiUserActivies) throws ParseException;
}
