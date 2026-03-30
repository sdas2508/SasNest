package com.propertybuy.rentu.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "OwnerTable")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "OwnerName", nullable = false)
    private String ownerName;

    @Column(name = "OwnerEmail", nullable = false, unique = true)
    private String ownerEmail;

    @Column(name = "OwnerMobileNumber", nullable = false, unique = true)
    private String ownerMobileNumber;

    @Column(name = "OwnerPassword", nullable = false)
    private String ownerPassword;

    public Owner() {}

    // ---------- Getters & Setters ----------

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

    public String getOwnerPassword() {
        return ownerPassword;
    }

    public void setOwnerPassword(String ownerPassword) {
        this.ownerPassword = ownerPassword;
    }
}
