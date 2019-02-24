package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.domain.Product;
import com.itheima.mapper.ProductMapper;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public PageInfo<Product> list(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        List<Product> products = productMapper.list();
        return new PageInfo<>(products);
    }

    @Override
    public int add(Product product) {
        int count = productMapper.add(product);
        return count;
    }

    @Override
    public int update(Product product) {
        int ucount = productMapper.update(product);
        return ucount;
    }

    @Override
    public Product getProduct(Integer id) {
        Product product = productMapper.getProduct(id);
        return product;
    }

    @Override
    public int delete(Integer id) {
        int dcount = productMapper.delete(id);
        return dcount;
    }
}
