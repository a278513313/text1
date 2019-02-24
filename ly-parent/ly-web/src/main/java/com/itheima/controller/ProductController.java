package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 分页集合查询
     * @param model
     * @return
     */
    @RequestMapping(value = "/list")
    public String list(
            @RequestParam(value = "page", required = false, defaultValue = "1")Integer page,
            @RequestParam(value = "size", required = false, defaultValue = "2")Integer size,
            Model model){
        PageInfo<Product> pageInfo = productService.list(page, size);
        model.addAttribute("pageInfo",pageInfo);
        return "product-list";
    }

    /**
     * 添加产品
     * @param product
     * @return
     */
    @RequestMapping(value = "/add")
    public String add(Product product){
        int count = productService.add(product);
        return "redirect:/product/list";
    }

    /**
     * 产品信息回显
     * @return
     */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String getProduct(@PathVariable(value = "id")Integer id, Model model){
        Product product = productService.getProduct(id);
        model.addAttribute("product",product);
        return "product-update";
    }

    /**
     * 修改产品
     * @param product
     * @return
     */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(Product product){
        int ucount = productService.update(product);
        return "redirect:/product/list";
    }

    /**
     * 删除产品
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable(value = "id")Integer id){
        int dcount = productService.delete(id);
        return "redirect:/product/list";
    }
}
