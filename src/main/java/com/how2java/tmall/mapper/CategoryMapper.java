package com.how2java.tmall.mapper;

import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.util.Page;

import java.util.List;

public interface CategoryMapper {
    List<Category> list();
    void add(Category category);
    void delete(Category category);
    Category get(int id);
    void update(Category category);
}
