package com.example.news.service;

import com.example.news.domain.News;
import com.example.news.utils.PageResult;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface NewsService {

     List<News> getAllNews();

     News getById(Long newsID);

     /**
      * 查询新闻列表，带有分页数据
      * @param pageNO 页码
      * @param pageSize 每页记录条数
      * @param keyword
      * @return
      */
     PageResult getPageNews(Integer pageNO, Integer pageSize, String keyword);

    boolean saveNews(News news);

    //把文章的访问量+1
    int updateNewsViews(Long newsId);

    //最新发布
    List<News> latestTime();

    //最多点击量
    List<News> maxNewsViews();

    //后台新闻逻辑删除
    Boolean deleteBatch(Integer[] ids);
}
