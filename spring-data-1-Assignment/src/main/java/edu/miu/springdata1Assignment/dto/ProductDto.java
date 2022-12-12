package edu.miu.springdata1Assignment.dto;

import edu.miu.springdata1Assignment.entity.Category;
import edu.miu.springdata1Assignment.entity.Review;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductDto {
    private int id;
    private String name;
    private int price;
    private double rating;
    private Category category;
    private List<Review> reviews;
}
