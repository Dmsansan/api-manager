package com.sansan.tool.api.user.controller;

import com.sansan.tool.api.user.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET, produces = "application/json;utf-8")
    public String getUserInfo(){
        return userInfoService.getUser();
    }
}
