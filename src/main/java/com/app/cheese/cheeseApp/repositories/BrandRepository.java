/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.cheese.cheeseApp.repositories;

import com.app.cheese.cheeseApp.entities.Brand;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends CrudRepository<Brand, Long>{

    public Brand save(Brand foundBrand);
    public Brand findById(long id);

    public void save(Optional<Brand> foundBrand);
    
}
