package com.hemant.service;

import com.hemant.repository.AddressRepository;
import com.hemant.exception.BussinesException;
import com.hemant.exception.NotFoundException;
import com.hemant.model.dto.AddressDto;
import com.hemant.entity.Address;
import com.hemant.model.request.CreateUpdateAddressRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.hemant.model.mapper.AddressMapper.ADDRESS_MAPPER;

/**
 * Address Service
 */
@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository repository;

    public AddressDto createAddress(CreateUpdateAddressRequest request){
        Address address=ADDRESS_MAPPER.createAddress(request);
        return ADDRESS_MAPPER.toAddressDto(repository.save(address));
    }
    public AddressDto updateAddress(int id ,CreateUpdateAddressRequest request){
        Address address=repository.findById(id).orElseThrow(()->new NotFoundException("Not Found"));
        ADDRESS_MAPPER.updateAddress(address,request);

        Address updatedAddress=repository.save(address);
        return ADDRESS_MAPPER.toAddressDto(updatedAddress);
    }
    public AddressDto getAddressById(int id){
        return ADDRESS_MAPPER.toAddressDto(repository.findById(id).orElseThrow(()->new NotFoundException("Address Not Found")));
    }
    public List<AddressDto> getAddressList(){
        return ADDRESS_MAPPER.toAddressDtoList(repository.findAll());
    }

    public void deleteAddress(int id){
        repository.deleteById(id);
    }

    public Address toAddress(int id){
        return repository.findById(id).orElseThrow(()->new BussinesException(""));
    }


}
