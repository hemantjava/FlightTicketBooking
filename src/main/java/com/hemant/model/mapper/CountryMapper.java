package com.hemant.model.mapper;

import com.hemant.entity.Country;
import com.hemant.model.request.CreateUpdateCountryRequest;
import com.hemant.model.dto.CountryDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")

public interface CountryMapper {

    CountryMapper COUNTRY_MAPPER= Mappers.getMapper(CountryMapper.class);

    CountryDto toCountryDto(Country country);

    List<CountryDto> toCountryDtoList(List<Country> countryList);

    Country createCountry(CreateUpdateCountryRequest request);

    void updateCountry(@MappingTarget Country country,CreateUpdateCountryRequest request);

}
