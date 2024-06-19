package com.example.news.mapper;



import com.example.news.domain.BlogConfig;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlogConfigMapper {
    List<BlogConfig> selectAll();

    BlogConfig selectByPrimaryKey(String configName);

    int updateByPrimaryKeySelective(BlogConfig record);

}