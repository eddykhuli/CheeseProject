/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.cheese.cheeseApp.repositories;

import com.app.cheese.cheeseApp.entities.Image;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Reverside
 */
public interface ImageRepository extends CrudRepository<Image, Long> {
    
}
