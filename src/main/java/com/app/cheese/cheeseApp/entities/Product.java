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
import org.eclipse.persistence.annotations.BatchFetch;
import org.eclipse.persistence.annotations.JoinFetch;

/**
 *
 * @author Reverside
 */
@Entity
@Data
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String category;
    private long brandId;
    private int quantity = 0;
    private int availInStock;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<ProdSize> sizes;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<ProdColours> colours;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Image> images ;
    
    
//    public void addColours(ProdColours colour)
//    {
//         if(colours == null)
//         {
//             colours = new ArrayList<>();
//             colours.add(colour);
//         }
//         else if( colours != null)
//         {
//             colours.add(colour);
//         }
//     
//        colours.add(colour);
//    }
//     public void addSizes(ProdSize size)
//    {
//         if(sizes == null)
//         {
//             sizes = new ArrayList<>();
//             sizes.add(size);
//         }
//         else if( sizes != null)
//         {
//             sizes.add(size);
//         }
//     
//        sizes.add(size);
//    }
    public void addImages(Image image)
    {
         if(images == null)
         {
             images = new ArrayList<>();
             images.add(image);
         }
         else if( images != null)
         {
             images.add(image);
         }
     
        images.add(image);
    }
}


