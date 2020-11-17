package com.sansan.tool.api.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.sansan.tool.api.annotation.UserLoginToken;
import com.sansan.tool.api.entity.user.ApiUser;
import com.sansan.tool.api.user.service.UserInfoService;
import com.sansan.tool.api.user.service.impl.TokenService;
import com.sansan.tool.api.util.TokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
@Api(tags = "用户管理")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private TokenService tokenService;

    @UserLoginToken
    @ApiOperation(value = "getUserInfo", notes = "获取用户数据")
    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ApiUser> getUserInfo(){
        return userInfoService.getUser();
    }


    @UserLoginToken
    @ApiOperation(value = "addUserInfo", notes = "添加用户数据")
    @RequestMapping(value = "/addUserInfo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void addUserInfo(@RequestBody ApiUser apiUser){
        userInfoService.addUser(apiUser);
    }

    @ApiOperation(value = "login", notes = "用户登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object login(ApiUser user, HttpServletResponse response) {
        JSONObject jsonObject = new JSONObject();
        ApiUser userForBase = new ApiUser();
        userForBase.setId(userInfoService.findByUsername(user).getId());
        userForBase.setUserName(userInfoService.findByUsername(user).getUserName());
        userForBase.setPassWord(userInfoService.findByUsername(user).getPassWord());
        if (StringUtils.isEmpty(userForBase.getPassWord()) ||
                !userForBase.getPassWord().equals(user.getPassWord())) {
            jsonObject.put("message", "登录失败,密码错误");
            return jsonObject;
        } else {
            String token = tokenService.getToken(userForBase);
            jsonObject.put("token", token);

            Cookie cookie = new Cookie("token", token);
            cookie.setPath("/");
            response.addCookie(cookie);

            return jsonObject;
        }
    }

    @UserLoginToken
    @ApiOperation(value = "getMessage", notes = "获取信息")
    @RequestMapping(value = "/getMessage", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getMessage() {
        // 取出token中带的用户id 进行操作
        System.out.println(TokenUtil.getTokenUserId());

        return "您已通过验证";
    }
}
