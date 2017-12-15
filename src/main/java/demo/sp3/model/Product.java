/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.sp3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author 唐芳华 <fanghua.tang@daydaycook.com>
 */
@Entity
@Table(name="product")
public class Product implements java.io.Serializable{

    @Id
    @Column(name="id")
    @NotNull
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column
    @NotNull
    private String name;
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + '}';
    }

}
