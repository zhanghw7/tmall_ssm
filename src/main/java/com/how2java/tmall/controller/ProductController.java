package com.how2java.tmall.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.tmall.mapper.CategoryMapper;
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.service.ProductService;
import com.how2java.tmall.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryMapper categoryMapper;

    @RequestMapping("admin_product_list")
    public String list(Model model, Page page,int cid){
        Category c = categoryMapper.get(cid);
        PageHelper.offsetPage(page.getStart(),page.getCount());
        List<Product> ps = productService.list(cid);
        int total =(int) new PageInfo<>(ps).getTotal();
        page.setTotal(total);
        page.setParam("&cid="+cid);
        model.addAttribute("ps",ps);
        model.addAttribute("page",page);
        model.addAttribute("c",c);

        return "admin/listProduct";

    }
    @RequestMapping("admin_product_add")
    public String add(Model model,Product product){
        product.setCreateDate(new Date());
        productService.add(product);

        return "redirect:admin_product_list?cid="+product.getCid();
    }
    @RequestMapping("admin_product_delete")
    public String delete(int id){
        Product p = productService.get(id);
         productService.delete(id);
    return "redirect:admin_product_list?cid="+p.getCid();
    }
    @RequestMapping("admin_product_edit")
    public String edit(int id,Model model){
       Product p =  productService.get(id);
        model.addAttribute("p",p);
        Category c= categoryMapper.get(p.getCid());
        model.addAttribute("c",c);
       return "admin/editProduct";
    }
    @RequestMapping("admin_product_update")
    public String update(Product product){
    productService.update(product);
    return "redirect:admin_product_list?cid="+product.getCid();
    }
}
