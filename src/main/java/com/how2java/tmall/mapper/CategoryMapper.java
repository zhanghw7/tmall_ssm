package com.how2java.tmall.mapper;

import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.util.Page;

import java.util.List;

public interface CategoryMapper {
    List<Category> list();
    List<Category> listByPage(Page page);
    int total();
}
