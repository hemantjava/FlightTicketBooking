package com.hemant.model.mapper;

import com.hemant.model.dto.TicketBookingDto;
import com.hemant.entity.TicketBooking;
import com.hemant.model.request.CreateUpdateTicketBookingRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TicketBookingMapper {

    TicketBookingMapper TICKET_BOOKING_MAPPER= Mappers.getMapper(TicketBookingMapper.class);

    TicketBookingDto toTicketBookingDto(TicketBooking ticketBooking);

    List<TicketBookingDto> toTicketBookingDtoList(List<TicketBooking> ticketBookingList);

    TicketBooking createTicketBooking(CreateUpdateTicketBookingRequest request);

    void updateTicketBooking(@MappingTarget TicketBooking ticketBooking,CreateUpdateTicketBookingRequest request);

}
