package com.hemant.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AirportDto {
    private int  id;

    private String name;

    private String details;

    private int  cityId;

    private int gateCapacity;

}
