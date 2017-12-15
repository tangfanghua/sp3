/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.sp3.service;

import demo.sp3.model.Category;
import demo.sp3.model.Product;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import demo.sp3.repository.CategoryRepo;
import demo.sp3.repository.ProductRepo;

/**
 *
 * @author 唐芳华 <fanghua.tang@daydaycook.com>
 */
@Named
public class ProductService {

    @Inject
    CategoryRepo categoryRepo;

    @Inject
    ProductRepo productRepo;

    public List<Product> findByCategory(int categoryId) {
        List<Product> ret = productRepo.findByCategoryId(categoryId);
        return ret;
    }

    @Transactional
    public void addCategory(Category c) {
        categoryRepo.save(c);
    }
    
    @Transactional
    public void addProduct(Product p){
        productRepo.save(p);
    }
}
