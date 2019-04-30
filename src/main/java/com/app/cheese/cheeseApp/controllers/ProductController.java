/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.cheese.cheeseApp.controllers;

import com.app.cheese.cheeseApp.entities.Image;
import com.app.cheese.cheeseApp.entities.ProdColours;
import com.app.cheese.cheeseApp.entities.ProdSize;
import com.app.cheese.cheeseApp.entities.Product;
import com.app.cheese.cheeseApp.repositories.ImageRepository;
import com.app.cheese.cheeseApp.repositories.ProdColoursRepository;
import com.app.cheese.cheeseApp.repositories.ProdSizeRepository;
import com.app.cheese.cheeseApp.repositories.ProductRepository;
import com.app.cheese.cheeseApp.repositories.SubCategoryRepository;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Reverside
 */
@RestController
@RequestMapping(path = "/api/product/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController {
    @Autowired
    private ProductRepository prodRepo;
    @Autowired
    private SubCategoryRepository catRepo;
    @Autowired
    private ProdColoursRepository coloursRep;
    @Autowired
    private ProdSizeRepository sizeRepo;
    @Autowired
    private ImageRepository imageRepo;
  
     
    @RequestMapping(value="/add-product/{brandId}", method = RequestMethod.POST)
    private Product saveProduct(@PathVariable long brandId,@RequestBody Product product) {   
        
        product.setBrandId(brandId);         
        prodRepo.save(product);
        return product;
    }
    
    
    
    @RequestMapping(value = "/get-all-products", method = RequestMethod.GET)
    public List<Product> getAllProducts()
    {
        List<Product> products = new ArrayList<>(); 
                prodRepo.findAll().forEach(products :: add);
                return products;
    }
    
    @RequestMapping(value="all-colours" , method = RequestMethod.GET)
    public List<ProdColours> getAllColours()
    {
        List<ProdColours> colours = new ArrayList<>();
        coloursRep.findAll().forEach(colours :: add);
        return colours;
    }
    
     @RequestMapping(value="all-sizes" , method = RequestMethod.GET)
    public List<ProdSize> getAllSizes()
    {
        List<ProdSize> sizes = new ArrayList<>();
        sizeRepo.findAll().forEach(sizes :: add);
        return sizes;
    }

}
