/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.cheese.cheeseApp.entities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;
/**
 *
 * @author Reverside
 */
@Entity
@Data
public class SubCategory implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
//    @OneToMany   
//    private Product products;
    
//    public void addProducts(Product product)
//     {
//         if(products == null)
//         {
//             products = new ArrayList<>();
//             products.add(product);
//         }
//         else if( products != null)
//         {
//             products.add(product);
//         }
//     }  

    
    
}



