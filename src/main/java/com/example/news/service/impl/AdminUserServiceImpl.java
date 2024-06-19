package com.example.news.service.impl;

import com.example.news.domain.AdminUser;
import com.example.news.mapper.AdminUserMapper;
import com.example.news.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminUserServiceImpl implements AdminUserService {
    @Autowired
    private AdminUserMapper userMapper;

    @Override
    public AdminUser login(String username, String password) {
        AdminUser user = userMapper.login(username, password);
        return user;
    }
}
