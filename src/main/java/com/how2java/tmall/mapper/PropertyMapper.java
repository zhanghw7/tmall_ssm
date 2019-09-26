package com.how2java.tmall.mapper;

import com.how2java.tmall.pojo.Property;

import java.util.List;

public interface PropertyMapper {
    List<Property> list(int cid);
    void add(Property property);
    Property get(int id);
    void update(Property property);
    void delete(int id);
}
