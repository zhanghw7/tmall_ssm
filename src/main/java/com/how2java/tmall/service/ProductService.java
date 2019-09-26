package com.how2java.tmall.service;

import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.Product;

import java.util.List;

public interface ProductService {
    void add(Product product);
    List<Product> list(int cid);
    void delete(int id);
    Product get(int id);
    void update(Product product);
}
