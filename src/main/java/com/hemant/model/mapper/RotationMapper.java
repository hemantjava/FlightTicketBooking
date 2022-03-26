package com.hemant.model.mapper;

import com.hemant.model.dto.RotationDto;
import com.hemant.entity.Rotation;
import com.hemant.model.request.CreateUpdateRotationRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RotationMapper {

    RotationMapper ROTATION_MAPPER= Mappers.getMapper(RotationMapper.class);

    RotationDto toRotationDto(Rotation rotation);

    List<RotationDto> toRotationDtoList(List<Rotation> rotationList);

    Rotation createRotation(CreateUpdateRotationRequest request);

    void updateRotation(@MappingTarget Rotation rotation,CreateUpdateRotationRequest request);


}
