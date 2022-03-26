package com.hemant.model.mapper;

import com.hemant.model.dto.AirplaneDto;
import com.hemant.entity.Airplane;
import com.hemant.model.request.CreateUpdateAirplaneRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AirplaneMapper {
    AirplaneMapper AIRPLANE_MAPPER = Mappers.getMapper(AirplaneMapper.class);

    AirplaneDto toAirplaneDto(Airplane airplane);

    List<AirplaneDto> toAirplaneDtoList(List<Airplane> airplaneList);

    Airplane createAirplane(CreateUpdateAirplaneRequest request);

    void updateAirplane(@MappingTarget Airplane airplane, CreateUpdateAirplaneRequest request);
}
