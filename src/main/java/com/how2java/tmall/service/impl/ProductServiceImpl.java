package com.how2java.tmall.service.impl;

import com.how2java.tmall.mapper.CategoryMapper;
import com.how2java.tmall.mapper.ProductMapper;
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;
    @Override
    public void add(Product product) {
        productMapper.add(product);

    }

    @Override
    public List<Product> list(int cid) {
        return productMapper.list(cid);
    }

    @Override
    public void delete(int id) {
        productMapper.delete(id);
    }

    @Override
    public Product get(int id) {
       return productMapper.get(id);
    }

    @Override
    public void update(Product product) {
        productMapper.update(product);
    }
}
