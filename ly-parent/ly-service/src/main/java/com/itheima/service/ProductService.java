package com.itheima.service;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Product;

import java.util.List;

public interface ProductService {
    PageInfo<Product> list(Integer page, Integer size);

    int add(Product product);

    int update(Product product);

    Product getProduct(Integer id);

    int delete(Integer id);
}
