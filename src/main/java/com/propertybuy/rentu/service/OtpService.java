package com.propertybuy.rentu.service;

import com.propertybuy.rentu.entity.Otp;
import com.propertybuy.rentu.repository.OtpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class OtpService {

    @Autowired
    private OtpRepository otpRepository;

    @Autowired
    private JavaMailSender mailSender; // Add this

    private static final int EXPIRATION_MINUTES = 5;

    // Generate a 6-digit OTP and send email
    public String generateOTP(String userEmail) {
        Random random = new Random();
        int otpInt = 100000 + random.nextInt(900000);
        String otpCode = String.valueOf(otpInt);

        LocalDateTime expirationTime = LocalDateTime.now().plusMinutes(EXPIRATION_MINUTES);

        // Remove previous OTP if exists
        otpRepository.deleteByUserEmail(userEmail);

        // Save new OTP
        Otp otp = new Otp(userEmail, otpCode, expirationTime);
        otpRepository.save(otp);

        // Send OTP via email
        sendOtpEmail(userEmail, otpCode);

        return otpCode;
    }

    // Verify OTP
    public boolean verifyOTP(String userEmail, String otpCode) {
        return otpRepository.findByUserEmail(userEmail)
                .map(otp -> {
                    if (otp.getExpirationTime().isBefore(LocalDateTime.now())) {
                        otpRepository.delete(otp); // remove expired
                        return false;
                    }
                    boolean match = otp.getOtpCode().equals(otpCode);
                    if (match) otpRepository.delete(otp); // remove after successful verification
                    return match;
                })
                .orElse(false);
    }

    // Helper method to send email
    private void sendOtpEmail(String toEmail, String otpCode) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(toEmail);
            message.setSubject("Your OTP Code for SasNest");
            message.setText("Your OTP is: " + otpCode + "\nIt expires in 5 minutes.");
            mailSender.send(message);

            System.out.println("OTP sent to email: " + toEmail); // log for debugging
        } catch (Exception e) {
            System.out.println("Failed to send OTP email: " + e.getMessage());
        }
    }
}