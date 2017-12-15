/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.sp3.repository;

import demo.sp3.model.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 唐芳华 <fanghua.tang@daydaycook.com>
 */
@Repository
public interface ProductRepo extends JpaRepository<Product,Integer>{

    public List<Product> findByCategoryId(int categoryId);
    
}
