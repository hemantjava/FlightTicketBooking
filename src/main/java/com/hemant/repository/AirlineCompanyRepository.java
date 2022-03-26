package com.hemant.repository;

import com.hemant.entity.AirlineCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirlineCompanyRepository extends JpaRepository<AirlineCompany,Integer> {
}
