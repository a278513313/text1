package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.domain.Orders;
import com.itheima.mapper.OrderMapper;
import com.itheima.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public int add(Orders order) {
        int count = orderMapper.add(order);
        return count;
    }

    @Override
    public PageInfo<Orders> list(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        List<Orders> orders = orderMapper.list();
        return new PageInfo<>(orders);
    }

    @Override
    public int getOrder(Long id) {
        int ucount = orderMapper.getOrder(id);
        return ucount;
    }

    @Override
    public int update(Orders order) {
        int ucount = orderMapper.update(order);
        return ucount;
    }

    @Override
    public int delete(Long id) {
        int dcount = orderMapper.delete(id);
        return dcount;
    }
}
