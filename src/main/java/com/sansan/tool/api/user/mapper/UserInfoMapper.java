package com.sansan.tool.api.user.mapper;

import com.sansan.tool.api.entity.user.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoMapper {

    List<UserInfo> getUserInfo();
}
