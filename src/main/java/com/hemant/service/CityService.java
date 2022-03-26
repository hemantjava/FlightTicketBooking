package com.hemant.service;

import com.hemant.repository.CityRepository;
import com.hemant.exception.BussinesException;
import com.hemant.exception.NotFoundException;
import com.hemant.model.dto.CityDto;
import com.hemant.entity.City;
import com.hemant.model.request.CreateUpdateCityRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.hemant.model.mapper.CityMapper.CITY_MAPPER;


@Service
@RequiredArgsConstructor
public class CityService {
    private final CityRepository repository;

    public CityDto createCity(CreateUpdateCityRequest request){
        City city=CITY_MAPPER.createCity(request);
        return CITY_MAPPER.toCityDto(repository.save(city));
    }
    public CityDto updateCity(int id,CreateUpdateCityRequest request){
       City city=repository.findById(id).orElseThrow(()->new BussinesException("City is not found."));
        CITY_MAPPER.updateCity(city,request);
       City updatedcity=repository.save(city);
        return CITY_MAPPER.toCityDto(updatedcity);
    }
    public CityDto getCityById(int id){
        return CITY_MAPPER.toCityDto(repository.findById(id).orElseThrow(()-> new NotFoundException("City  not found.")));
    }
    public List<CityDto> getCityList(){
        return  CITY_MAPPER.toCityDtoList(repository.findAll());
    }
    public void deleteCity(int id){
        repository.deleteById(id);
    }
}
