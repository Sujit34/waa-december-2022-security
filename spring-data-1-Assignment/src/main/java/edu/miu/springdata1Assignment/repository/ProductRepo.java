package edu.miu.springdata1Assignment.repository;

import edu.miu.springdata1Assignment.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends CrudRepository<Product,Integer> {

    List<Product> findByPriceGreaterThan(double price);
    List<Product> findByPriceLessThanAndCategory_Name(String name, double price);
    List<Product> findByNameContaining(String name);

}
