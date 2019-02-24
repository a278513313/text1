package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Orders;
import com.itheima.domain.Product;
import com.itheima.service.OrderService;
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
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/plist")
    public String getProductNames(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "size", required = false, defaultValue = "2") Integer size,
            Model model){
        PageInfo<Product> plist = productService.list(page, size);
        model.addAttribute("plist",plist);
        return "redirect:/order/add";
    }

    @RequestMapping(value = "/add")
    public String add(Orders order){
        int count = orderService.add(order);
        return "redirect:/order/list";
    }

    @RequestMapping(value = "/list")
    public String list(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "size", required = false, defaultValue = "2") Integer size,
            Model model){
        PageInfo<Orders> pageInfo = orderService.list(page, size);
        model.addAttribute("pageInfo",pageInfo);
        return "order-list";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable(value = "id") Long id, Model model){
        int ucount = orderService.getOrder(id);
        return "/order-update";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(Orders order){
        int ucount = orderService.update(order);
        return "redirect:/order/plist";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable(value = "id")Long id){
        int dcount = orderService.delete(id);
        return "redirect:/order/list";
    }
}
