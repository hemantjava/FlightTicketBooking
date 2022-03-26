package com.hemant.model.mapper;

import com.hemant.model.request.CreateUpdateUserRequest;
import com.hemant.model.dto.UserDto;
import com.hemant.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper USER_MAPPER= Mappers.getMapper(UserMapper.class);

    UserDto toUserDto(User user);

    List<UserDto> toUserDtoList(List<User> userList);

    User createUser(CreateUpdateUserRequest request);

    void updateUser(@MappingTarget User user, CreateUpdateUserRequest request);

}
