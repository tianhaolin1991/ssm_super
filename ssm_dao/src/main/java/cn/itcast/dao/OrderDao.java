package cn.itcast.dao;

import cn.itcast.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("orderDao")
public interface OrderDao {

     List<Order> findAll();
}
