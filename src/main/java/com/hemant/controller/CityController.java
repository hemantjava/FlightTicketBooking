package com.hemant.controller;

import com.hemant.service.CityService;
import com.hemant.model.dto.CityDto;
import com.hemant.model.request.CreateUpdateCityRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cities")
@RequiredArgsConstructor
public class CityController {
    private final CityService service;


    @GetMapping("{id}")
    public CityDto getCity(@PathVariable int id) {
        return service.getCityById(id);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PutMapping("{id}")
    public CityDto updateCity(@PathVariable int id,@RequestBody CreateUpdateCityRequest request){
       return service.updateCity(id,request);
    }

    @GetMapping
    public List<CityDto> getCityList() {
        return service.getCityList();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCity(@PathVariable  int id){
        service.deleteCity(id);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CityDto createCity(@RequestBody CreateUpdateCityRequest request){
        return service.createCity(request);
    }



}
