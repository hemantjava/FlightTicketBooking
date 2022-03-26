package com.hemant.repository;

import com.hemant.entity.TicketBooking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketBookingRepository extends JpaRepository<TicketBooking,Integer> {
    List<TicketBooking> findByFlightId(int id) ;
}
