package com.sansan.tool.api.entity.index;

import java.util.Date;

public class ApiUserActivies {
    private int id;
    private int userId;
    private String loginIp;
    private int loginCount;
    private Date firstLoginTime;
    private Date lastLoginTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public int getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(int loginCount) {
        this.loginCount = loginCount;
    }

    public Date getFirstLoginTime() {
        return firstLoginTime;
    }

    public void setFirstLoginTime(Date firstLoginTime) {
        this.firstLoginTime = firstLoginTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    @Override
    public String toString() {
        return "ApiUserActivies{" +
                "id=" + id +
                ", userId=" + userId +
                ", loginIp='" + loginIp + '\'' +
                ", loginCount=" + loginCount +
                ", firstLoginTime=" + firstLoginTime +
                ", lastLoginTime=" + lastLoginTime +
                '}';
    }
}
