/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.cheese.cheeseApp.controllers;

import com.app.cheese.cheeseApp.entities.SubCategory;
import com.app.cheese.cheeseApp.repositories.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/sub_category")
public class SubCategoryController {
   
    @Autowired
    private SubCategoryRepository subCatRepo;
    
    @RequestMapping(path = "/api/sub_category")
    public SubCategory addSubCategory(SubCategory subcat) {
        
        subCatRepo.save(subcat);
        return subcat;
    }
}
