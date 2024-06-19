package com.example.news.service.impl;

import com.example.news.domain.NewsCategory;
import com.example.news.mapper.NewsCategoryMapper;
import com.example.news.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private NewsCategoryMapper categoryMapper;

    @Override
    public List<NewsCategory> getAllCategories() {
        return categoryMapper.findAll();
    }
}
