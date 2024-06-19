package com.example.news.service;

import com.example.news.domain.AdminUser;

public interface AdminUserService {
    /**
     * 登陆
     * @param username
     * @param password
     * @return 登陆成功后 获取用户信息， 登陆失败 null
     */
    AdminUser login(String username, String password);
}
