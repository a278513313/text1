package com.itheima.service;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Orders;

import java.util.List;

public interface OrderService {
    int add(Orders order);

    PageInfo<Orders> list(Integer page, Integer size);

    int getOrder(Long id);

    int update(Orders order);

    int delete(Long id);
}
