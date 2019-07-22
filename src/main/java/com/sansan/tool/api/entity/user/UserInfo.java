package com.sansan.tool.api.entity.user;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class UserInfo {
    private int id;
    private String userName;
    private String passWord;
    private Date addTime;
    private Date lastUpdateTime;
    private int deleteStatus;

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", addTime=" + addTime +
                ", lastUpdateTime=" + lastUpdateTime +
                ", deleteStatus=" + deleteStatus +
                '}';
    }
}
