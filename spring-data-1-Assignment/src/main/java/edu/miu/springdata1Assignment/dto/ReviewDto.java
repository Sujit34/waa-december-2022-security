package edu.miu.springdata1Assignment.dto;

import edu.miu.springdata1Assignment.entity.Product;
import edu.miu.springdata1Assignment.entity.User;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReviewDto {
    private int id;
    private String comment;
    private Product product;
    private User user;
}
