package com.hemant.controller;

import com.hemant.model.dto.UserDto;
import com.hemant.model.request.CreateUpdateUserRequest;
import com.hemant.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto createUser(@RequestBody CreateUpdateUserRequest request){
        return service.createUser(request);
    }
    @GetMapping("{id}")
    public UserDto getUser(@PathVariable int id) {
        return service.getUserById(id);
    }


    @PutMapping("{id}")
    public UserDto updateUser(@PathVariable int id, @RequestBody CreateUpdateUserRequest request){
        return service.updateUser(id,request);
    }

    @GetMapping
    public List<UserDto> getUserList() {
        return service.getUserList();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable  int id){
        service.deleteUser(id);
    }


}
