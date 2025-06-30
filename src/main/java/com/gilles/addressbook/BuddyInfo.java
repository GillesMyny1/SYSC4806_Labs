/**
 * Gilles Myny
 */
package com.gilles.addressbook;

import jakarta.persistence.*;

@Entity
public class BuddyInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id = null;
    private String name;
    private String address;
    private Integer phoneNumber;

    public BuddyInfo() {
    }

    public BuddyInfo(String name, String address, Integer phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer newId) {
        this.id = newId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String newAddress) {
        this.address = newAddress;
    }

    public Integer getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(Integer newPhoneNumber) {
        this.phoneNumber = newPhoneNumber;
    }
}
