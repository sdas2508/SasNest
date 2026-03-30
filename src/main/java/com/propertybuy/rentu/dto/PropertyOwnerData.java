package com.propertybuy.rentu.dto;

public class PropertyOwnerData {

    private Long id;
    private String ownerName;
    private String ownerEmail;
    private String ownerMobileNumber;

    public PropertyOwnerData() {}

    public PropertyOwnerData(Long id, String ownerName, String ownerEmail, String ownerMobileNumber) {
        this.id = id;
        this.ownerName = ownerName;
        this.ownerEmail = ownerEmail;
        this.ownerMobileNumber = ownerMobileNumber;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public String getOwnerMobileNumber() {
        return ownerMobileNumber;
    }
}
