package edu.miu.springdata1Assignment.service;

import edu.miu.springdata1Assignment.dto.AddressDto;
import edu.miu.springdata1Assignment.entity.Address;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {
    public List<AddressDto> findAll();
    public AddressDto findById(int id);
    public void save(Address address);
    public void update(int id, Address address);
    public void delete(int id);
}
