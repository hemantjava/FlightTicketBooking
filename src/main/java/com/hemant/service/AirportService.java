package com.hemant.service;

import com.hemant.repository.AirportRepository;
import com.hemant.exception.BussinesException;
import com.hemant.exception.NotFoundException;
import com.hemant.model.dto.AirportDto;
import com.hemant.entity.Airport;
import com.hemant.model.request.CreateUpdateAirportRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.hemant.model.mapper.AirportMapper.AIRPORT_MAPPER;

@Service
@RequiredArgsConstructor
public class AirportService {
    private final AirportRepository repository;

    public AirportDto createAirport(CreateUpdateAirportRequest request){
        Airport airport=AIRPORT_MAPPER.createAirport(request);
        return AIRPORT_MAPPER.toAirportDto(repository.save(airport));
    }
    public AirportDto updateAirport(int id,CreateUpdateAirportRequest request){
        Airport airport=repository.findById(id).orElseThrow(()->new BussinesException("Airport is not found."));
        AIRPORT_MAPPER.updateAirport(airport,request);
        Airport updatedAirport=repository.save(airport);
        return AIRPORT_MAPPER.toAirportDto(updatedAirport);
    }
    public AirportDto getAirportById(int id){
        return AIRPORT_MAPPER.toAirportDto(repository.findById(id).orElseThrow(()-> new NotFoundException("Airport   not found.")));
    }
    public List<AirportDto> getAirportList(){
        return  AIRPORT_MAPPER.toAirportDtoList(repository.findAll());
    }
    public void deleteAirport(int id){
        repository.deleteById(id);
    }



}
