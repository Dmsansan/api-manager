package com.sansan.tool.api.user.service.impl;

import com.sansan.tool.api.entity.user.ApiUser;
import com.sansan.tool.api.entity.user.ApiUserExample;
import com.sansan.tool.api.user.mapper.ApiUserMapper;
import com.sansan.tool.api.user.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class UserInfoServiceImpl implements UserInfoService {

    private Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    @Autowired
    private ApiUserMapper apiUserMapper;

    @Override
    public String getUser() {
        ApiUserExample apiUserExample = new ApiUserExample();
        apiUserExample.createCriteria().andDeleteStatusEqualTo(0);
        apiUserExample.setOrderByClause("add_time desc");

        long count = apiUserMapper.countByExample(apiUserExample);
        logger.debug("查询用户数据总记录数：{}", count);

        apiUserExample.createCriteria().andIdBetween(0,1);
        List<ApiUser> userInfo = apiUserMapper.selectByExample(apiUserExample);
        return userInfo.toString();
    }


}
