package com.hemant.service;

import com.hemant.repository.PilotRepository;
import com.hemant.exception.NotFoundException;
import com.hemant.model.dto.PilotDto;
import com.hemant.entity.Pilot;
import com.hemant.model.request.CreateUpdatePilotRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.hemant.model.mapper.PilotMapper.PILOT_MAPPER;
@Service
@RequiredArgsConstructor
public class PilotService {
    private final PilotRepository repository;

    public PilotDto createPilot(CreateUpdatePilotRequest request){
        Pilot pilot=PILOT_MAPPER.createPilot(request);
        return PILOT_MAPPER.toPilotDto(repository.save(pilot));
    }
    public PilotDto updatePilot(int id, CreateUpdatePilotRequest request){
        Pilot pilot=repository.findById(id).orElseThrow(()->new NotFoundException("Pilot   not found."));
        PILOT_MAPPER.updatePilot(pilot,request);
        Pilot updatedpilot=repository.save(pilot);
        return PILOT_MAPPER.toPilotDto(updatedpilot);
    }
    public PilotDto getPilotById(int id){
        return PILOT_MAPPER.toPilotDto(repository.findById(id).orElseThrow(()-> new NotFoundException("Pilot   not found.")));
    }
    public List<PilotDto> getPilotList(){
        return  PILOT_MAPPER.toPilotDtoList(repository.findAll());
    }

    public void deletePilot(int id){
        repository.deleteById(id);
    }

    public void setAvailabilty(int id){
        repository.setAvailable(id,false);
    }
}
