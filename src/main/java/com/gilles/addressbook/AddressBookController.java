package com.gilles.addressbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AddressBookController {
    @Autowired
    private AddressBookService addressBookService;

    @PostMapping("/addressbooks")
    public AddressBook saveAddressBook() {
        return addressBookService.saveAddressBook(new AddressBook());
    }

    @GetMapping("/addressbooks")
    public List<AddressBook> fetchAddressBookList() {
        return addressBookService.fetchAddressBookList();
    }

    @GetMapping("/addressbooks/{id}")
    public Optional<AddressBook> fetchAddressBookById(@PathVariable("id") Integer addressBookId) {
        return addressBookService.fetchAddressBookById(addressBookId);
    }

    @PutMapping("/addressbooks/{id}/{bid}")
    public String updateAddressBook(@PathVariable("bid") Integer buddyInfoId, @PathVariable("id") Integer addressBookId) {
        addressBookService.addToAddressBook(buddyInfoId, addressBookId);
        return "Added Successfully";
    }

    @DeleteMapping("/addressbooks/{id}")
    public String deleteAddressBookById(@PathVariable("id") Integer addressBookId) {
        addressBookService.deleteAddressBookById(addressBookId);
        return "Deleted Successfully";
    }
}
