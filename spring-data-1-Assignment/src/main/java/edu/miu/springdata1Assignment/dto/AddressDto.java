package edu.miu.springdata1Assignment.dto;

import edu.miu.springdata1Assignment.entity.User;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDto {
    private int id;
    private String street;
    private String zip;
    private String city;
    private User user;
}
