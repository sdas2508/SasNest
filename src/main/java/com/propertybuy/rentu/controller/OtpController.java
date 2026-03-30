package com.propertybuy.rentu.controller;

import com.propertybuy.rentu.service.OtpService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/otp")
public class OtpController {

    @Autowired
    private OtpService otpService;

    @PostMapping("/send")
    public Map<String,String> sendOTP(@RequestParam String email){
        String otp = otpService.generateOTP(email);
        // TODO: send OTP via Email or SMS using Spring Mail 
        System.out.println("OTP for " + email + " is: " + otp);

        Map<String,String> response = new HashMap<>();
        response.put("message","OTP sent successfully");
        return response;
    }

    @PostMapping("/verify")
    public Map<String,String> verifyOTP(@RequestParam String email, @RequestParam String otpCode){
        boolean isValid = otpService.verifyOTP(email, otpCode);
        Map<String,String> response = new HashMap<>();
        response.put("status", isValid ? "success" : "failure");
        return response;
    }
}