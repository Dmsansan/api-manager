package com.sansan.tool.api.user.controller;

import com.sansan.tool.api.entity.user.ApiUser;
import com.sansan.tool.api.user.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
@Api(tags = "用户管理")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @ApiOperation(value = "getUserInfo", notes = "获取用户数据")
    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET, produces = "application/json;utf-8")
    public List<ApiUser> getUserInfo(){
        return userInfoService.getUser();
    }
}
