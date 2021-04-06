package com.work.working_project_1.controller;

import com.work.working_project_1.service.PhoneVerificationService;
import com.work.working_project_1.service.UserService;
import com.work.working_project_1.twilio.TwilioVerificationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sign-in")
public class TwilioController {

    private final UserService userService;
    private final PhoneVerificationService phoneVerificationService;

    @Autowired
    public TwilioController(UserService userService, PhoneVerificationService phoneVerificationService) {
        this.userService = userService;
        this.phoneVerificationService = phoneVerificationService;
    }

    @PostMapping(value = "/send-otp")
    public ResponseEntity<String> sendOtp(@RequestParam String phoneNumber) {

        TwilioVerificationResult result = phoneVerificationService.startVerification(phoneNumber);
        if (result.isValid()) {
            return new ResponseEntity<>("Otp Sent...", HttpStatus.OK);
        }
        return new ResponseEntity<>("Otp failed to Sent...", HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value = "/verify-otp")
    public ResponseEntity<String> verifyOtp(@RequestParam String phoneNumber, @RequestParam String otp) {

        TwilioVerificationResult result = phoneVerificationService.checkVerification(phoneNumber, otp);
        if (result.isValid()) {
            return new ResponseEntity<>("Your number successfully verified", HttpStatus.OK);
        }
        return new ResponseEntity<>("Something went wrong / Incorrect verification code", HttpStatus.BAD_REQUEST);
    }

}
