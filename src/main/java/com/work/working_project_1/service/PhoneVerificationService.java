package com.work.working_project_1.service;

import com.twilio.exception.ApiException;
import com.twilio.rest.verify.v2.service.Verification;
import com.twilio.rest.verify.v2.service.VerificationCheck;
import com.work.working_project_1.twilio.TwilioConfiguration;
import com.work.working_project_1.twilio.TwilioVerificationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhoneVerificationService {

    private final TwilioConfiguration twilioConfiguration;
    private final UserService userService;

    @Autowired
    public PhoneVerificationService(TwilioConfiguration twilioConfiguration, UserService userService) {
        this.twilioConfiguration = twilioConfiguration;
        this.userService = userService;
    }

    public TwilioVerificationResult startVerification(String phoneNumber) {
        try {
            Verification verification = Verification.creator(twilioConfiguration.getServiceId(), phoneNumber, "sms").create();
            if ("approved".equals(verification.getStatus()) || "pending".equals(verification.getStatus())) {
                return new TwilioVerificationResult(verification.getSid());
            }
        } catch (ApiException exception) {
            return new TwilioVerificationResult(new String[] {exception.getMessage()});
        }
        return null;
    }

    public TwilioVerificationResult checkVerification(String phoneNumber, String otp) {
        try {
            VerificationCheck verificationCheck = VerificationCheck.creator(twilioConfiguration.getServiceId(), otp).setTo(phoneNumber).create();
            if ("approved".equals(verificationCheck.getStatus())) {
                return new TwilioVerificationResult(verificationCheck.getSid());
            }
            return new TwilioVerificationResult(new String[]{"Invalid code."});
        } catch (ApiException exception) {
            return new TwilioVerificationResult(new String[]{exception.getMessage()});
        }
    }
}
