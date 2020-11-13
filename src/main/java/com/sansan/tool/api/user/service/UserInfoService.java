package com.sansan.tool.api.user.service;

import com.sansan.tool.api.entity.user.ApiUser;

import java.util.List;

public interface UserInfoService {

    List<ApiUser> getUser();

    void addUser(ApiUser apiUser);

    ApiUser findByUsername(ApiUser user);

    ApiUser findUserById(String userId);
}
