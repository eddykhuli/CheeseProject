/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.cheese.cheeseApp.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Brand implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String image;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Category> categories;
     
     
//    public void addCategories(Category category)
//     {
//         if(categories == null)
//         {
//             categories = new ArrayList<>();
//             categories.add(category);
//         }
//         else if( categories != null)
//         {
//             categories.add(category);
//         }
//     }  
}
