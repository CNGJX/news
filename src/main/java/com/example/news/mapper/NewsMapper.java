package com.example.news.mapper;

import com.example.news.domain.News;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author gjx
* @description 针对表【tb_news】的数据库操作Mapper
* @createDate 2023-10-16 00:00:40
* @Entity com.example.news.domain.News
*/
@Mapper
public interface NewsMapper {

    int deleteByPrimaryKey(Long id);

    int insert(News record);

    int insertSelective(News record);

    News selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKey(News record);

    // 前台首页 新闻列表查询
    List<News> selectAll();

    // 根据id查询出所有的评论
    /**
     * 单一的新闻对象
     * 带出来评论
     * @param id
     * @return
     */
    News selectNewsAndCommentsById(Long id);

    // 前台首页 新闻列表模糊查询
    List<News> selectMoHu(String gjc);

    /**
     * 发送sql查询 数据  limit (页码-1) * 每页条数
     * @param start limit 第一个参数
     * @param recordSize 取多少条数据
     * @param keyword
     * @return
     */
    List<News> selectByPage(@Param("start") Integer start, @Param("recordSize") Integer recordSize, @Param("keyword") String keyword);

    int selectNewsCount(@Param("keyword") String keyword);

    int increateViews(@Param("newsId") Long newsId);

    //最新发布
    List<News> latestTime();

    //最多点击量
    List<News> maxNewsViews();

    //后台新闻逻辑删除
    int deleteBatch(Integer[] ids);
}
