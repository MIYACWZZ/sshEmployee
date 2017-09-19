package cn.zz.ssh.dao;

import cn.zz.ssh.domain.Product;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;


public class ProductDao extends HibernateDaoSupport {


    /**
     * DAO中保存商品的方法
     * @param product
     */
    public void save(Product product){
        System.out.println("DAO中的save执行...");
        //调用集成的HibernateDaoSupport中的模板的save方法去持久化对象
        getHibernateTemplate().save(product);
    }
}
