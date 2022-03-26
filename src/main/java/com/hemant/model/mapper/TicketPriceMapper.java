package com.hemant.model.mapper;

import com.hemant.model.dto.TicketPriceDto;
import com.hemant.entity.TicketPrice;
import com.hemant.model.request.CreateUpdateTicketPriceRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TicketPriceMapper {
    TicketPriceMapper TICKET_PRICE_MAPPER= Mappers.getMapper(TicketPriceMapper.class);

    TicketPriceDto toTicketPriceDto(TicketPrice ticketPrice);

    List<TicketPriceDto> toTicketPriceDtoList(List<TicketPrice> ticketPriceList);

    TicketPrice createTicketPrice(CreateUpdateTicketPriceRequest request);

    void updateTicketPrice(@MappingTarget TicketPrice ticketPrice,CreateUpdateTicketPriceRequest request);


}
