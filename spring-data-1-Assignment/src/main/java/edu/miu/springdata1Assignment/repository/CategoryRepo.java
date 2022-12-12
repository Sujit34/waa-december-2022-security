package edu.miu.springdata1Assignment.repository;

import edu.miu.springdata1Assignment.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends CrudRepository<Category,Integer> {

}
