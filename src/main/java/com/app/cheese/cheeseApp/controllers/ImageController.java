/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.cheese.cheeseApp.controllers;

import com.app.cheese.cheeseApp.entities.Image;
import com.app.cheese.cheeseApp.entities.Product;
import com.app.cheese.cheeseApp.repositories.ImageRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/image/" )
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ImageController {
    @Autowired
    private ImageRepository imageRepo; 
            
     @RequestMapping(value = "/get-all-images", method = RequestMethod.GET)
    public List<Image> getAllProducts()
    {
        List<Image> images = new ArrayList<>(); 
        imageRepo.findAll().forEach(images :: add);
        return images;
    }
    
}
