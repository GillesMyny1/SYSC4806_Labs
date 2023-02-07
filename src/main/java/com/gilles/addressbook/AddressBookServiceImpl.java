package com.gilles.addressbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AddressBookServiceImpl implements AddressBookService {
    @Autowired
    private AddressBookRepository addressBookRepository;
    @Autowired
    private BuddyInfoRepository buddyInfoRepository;

    // save
    @Override
    public AddressBook saveAddressBook(AddressBook addressBook) {
        return addressBookRepository.save(addressBook);
    }

    // read
    @Override
    public List<AddressBook> fetchAddressBookList() {
        return (List<AddressBook>) addressBookRepository.findAll();
    }

    // put
    @Override
    public void addToAddressBook(Integer buddyInfoId, Integer addressBookId) {
        AddressBook addBook = addressBookRepository.findById(addressBookId).get();
        BuddyInfo addBuddy = buddyInfoRepository.findById(buddyInfoId).get();
        addBook.addBuddy(addBuddy);
        addressBookRepository.save(addBook);
    }

    @Override
    public void deleteAddressBookById(Integer addressBookId) {
        addressBookRepository.deleteById(addressBookId);
    }
}
