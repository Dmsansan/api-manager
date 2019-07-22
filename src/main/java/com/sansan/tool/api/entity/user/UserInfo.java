package com.sansan.tool.api.entity.user;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserInfo {
    private int id;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
