/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.cheese.cheeseApp.controllers;

import com.app.cheese.cheeseApp.entities.Brand;
import com.app.cheese.cheeseApp.entities.Category;
import com.app.cheese.cheeseApp.repositories.BrandRepository;
import com.app.cheese.cheeseApp.repositories.CategoryRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/category/" )
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoryController {
    
    @Autowired
    private CategoryRepository catRepo;
    @Autowired
    private BrandRepository brandRepo;
    
    @RequestMapping(value = "add-category/{brandId}", method = RequestMethod.POST)
    public Brand addCategory(@PathVariable @Valid long brandId,@RequestBody Category category) {

        Brand foundBrand = brandRepo.findById(brandId);
        Category toAddCat = new Category();
        toAddCat.setId(category.getId());
        toAddCat.setName(category.getName());System.out.println("category........"+category.getName());
//        foundBrand.addCategories(category);
        List<Category> categories = new ArrayList<>();
        categories.add(toAddCat);
        foundBrand.setCategories(categories);
        
        catRepo.save(toAddCat);
        brandRepo.save(foundBrand);
         
        return foundBrand;
    }
    
    @RequestMapping(value = "get-category/{id}", method = RequestMethod.GET)
    public Optional<Category> getCategory(@PathVariable @Valid long id)
    {
        Optional<Category> foundCategory = catRepo.findById(id);
        return foundCategory;
    }
    
    @RequestMapping(value = "get-all-categories", method = RequestMethod.GET)
    public List<Category> getCategories()
    {
        List<Category> categories = new ArrayList<>();
         catRepo.findAll().forEach(categories :: add);
      
        return categories;
    }
    
}
