package com.work.working_project_1.controller;

import com.work.working_project_1.dto.UserDto;
import com.work.working_project_1.dto.dtoConverter.ToDtoConverter;
import com.work.working_project_1.model.AuthToken;
import com.work.working_project_1.model.LoginUser;
import com.work.working_project_1.security.TokenProvider;
import com.work.working_project_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/signin")
public class AuthenticationController {
    public String currentUsername;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtTokenUtil;

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> register(@RequestBody LoginUser loginUser) throws AuthenticationException {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);
        currentUsername = jwtTokenUtil.getUsernameFromToken(token);
        return ResponseEntity.ok(new AuthToken(token));
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/current-user")
    public ResponseEntity<UserDto> getCurrentUser() {
        UserDto userDto = ToDtoConverter.userToDto(userService.findOne(currentUsername));
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

}
