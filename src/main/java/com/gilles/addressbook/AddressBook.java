/**
 * Gilles Myny
 */
package com.gilles.addressbook;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class AddressBook {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id = null;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<BuddyInfo> buddyList;

    public AddressBook() {
        buddyList = new ArrayList<>();
    }

    public void addBuddy(BuddyInfo buddy) {
        if(buddy != null) {
            buddyList.add(buddy);
        }
    }

    public BuddyInfo getBuddy(int index) {
        return buddyList.get(index);
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer newId) {
        this.id = newId;
    }

    public List<BuddyInfo> getBuddyList() {
        return this.buddyList;
    }

    public void setBuddyList(List<BuddyInfo> newBuddyList) {
        this.buddyList = newBuddyList;
    }
}
