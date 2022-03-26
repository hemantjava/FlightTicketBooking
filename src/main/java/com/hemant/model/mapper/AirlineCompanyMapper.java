package com.hemant.model.mapper;

import com.hemant.entity.AirlineCompany;
import com.hemant.model.request.CreateUpdateAirlineCompanyRequest;
import com.hemant.model.dto.AirlineCompanyDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AirlineCompanyMapper {

    AirlineCompanyMapper AIRLINE_COMPANY_MAPPER = Mappers.getMapper(AirlineCompanyMapper.class);

    AirlineCompanyDto toAirlaneCompanyDto(AirlineCompany airlineCompany);

    List<AirlineCompanyDto> toAirlaneCompanyDtoList(List<AirlineCompany> airlineCompany);

    AirlineCompany createAirlineCompany(CreateUpdateAirlineCompanyRequest request);

    void updateAirlineCompany(@MappingTarget AirlineCompany airlineCompany,CreateUpdateAirlineCompanyRequest request);
}
