package edu.miu.springdata1Assignment.dto;

import edu.miu.springdata1Assignment.entity.Product;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoryDto {
    private int id;
    private String name;
    private List<Product> products;
}
