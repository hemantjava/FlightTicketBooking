package com.hemant.model.mapper;


import com.hemant.entity.Address;
import com.hemant.model.request.CreateUpdateAddressRequest;
import com.hemant.model.dto.AddressDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressMapper ADDRESS_MAPPER= Mappers.getMapper(AddressMapper.class);

    AddressDto toAddressDto(Address address);

    List<AddressDto> toAddressDtoList(List<Address> addressList);

    Address createAddress(CreateUpdateAddressRequest request);

    void  updateAddress(@MappingTarget Address address,CreateUpdateAddressRequest request);

}
