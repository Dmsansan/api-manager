package com.sansan.tool.api.index.service.impl;

import com.sansan.tool.api.entity.index.ApiUserActivies;
import com.sansan.tool.api.index.mapper.IndexMapper;
import com.sansan.tool.api.index.service.IndexService;
import com.sansan.tool.api.util.DateUtils;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Case;
import org.hibernate.validator.internal.constraintvalidators.bv.time.futureorpresent.FutureOrPresentValidatorForReadableInstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Component
public class IndexServiceImpl implements IndexService {

    @Autowired
    private IndexMapper indexMapper;

    @Override
    public List<ApiUserActivies> queryUserActivies(Date startTime, Date endTime) {
        final Map<String, Object> params = new HashMap<>();
        params.put("startTime", startTime);
        params.put("endTime", endTime);

        return indexMapper.queryUserActivies(params);
    }

    @Override
    public Map<String, Integer> getUserWeeksActivities(List<ApiUserActivies> apiUserActivies) throws ParseException {
        String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String dateStr = DateUtils.getAllDaysOfWeek(format);

        String[] dateArr = dateStr.split("_");
        Integer mon = 0, tue = 0, wed = 0, thu = 0, fri = 0, sat = 0, sun = 0;
        for (ApiUserActivies apiUserActivies1 : apiUserActivies){
            String format1 = new SimpleDateFormat("yyyy-MM-dd").format(apiUserActivies1.getLastLoginTime());
            if(format1.equals(dateArr[0])){
                mon += 1;
            }else if(format1.equals(dateArr[1])){
                tue += 1;
            }else if(format1.equals(dateArr[2])){
                wed += 1;
            }else if(format1.equals(dateArr[3])){
                thu += 1;
            }else if(format1.equals(dateArr[4])){
                fri += 1;
            }else if(format1.equals(dateArr[5])){
                sat += 1;
            }else{
                sun += 1;
            }
        }

        Map<String, Integer> res = new HashMap<>();
        res.put("Mon", mon);
        res.put("Tue", tue);
        res.put("Wed", wed);
        res.put("Thu", thu);
        res.put("Fri", fri);
        res.put("Sat", sat);
        res.put("Sun", sun);
        return res;
    }

}
