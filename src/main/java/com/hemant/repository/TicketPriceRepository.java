package com.hemant.repository;

import com.hemant.entity.TicketPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketPriceRepository extends JpaRepository<TicketPrice,Integer> {
}
