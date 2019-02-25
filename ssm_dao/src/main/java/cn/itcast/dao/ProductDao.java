package cn.itcast.dao;

import cn.itcast.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("productDao")
public interface ProductDao {

    List<Product> findAll();

    void add(Product product);
}
