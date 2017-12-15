/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.sp3;

import demo.sp3.model.Category;
import demo.sp3.model.Product;
import demo.sp3.service.ProductService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author 唐芳华 <fanghua.tang@daydaycook.com>
 */
public class App {

    public static void main(String[] argv) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        ProductService ps = ctx.getBean(ProductService.class);
        Category c = new Category();
        c.setName("分类一");
        ps.addCategory(c);
        Product p = new Product();
        p.setName("商品1");
        p.setCategory(c);
        ps.addProduct(p);
        final List<Product> pl = ps.findByCategory(c.getId());
        System.out.println("pl:" + StringUtils.join(pl, "\n"));
    }
}
