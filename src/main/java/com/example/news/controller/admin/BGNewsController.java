package com.example.news.controller.admin;

import com.example.news.domain.News;
import com.example.news.service.CategoryService;
import com.example.news.service.NewsService;
import com.example.news.utils.NewsConstants;
import com.example.news.utils.PageResult;
import com.example.news.utils.Result;
import com.example.news.utils.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class BGNewsController {
    @Autowired
    private NewsService newsService;
    @Autowired
    private CategoryService categoryService;

    //指向 新闻管理页面
    @GetMapping("/blogs")
    public String list(HttpServletRequest request) {
        //为了传递值给前端页面 ，页面根据他来决定左侧导航菜单高亮显示哪个
        request.setAttribute("path", "blogs");
        return "admin/blog";
    }

    // 后台 获取新闻列表  ，这个接口是一个标准的返回JSON格式的接口
    //可选参数 @RequestParam(name = "keyword", required = false)
    @GetMapping("/blogs/list")
    //结果会被转化为JSON结构
    @ResponseBody
    public Result newsList(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit,
                           @RequestParam(name = "keyword", required = false) String keyword){
        PageResult pageNewsRs = newsService.getPageNews(page, limit, keyword);
        Result result = new Result();
        result.setResultCode(NewsConstants.RESULT_OK);
        result.setData(pageNewsRs);
        return result;
    }

    //跳转 新增和编辑页面
    @GetMapping("/blogs/edit")
    public String edit(HttpServletRequest request) {
        request.setAttribute("path", "edit");
        request.setAttribute("categories", categoryService.getAllCategories());
        return "admin/edit";
    }

    //新闻管理-新增   返回JSON
    @PostMapping("/blogs/save")
    @ResponseBody
    public Result save(@RequestParam("blogTitle") String blogTitle,
                       @RequestParam(name = "blogSubUrl", required = false) String blogSubUrl,
                       @RequestParam("blogCategoryId") Integer blogCategoryId,
                       @RequestParam("blogTags") String blogTags,
                       @RequestParam("blogContent") String blogContent,
                       @RequestParam("blogCoverImage") String blogCoverImage,
                       @RequestParam("blogStatus") Integer blogStatus,
                       @RequestParam("enableComment") Integer enableComment) {
        if (!StringUtils.hasText(blogTitle)) {
            return ResultGenerator.genFailResult("请输入文章标题");
        }
        if (blogTitle.trim().length() > 150) {
            return ResultGenerator.genFailResult("标题过长");
        }
        if (!StringUtils.hasText(blogTags)) {
            return ResultGenerator.genFailResult("请输入文章标签");
        }
        if (blogTags.trim().length() > 150) {
            return ResultGenerator.genFailResult("标签过长");
        }
        if (blogSubUrl.trim().length() > 150) {
            return ResultGenerator.genFailResult("路径过长");
        }
        if (!StringUtils.hasText(blogContent)) {
            return ResultGenerator.genFailResult("请输入文章内容");
        }
        if (blogTags.trim().length() > 100000) {
            return ResultGenerator.genFailResult("文章内容过长");
        }
        if (!StringUtils.hasText(blogCoverImage)) {
            return ResultGenerator.genFailResult("封面图不能为空");
        }
        News news = new News();
        news.setNewsTitle(blogTitle);
        news.setNewsSubUrl(blogSubUrl);
        news.setNewsCategoryId(blogCategoryId);
        news.setNewsTags(blogTags);
        news.setNewsContent(blogContent);
        news.setNewsCoverImage(blogCoverImage);
        news.setNewsStatus(blogStatus);
        news.setEnableComment(enableComment);
        boolean isOk = newsService.saveNews(news);
        if (isOk) {
            return ResultGenerator.genSuccessResult("添加成功");
        } else {
            return ResultGenerator.genFailResult("添加失败");
        }
    }

    //新闻逻辑删除
    @PostMapping("/blogs/delete")
    @ResponseBody
    public Result delete(@RequestBody Integer[] ids) {
        if (ids.length < 1) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        if (newsService.deleteBatch(ids)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("删除失败");
        }
    }

}
