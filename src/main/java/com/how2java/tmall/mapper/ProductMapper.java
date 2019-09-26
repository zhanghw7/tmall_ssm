package com.how2java.tmall.mapper;

import com.how2java.tmall.pojo.Product;

import java.util.List;

public interface ProductMapper {
    List<Product> list(int cid);
    void add(Product product);
    void delete(int id);
    Product get(int id);
    void update(Product product);
}
