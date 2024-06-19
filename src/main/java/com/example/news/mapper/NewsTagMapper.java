package com.example.news.mapper;

import com.example.news.domain.NewsTag;
import com.example.news.domain.TagNewsCount;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author gjx
* @description 针对表【tb_news_tag】的数据库操作Mapper
* @createDate 2023-11-27 01:20:16
* @Entity com.example.news.domain.NewsTag
*/
@Mapper
public interface NewsTagMapper {

    int deleteByPrimaryKey(Long id);

    int insert(NewsTag record);

    int insertSelective(NewsTag record);

    NewsTag selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NewsTag record);

    int updateByPrimaryKey(NewsTag record);

    List<NewsTag> selectAll();

    List<TagNewsCount> selectTagNewsCounts();

}
