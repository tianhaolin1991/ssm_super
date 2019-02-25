package cn.itcast.service.impl;

import cn.itcast.dao.OrderDao;
import cn.itcast.domain.Order;
import cn.itcast.service.OrderService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Override
    public List<Order> findAll(Integer currentPage, Integer pageSize) {
        if(currentPage==null){
            currentPage = 1;
        }
        if(pageSize==null){
            pageSize = 5;
        }
        PageHelper.startPage(currentPage,pageSize);
        List<Order> orderList = orderDao.findAll();
        return orderList;
    }

    @Override
    public Order findById(String id) {
        return orderDao.findById(id);
    }
}
