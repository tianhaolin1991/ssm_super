package cn.itcast.service;

import cn.itcast.domain.Order;

import java.util.List;

public interface OrderService {

    List<Order> findAll(Integer currentPage, Integer pageSize);

    Order findById(String id);
}
