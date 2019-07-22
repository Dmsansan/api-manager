package com.sansan.tool.api.user.service.impl;

import com.sansan.tool.api.user.service.UserInfoService;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Override
    public String getUser() {
        return "userInfo";
    }
}
