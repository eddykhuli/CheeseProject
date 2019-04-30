   
package com.app.cheese.cheeseApp.repositories;

import com.app.cheese.cheeseApp.entities.Category;
import com.app.cheese.cheeseApp.entities.SubCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

    public SubCategory getByName(String category);

    public void save(SubCategory categoryObj);
    
}
