package com.propertybuy.rentu.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "propertyownerlist") // maps to your MySQL table
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "OwnerName", nullable = false)
    private String ownerName;

    @Column(name = "OwnerEmailId", nullable = false)
    private String ownerEmail;

    @Column(name = "OwnerContactNo", nullable = false)
    private String ownerMobileNumber;

    public Property() {}

    public Property(Long id, String ownerName, String ownerEmail, String ownerMobileNumber) {
        this.id = id;
        this.ownerName = ownerName;
        this.ownerEmail = ownerEmail;
        this.ownerMobileNumber = ownerMobileNumber;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public String getOwnerMobileNumber() {
        return ownerMobileNumber;
    }

    public void setOwnerMobileNumber(String ownerMobileNumber) {
        this.ownerMobileNumber = ownerMobileNumber;
    }
}
