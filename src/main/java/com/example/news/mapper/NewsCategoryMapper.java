package com.example.news.mapper;

import com.example.news.domain.NewsCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author gjx
* @description 针对表【tb_news_category】的数据库操作Mapper
* @createDate 2023-10-16 00:07:24
* @Entity com.example.news.domain.NewsCategory
*/
@Mapper
public interface NewsCategoryMapper {

    int deleteByPrimaryKey(Long id);

    int insert(NewsCategory record);

    int insertSelective(NewsCategory record);

    NewsCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NewsCategory record);

    int updateByPrimaryKey(NewsCategory record);

    List<NewsCategory> findAll();

}
