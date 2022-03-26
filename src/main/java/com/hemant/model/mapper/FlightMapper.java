package com.hemant.model.mapper;

import com.hemant.entity.Flight;
import com.hemant.model.request.CreateUpdateFlightRequest;
import com.hemant.model.dto.FlightDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FlightMapper {
    FlightMapper FLIGHT_MAPPER= Mappers.getMapper(FlightMapper.class);

    FlightDto toFlightDto(Flight flight);

    List<FlightDto> toFlightDtoList(List<Flight> flightList);

    Flight createFlight(CreateUpdateFlightRequest request);

    void updateFlight(@MappingTarget Flight flight,CreateUpdateFlightRequest createUpdateFlightRequest);

}
