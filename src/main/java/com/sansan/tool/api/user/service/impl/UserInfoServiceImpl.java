package com.sansan.tool.api.user.service.impl;

import com.sansan.tool.api.entity.user.UserInfo;
import com.sansan.tool.api.user.mapper.UserInfoMapper;
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
    private UserInfoMapper userInfoMapper;

    @Override
    public String getUser() {
        List<UserInfo> userInfo = userInfoMapper.getUserInfo();
        return userInfo.toString();
    }
}
