package com.example.news.mapper;

import com.example.news.domain.AdminUser;
import org.apache.ibatis.annotations.Param;

/**
* @author gjx
* @description 针对表【tb_admin_user】的数据库操作Mapper
* @createDate 2023-11-13 01:18:10
* @Entity com.example.news.domain.AdminUser
*/
public interface AdminUserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(AdminUser record);

    int insertSelective(AdminUser record);

    AdminUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AdminUser record);

    int updateByPrimaryKey(AdminUser record);

    //登陆
    AdminUser login(@Param("uname") String username, @Param("passwd") String password);
}
