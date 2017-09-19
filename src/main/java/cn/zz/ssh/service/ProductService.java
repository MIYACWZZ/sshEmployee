package cn.zz.ssh.service;

import cn.zz.ssh.dao.ProductDao;
import cn.zz.ssh.domain.Product;
import org.springframework.transaction.annotation.Transactional;

/**
 * 商品管理的业务层的类
 *
 */
//添加注解事务
@Transactional
public class ProductService {
    private ProductDao productDao;

    //Spring注入
    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    public void save(Product product){
        System.out.println("Service's save execute...");
        productDao.save(product);
    }
}
