package cn.itcast.service.impl;

import cn.itcast.dao.ProductDao;
import cn.itcast.domain.Product;
import cn.itcast.service.ProductService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Override
    public List<Product> findAll(Integer currentPage, Integer pageSize) {
        if(currentPage==null){
            currentPage = 1;
        }
        if(pageSize==null){
            pageSize = 5;
        }
        PageHelper.startPage(currentPage,pageSize);
        return productDao.findAll();
    }

    @Override
    public void add(Product product) {
        productDao.add(product);
    }
}
