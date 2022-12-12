package edu.miu.springdata1Assignment.controller;

import edu.miu.springdata1Assignment.aspect.executionTime.ExecutionTime;
import edu.miu.springdata1Assignment.dto.AddressDto;
import edu.miu.springdata1Assignment.entity.Address;
import edu.miu.springdata1Assignment.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/addresses")
@CrossOrigin
public class AddressController {
    private AddressService addressService;

    @GetMapping
    @ExecutionTime
    public List<AddressDto> findAll(){
        return addressService.findAll();
    }
    @GetMapping("/{id}")
    @ExecutionTime
    public AddressDto findById(@PathVariable int id){
        return addressService.findById(id);
    }
    @PostMapping
    @ExecutionTime
    public void save(Address address){
        addressService.save(address);
    }
    @PutMapping("/{id}")
    @ExecutionTime
    public void update(@PathVariable int id, Address address){
        addressService.update(id,address);
    }
    @DeleteMapping("/{id}")
    @ExecutionTime
    public void delete(@PathVariable int id){
        addressService.delete(id);
    }
}
