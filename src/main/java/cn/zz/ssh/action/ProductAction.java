package cn.zz.ssh.action;

import cn.zz.ssh.domain.Product;
import cn.zz.ssh.service.ProductService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


/**
 * 商品管理Action
 */

public class ProductAction extends ActionSupport implements ModelDriven<Product> {
    //模型驱动需要使用的类
    private Product product = new Product();
    //ModelDriven 必须重写该方法
    @Override
    public Product getModel() {
        return product;
    }


    // struts和spring整合过程中按名称自动注入的业务层类
    private ProductService productService;

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public String save(){
        System.out.println("ProductAction之星save..."+product.getPname());
        productService.save(product);

        return NONE;
    }

}
