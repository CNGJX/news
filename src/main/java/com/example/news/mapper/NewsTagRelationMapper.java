package com.example.news.mapper;

import com.example.news.domain.NewsTagRelation;
import org.apache.ibatis.annotations.Mapper;

/**
* @author gjx
* @description 针对表【tb_news_tag_relation】的数据库操作Mapper
* @createDate 2023-11-27 01:20:16
* @Entity com.example.news.domain.NewsTagRelation
*/
@Mapper
public interface NewsTagRelationMapper {

    int deleteByPrimaryKey(Long id);

    int insert(NewsTagRelation record);

    int insertSelective(NewsTagRelation record);

    NewsTagRelation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NewsTagRelation record);

    int updateByPrimaryKey(NewsTagRelation record);

}
