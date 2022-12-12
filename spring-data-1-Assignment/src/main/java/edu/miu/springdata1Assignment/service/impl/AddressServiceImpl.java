package edu.miu.springdata1Assignment.service.impl;

import edu.miu.springdata1Assignment.dto.AddressDto;
import edu.miu.springdata1Assignment.entity.Address;
import edu.miu.springdata1Assignment.repository.AddressRepo;
import edu.miu.springdata1Assignment.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepo addressRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<AddressDto> findAll(){
        var addresses = (List<Address>) addressRepo.findAll();
        return addresses.stream().map(x->modelMapper.map(x, AddressDto.class)).toList();
    }
    @Override
    public AddressDto findById(int id){
        var address = addressRepo.findById(id);
        return modelMapper.map(address,AddressDto.class);
    }
    @Override
    public void save(Address address){
        addressRepo.save(address);
    }
    @Override
    public void update(int id, Address address){
        addressRepo.findById(id).orElseThrow(() -> new RuntimeException("Address does not exists"));;
        addressRepo.save(address);
    }
    @Override
    public void delete(int id){
        Address address = addressRepo.findById(id).orElseThrow(() -> new RuntimeException("Address does not exists"));
        addressRepo.delete(address);
    }
}
