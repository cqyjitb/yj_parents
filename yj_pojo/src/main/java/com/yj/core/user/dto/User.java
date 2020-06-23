package com.yj.core.user.dto;

import lombok.Data;

@Data
public class User {
    private Integer userId;
    private String userCode;
    private String userName;
    private String password;
    private Integer age;
    private String sex;
    private Integer userRoleId;

}