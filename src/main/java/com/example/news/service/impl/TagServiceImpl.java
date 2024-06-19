package com.example.news.service.impl;

import com.example.news.domain.TagNewsCount;
import com.example.news.mapper.NewsTagMapper;
import com.example.news.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private NewsTagMapper newsTagMapper;

    @Override
    public List<TagNewsCount> getAll() {
        return newsTagMapper.selectTagNewsCounts();
    }
}
