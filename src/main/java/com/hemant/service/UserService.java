package com.hemant.service;

import com.hemant.repository.UserRespository;
import com.hemant.exception.NotFoundException;
import com.hemant.model.dto.UserDto;
import com.hemant.entity.User;
import com.hemant.model.request.CreateUpdateUserRequest;
import com.hemant.security.AppUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.hemant.entity.UserRole.ADMIN;
import static com.hemant.model.mapper.UserMapper.USER_MAPPER;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRespository repository;
    private final PasswordEncoder passwordEncoder;

    public UserDto createUser(CreateUpdateUserRequest request){
        User user =USER_MAPPER.createUser(request);
        user.setUserRole(ADMIN);
        user.setUserPassword(passwordEncoder.encode(request.getUserPassword()));
        return USER_MAPPER.toUserDto(repository.save(user));
    }
    public UserDto updateUser(int id, CreateUpdateUserRequest request){
        User user =repository.findById(id).orElseThrow(()->new NotFoundException("User not found."));
        USER_MAPPER.updateUser(user,request);
        User updatedUser =repository.save(user);
        return USER_MAPPER.toUserDto(updatedUser);
    }
    public UserDto getUserById(int id){
        return USER_MAPPER.toUserDto(repository.findById(id).orElseThrow(()-> new NotFoundException("User not found.")));
    }

    public List<UserDto> getUserList(){
        return  USER_MAPPER.toUserDtoList(repository.findAll());
    }

    public void deleteUser(int id){
        repository.deleteById(id);
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user= repository.findByUserEmail(email).orElseThrow(()->new NotFoundException("Email is not found"));
        AppUserDetails appUserDetails =new AppUserDetails(user);
        return appUserDetails;

    }
    }

