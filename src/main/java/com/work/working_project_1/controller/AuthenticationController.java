package com.work.working_project_1.controller;

import com.work.working_project_1.dto.UserDto;
import com.work.working_project_1.dto.dtoConverter.ToDtoConverter;
import com.work.working_project_1.model.AuthToken;
import com.work.working_project_1.model.LoginUser;
import com.work.working_project_1.model.User;
import com.work.working_project_1.security.TokenProvider;
import com.work.working_project_1.service.PhoneVerificationService;
import com.work.working_project_1.service.UserService;
import com.work.working_project_1.twilio.TwilioVerificationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sign-in")
public class AuthenticationController {
    public String currentUsername;

    private final AuthenticationManager authenticationManager;
    private final TokenProvider jwtTokenUtil;
    private final UserService userService;
    private final PhoneVerificationService phoneVerificationService;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, TokenProvider jwtTokenUtil, UserService userService, PhoneVerificationService phoneVerificationService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userService = userService;
        this.phoneVerificationService = phoneVerificationService;
    }

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
        TwilioVerificationResult result = phoneVerificationService.startVerification(String.valueOf(userService.getPhoneNumberByUsername(currentUsername)));
        if (result.isValid()) {
            return new ResponseEntity<>("Otp Sent...", HttpStatus.OK);
        }
        return new ResponseEntity<>("Otp failed to Sent...", HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value = "/verify-otp")
    public ResponseEntity<?> verifyOtp(@RequestParam String password, @RequestParam String phoneNumber, @RequestParam String code) {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userService.getUsernameByPhoneNumber(phoneNumber),
                        password
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);
        currentUsername = jwtTokenUtil.getUsernameFromToken(token);

        TwilioVerificationResult result = phoneVerificationService.checkVerification(phoneNumber, code);
        if (result.isValid()) {
            return new ResponseEntity<>(new AuthToken(token), HttpStatus.OK);
        }
        return new ResponseEntity<>("Something went wrong / Incorrect verification code", HttpStatus.BAD_REQUEST);
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/current-user")
    public ResponseEntity<UserDto> getCurrentUser() {
        UserDto userDto = ToDtoConverter.userToDto(userService.findOne(currentUsername));
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

}
