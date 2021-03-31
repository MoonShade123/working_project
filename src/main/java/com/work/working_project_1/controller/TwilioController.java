package com.work.working_project_1.controller;

import com.work.working_project_1.dto.UserDto;
import com.work.working_project_1.model.User;
import com.work.working_project_1.service.PhoneVerificationService;
import com.work.working_project_1.service.UserService;
import com.work.working_project_1.twilio.TwilioVerificationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/sign-in")
public class TwilioController {

    private final UserService userService;
    private final PhoneVerificationService phoneVerificationService;

    @Autowired
    public TwilioController(UserService userService, PhoneVerificationService phoneVerificationService) {
        this.userService = userService;
        this.phoneVerificationService = phoneVerificationService;
    }

    @PostMapping("/send-otp")
    public ResponseEntity<String> sendOtp(@RequestBody final User user) {

        TwilioVerificationResult result = phoneVerificationService.startVerification(this.userService.findByPhoneNumber(user.getPhoneNumber()));
        if (result.isValid()) {
            return new ResponseEntity<>("Otp Sent...", HttpStatus.OK);
        }
        return new ResponseEntity<>("Otp failed to Sent...", HttpStatus.BAD_REQUEST);
    }

}
