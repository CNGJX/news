package com.example.news.service;

import com.example.news.domain.TagNewsCount;

import java.util.List;

public interface TagService {
    List<TagNewsCount> getAll();
}
