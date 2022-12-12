package edu.miu.springdata1Assignment.service.impl;

import edu.miu.springdata1Assignment.dto.ProductDto;
import edu.miu.springdata1Assignment.entity.Product;
import edu.miu.springdata1Assignment.entity.Review;
import edu.miu.springdata1Assignment.repository.ProductRepo;
import edu.miu.springdata1Assignment.repository.ReviewRepo;
import edu.miu.springdata1Assignment.repository.UserRepo;
import edu.miu.springdata1Assignment.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@PreAuthorize("hasRole('ROLE_USER') || hasRole('ROLE_ADMIN')")
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;
    private final ReviewRepo reviewRepo;
    private final ModelMapper modelMapper;
    private final UserRepo userRepo;

    @Override
    public List<ProductDto> findAll(){
        var products = (List<Product>) productRepo.findAll();
        return products.stream().map(x->modelMapper.map(x,ProductDto.class)).toList();

    }

    @Override
    public ProductDto findById(int id){
        var product = productRepo.findById(id);
        return modelMapper.map(product,ProductDto.class);
    }

    @Override
    public void save(Product product){
        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email;
        if(user instanceof UserDetails){
            email = ((UserDetails) user).getUsername();
        }else{
            email = user.toString();
        }
        product.setUser(userRepo.findByEmail(email));
        productRepo.save(product);
    }

    @Override
    public void update(int id, Product product){
        productRepo.findById(id).orElseThrow(() -> new RuntimeException("Product does not exists"));;
        productRepo.save(product);
    }

    @Override
    public void delete(int id){
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product does not exists"));
        productRepo.delete(product);
    }

    @Override
    public  List<Product> findByPriceGreaterThan(double price){
        return productRepo.findByPriceGreaterThan(price);
    }
    @Override
    public List<Product> findByCategory_NameAndPriceLessThan(String name, double price){
        return productRepo.findByPriceLessThanAndCategory_Name(name,price);
    }
    @Override
    public List<Product> findByNameContaining(String name){
        return productRepo.findByNameContaining(name);
    }

    @Override
    public List<Review> findByProduct_Id(int id){
        return reviewRepo.findByProduct_Id(id);
    }


}
