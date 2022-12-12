package edu.miu.springdata1Assignment.dto;

import edu.miu.springdata1Assignment.entity.Address;
import edu.miu.springdata1Assignment.entity.Review;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class UserDto {

    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastname;
    private List<Review> reviews;
    private Address address;
}
