package com.hemant.service;

import com.hemant.repository.AirplaneRepository;
import com.hemant.exception.NotFoundException;
import com.hemant.model.dto.AirplaneDto;
import com.hemant.entity.Airplane;
import com.hemant.model.request.CreateUpdateAirplaneRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.hemant.model.mapper.AirplaneMapper.AIRPLANE_MAPPER;

@Service
@RequiredArgsConstructor
public class AirplaneService {
    private final AirplaneRepository repository;

    public AirplaneDto createAirplane(CreateUpdateAirplaneRequest request){
        Airplane airplane=AIRPLANE_MAPPER.createAirplane(request);
        return AIRPLANE_MAPPER.toAirplaneDto(repository.save(airplane));
    }
    public AirplaneDto updateAirplane(int id ,CreateUpdateAirplaneRequest request){
        Airplane airplane=repository.findById(id).orElseThrow(()->new NotFoundException("Not Found"));
        AIRPLANE_MAPPER.updateAirplane(airplane,request);
        Airplane updatedAirplane=repository.save(airplane);
        return AIRPLANE_MAPPER.toAirplaneDto(updatedAirplane);
    }
    public AirplaneDto getAirplaneById(int id){
        return AIRPLANE_MAPPER.toAirplaneDto(repository.findById(id).orElseThrow(()->new NotFoundException("Airplane not found")));
    }
    public List<AirplaneDto> getAirplaneList(){ return AIRPLANE_MAPPER.toAirplaneDtoList(repository.findAll()); }

    public void deleteAirplane(int id){  repository.deleteById(id);}

    public void setAvailabilty(int id){
        repository.setAvailable(id,false);
    }

}
