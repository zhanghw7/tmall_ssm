package com.how2java.tmall.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.Property;
import com.how2java.tmall.service.CategoryService;
import com.how2java.tmall.service.PropertyService;
import com.how2java.tmall.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.PublicKey;
import java.util.List;
@Controller
public class PropertyController {
    @Autowired
    PropertyService propertyService;
    @Autowired
    CategoryService categoryService;


    @RequestMapping("admin_property_list")
    public String list(Model model , Property property, Page page){
        Category c = categoryService.get(property.getCid());
        PageHelper.offsetPage(page.getStart(),page.getCount());
       List<Property>  ps =  propertyService.list(property.getCid());
       int total = (int) new PageInfo<>(ps).getTotal();
       page.setTotal(total);
       page.setParam("&cid="+c.getId());
       model.addAttribute("ps",ps);
       model.addAttribute("c",c);
       model.addAttribute("page",page);
       return "admin/listProperty";
    }
    @RequestMapping("admin_property_add")
    public String add(Property property,Model model){
        propertyService.add(property);
        return "redirect:admin_property_list?cid="+property.getCid();
    }
    @RequestMapping("admin_property_edit")
    public String edit(Model model,Property property){
        Property p = propertyService.get(property.getId());
        model.addAttribute("p",p);

        return "admin/editProperty";
    }
    @RequestMapping("admin_property_update")
    public String update(Property property){
        propertyService.update(property);
        return "redirect:admin_property_list?cid="+property.getCid();
    }
    @RequestMapping("admin_property_delete")
    public String delete(int id){
        int cid = propertyService.get(id).getCid();
        propertyService.delete(id);

        return "redirect:admin_property_list?cid="+cid;
    }
}
