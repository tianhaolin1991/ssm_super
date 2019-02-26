package cn.itcast.controller;

import cn.itcast.domain.Product;
import cn.itcast.service.ProductService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(required=false) Integer currentPage,@RequestParam(required=false)Integer pageSize){
        List<Product> productList = productService.findAll(currentPage,pageSize);
        PageInfo<Product> productPageInfo = new PageInfo<>(productList);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("productList",productPageInfo);
        modelAndView.setViewName("product-list");
        return modelAndView;
    }

    @RequestMapping("/forwardAdd")
    public String forwardAdd(){
        return "product-add";
    }

    @RequestMapping("/add")
    public String add(Product product){
        productService.add(product);
        return "redirect:/product/findAll.do";
    }
}
