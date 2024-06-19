package com.example.news.config;

import com.github.pagehelper.PageInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;
//自动分页插件
//https://zhuanlan.zhihu.com/p/453238791
@Configuration
public class PageHelperConfigure {
    @Bean
    public PageInterceptor pageHelper() {
        // 注意这里使用的 PageInterceptor
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum","true");
        properties.setProperty("rowBoundsWithCount","true");
        properties.setProperty("reasonable","true");
        properties.setProperty("helperDialect", "mysql");
        properties.setProperty("supportMethodsArguments","true");
        properties.setProperty("params","count=countSql");
        pageInterceptor.setProperties(properties);
        return pageInterceptor;
    }
}