package com.work.working_project_1.controller;

import com.work.working_project_1.dto.UserDto;
import com.work.working_project_1.model.User;
import com.work.working_project_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public void signUpUser(@RequestBody final User user) {
        this.userService.signUp(user);
    }

    @GetMapping
    public ResponseEntity<Collection<UserDto>> getAllUsers() {
        return new ResponseEntity<>(this.userService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable final Long id) {
        return new ResponseEntity<>(this.userService.getById(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<UserDto> updateUser(@RequestBody final User user) {
        return new ResponseEntity<>(this.userService.update(user), HttpStatus.OK);
    }
}
