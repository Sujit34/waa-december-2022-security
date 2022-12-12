package edu.miu.springdata1Assignment.service;

import edu.miu.springdata1Assignment.dto.ProductDto;
import edu.miu.springdata1Assignment.entity.Product;
import edu.miu.springdata1Assignment.entity.Review;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    public List<ProductDto> findAll();
    public ProductDto findById(int id);
    public void save(Product product);
    public void update(int id, Product product);
    public void delete(int id);
    public  List<Product> findByPriceGreaterThan(double price);
    public List<Product> findByCategory_NameAndPriceLessThan(String name, double price);
    public List<Product> findByNameContaining(String name);

    public List<Review> findByProduct_Id(int id);

}
