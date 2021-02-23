package com.sansan.tool.api.util;

import com.auth0.jwt.JWT;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author siss
 * @date 2020/11/13  14:34
 */
public class TokenUtil {

    public static String getTokenUserId() {
        // 从 http 请求头中取出 token
        String token = getRequest().getHeader("token");
        if(StringUtils.isEmpty(token)){
            token = getRequest().getParameter("token");
        }
        String userId = JWT.decode(token).getAudience().get(0);
        return userId;
    }

    /**
     * 获取request
     *
     * @return
     */
    public static HttpServletRequest getRequest() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        return requestAttributes == null ? null : requestAttributes.getRequest();
    }
}
