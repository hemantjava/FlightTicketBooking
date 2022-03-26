package com.hemant.controller;

import com.hemant.model.dto.TicketBookingDto;
import com.hemant.model.request.CreateUpdateTicketBookingRequest;
import com.hemant.service.TicketBookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/ticketbookings")
@RequiredArgsConstructor
public class TicketBookingController {
    private final TicketBookingService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TicketBookingDto createTicketBooking(@RequestBody CreateUpdateTicketBookingRequest request){
        return service.createTicketBooking(request);
    }
    @GetMapping("{id}")
    public TicketBookingDto getTicketBooking(@PathVariable int id) {
        return service.getTicketBookingById(id);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PutMapping("{id}")
    public TicketBookingDto updateTicketBooking(@PathVariable int id, @RequestBody CreateUpdateTicketBookingRequest request){
        return service.updateTicketBooking(id,request);
    }

    @GetMapping
    public List<TicketBookingDto> getTicketBookingList() {
        return service.getTicketBookingList();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTicketBooking(@PathVariable  int id){
        service.deleteTicketBooking(id);
    }
}
