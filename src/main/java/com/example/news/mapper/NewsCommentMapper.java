package com.example.news.mapper;

import com.example.news.domain.NewsComment;
import com.example.news.utils.PageBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author gjx
* @description 针对表【tb_news_comment】的数据库操作Mapper
* @createDate 2023-10-16 00:07:24
* @Entity com.example.news.domain.NewsComment
*/
@Mapper
public interface NewsCommentMapper {

    int deleteByPrimaryKey(Long id);

    int insert(NewsComment record);

    int insertSelective(NewsComment record);

    NewsComment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NewsComment record);

    int updateByPrimaryKey(NewsComment record);

    List<NewsComment> findNewsCommentList(PageBean pageBean);

    Boolean checkDone(Integer[] ids);
}
