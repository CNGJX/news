package com.example.news;

import cn.hutool.crypto.SecureUtil;
import com.example.news.domain.News;
import com.example.news.domain.NewsComment;
import com.example.news.mapper.NewsMapper;
import com.example.news.service.NewsService;
import com.github.pagehelper.PageHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest

//单元测试并不会真的插入数据，修改，删除，只有在测试时插入，测试完之后会回滚
@Transactional
public class NewsApplicationTests {
    @Autowired
    private NewsMapper newsMapper;

    @Autowired
    private NewsService newsService;

    /**
     * 一个新闻对象，有一个属性 是集合，集合中存的是 针对这个新闻的所有评论
     */
    @Test
    public  void testSelectById() {
        News news = newsMapper.selectNewsAndCommentsById(6L);
        Assertions.assertNotNull(news);
        System.out.println(news);
        List<NewsComment> commentList = news.getCommentList();
        Assertions.assertNotNull(commentList);
        Assertions.assertTrue(commentList.size() > 0);
        System.out.println(commentList);
    }

    @Test
    public void testSelectAll() {
        PageHelper.startPage(1, 5);
        List<News> newsList = newsMapper.selectAll();
        Assertions.assertNotNull(newsList);
        Assertions.assertTrue(newsList.size() > 0);
        newsList.forEach(news -> {
            System.out.println(news);
        });
    }

    @Test
    public void testSelectMoHu() {
        List<News> newsList = newsMapper.selectMoHu("hello");
        Assertions.assertNotNull(newsList);
        Assertions.assertTrue(newsList.size() > 0);
        newsList.forEach(news -> {
            System.out.println(news);
        });
    }

    @Test
    public void testMD5(){
        String str = "123456";
        String target = SecureUtil.md5(str);
        System.out.println(target);
    }

    //TestCase 用例
    @Test
    public void testAddNews(){
        News news = new News();
        news.setNewsTitle("测试");
        news.setNewsCategoryId(25);
        news.setNewsContent("开会 学习Java");
        news.setNewsTags("通知,工作,Java");
        boolean isSaveOk = newsService.saveNews(news);
        Assertions.assertTrue(isSaveOk);

        //验证符合预期
    }

}
