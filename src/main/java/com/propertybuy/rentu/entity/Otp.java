package com.propertybuy.rentu.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "otp_table")
public class Otp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userEmail;  // Can also store phone if SMS

    @Column(nullable = false)
    private String otpCode;

    @Column(nullable = false)
    private LocalDateTime expirationTime;

    public Otp() {}

    public Otp(String userEmail, String otpCode, LocalDateTime expirationTime) {
        this.userEmail = userEmail;
        this.otpCode = otpCode;
        this.expirationTime = expirationTime;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }
    public String getOtpCode() { return otpCode; }
    public void setOtpCode(String otpCode) { this.otpCode = otpCode; }
    public LocalDateTime getExpirationTime() { return expirationTime; }
    public void setExpirationTime(LocalDateTime expirationTime) { this.expirationTime = expirationTime; }
}