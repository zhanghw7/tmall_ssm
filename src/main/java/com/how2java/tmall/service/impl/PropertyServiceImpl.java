package com.how2java.tmall.service.impl;

import com.how2java.tmall.mapper.PropertyMapper;
import com.how2java.tmall.pojo.Property;
import com.how2java.tmall.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    PropertyMapper propertyMapper;
    @Override
    public List<Property> list(int cid) {
        return propertyMapper.list(cid);
    }

    @Override
    public Property get(int id) {
        return propertyMapper.get(id);
    }

    @Override
    public void add(Property property) {
        propertyMapper.add(property);

    }

    @Override
    public void update(Property property) {
        propertyMapper.update(property);
    }

    @Override
    public void delete(int id) {
        propertyMapper.delete(id);
    }
}
