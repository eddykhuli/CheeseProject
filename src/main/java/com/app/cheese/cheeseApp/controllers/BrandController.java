/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.cheese.cheeseApp.controllers;

import com.app.cheese.cheeseApp.entities.Brand;
import com.app.cheese.cheeseApp.repositories.BrandRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/brand/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BrandController {
    
    @Autowired
    private BrandRepository brandRepo;
    
    @RequestMapping(value = "add-brand",method = RequestMethod.POST)
    public Brand addBrand(@RequestBody Brand brand)
    {
        
        brandRepo.save(brand);
        return brand;
    }
    
    @RequestMapping(value = "get-brand/{id}", method = RequestMethod.GET)
    public Brand getBrand(@PathVariable long id)
    {
        Brand foundBrand = brandRepo.findById(id);
        return foundBrand;
    }
    
    @RequestMapping(value = "get-all-brands", method = RequestMethod.GET)
    public List<Brand> getBrands()
    {
        List<Brand> brands = new ArrayList<>();
         brandRepo.findAll().forEach(brands :: add);
      
        return brands;
    }
        
    @RequestMapping(value = "update-brand",method = RequestMethod.POST)
    public Optional<Brand> updates(@RequestBody Brand brand)
    {
        Optional<Brand> foundBrand =  brandRepo.findById(brand.getId());
        if(foundBrand.isPresent())
        {
            foundBrand.get().setName(brand.getName());
            foundBrand.get().setImage(brand.getImage());
  
        }
        brandRepo.save(foundBrand);
        return foundBrand;
    }
    
    
//	@DeleteMapping(path = { "/{id}" })
//	public Employee delete(@PathVariable("id") int id) {
//		Employee deletedEmp = null;
//		for (Employee emp : employees) {
//			if (emp.getEmpId().equals(id)) {
//				employees.remove(emp);
//				deletedEmp = emp;
//				break;
//			}
//		}
//		return deletedEmp;
//	}
    
}
