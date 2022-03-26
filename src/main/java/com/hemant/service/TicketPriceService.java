package com.hemant.service;

 import com.hemant.repository.TicketPriceRepository;
 import com.hemant.exception.NotFoundException;
 import com.hemant.model.dto.TicketPriceDto;
 import com.hemant.entity.TicketPrice;
 import com.hemant.model.request.CreateUpdateTicketPriceRequest;
 import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.hemant.model.mapper.TicketPriceMapper.TICKET_PRICE_MAPPER;


@Service
@RequiredArgsConstructor
public class TicketPriceService {
    private final TicketPriceRepository repository;

    public TicketPriceDto createTicketPrice(CreateUpdateTicketPriceRequest request){
        TicketPrice ticketPrice=TICKET_PRICE_MAPPER.createTicketPrice(request);

        return TICKET_PRICE_MAPPER.toTicketPriceDto(repository.save(ticketPrice));
    }
    public TicketPriceDto updateTicketPrice(int id, CreateUpdateTicketPriceRequest request){
        TicketPrice rotation=repository.findById(id).orElseThrow(()->new NotFoundException("TicketPrice not found."));
        TICKET_PRICE_MAPPER.updateTicketPrice(rotation,request);
        TicketPrice updatedrotation=repository.save(rotation);
        return TICKET_PRICE_MAPPER.toTicketPriceDto(updatedrotation);
    }
    public TicketPriceDto getTicketPriceById(int id){
        return TICKET_PRICE_MAPPER.toTicketPriceDto(repository.findById(id).orElseThrow(()-> new NotFoundException("TicketPrice not found.")));
    }
    public List<TicketPriceDto> getTicketPriceList(){
        return  TICKET_PRICE_MAPPER.toTicketPriceDtoList(repository.findAll());
    }
    public void deleteTicketPrice(int id){
        repository.deleteById(id);
    }

}
