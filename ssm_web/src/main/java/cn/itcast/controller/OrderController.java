package cn.itcast.controller;

import cn.itcast.domain.Order;
import cn.itcast.service.OrderService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(defaultValue = "1")Integer currentPage, @RequestParam(defaultValue = "5")Integer pageSize){
        List<Order> orderList = orderService.findAll(currentPage,pageSize);
        PageInfo<Order> orderPageInfo = new PageInfo<>(orderList);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("orderPageInfo",orderPageInfo);
        modelAndView.setViewName("orders-list");
        return modelAndView;
    }

    @RequestMapping("/findById")
    public ModelAndView findById(String id){
        Order order =  orderService.findById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("orderDetail",order);
        modelAndView.setViewName("orders-show");
        return modelAndView;
    }

}
