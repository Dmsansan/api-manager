package com.sansan.tool.api.user.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.sansan.tool.api.entity.user.ApiUser;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author siss
 * @date 2020/11/13  14:20
 */
@Service
public class TokenService {

    public String getToken(ApiUser user) {
        Date start = new Date();
        // 1h有效时间
        long currentTime = System.currentTimeMillis() + 60* 60 * 1000;
        Date end = new Date(currentTime);
        String token = "";

        token = JWT.create().withAudience(String.valueOf(user.getId())).withIssuedAt(start).withExpiresAt(end)
                .sign(Algorithm.HMAC256(user.getPassWord()));
        return token;
    }
}
