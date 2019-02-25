package cn.itcast.service;

import cn.itcast.domain.Product;

import java.util.List;

public interface ProductService {
    /**
     * 查询所有
     * @return
     * @param currentPage
     * @param pageSize
     */
    List<Product> findAll(Integer currentPage, Integer pageSize);

    void add(Product product);
}
